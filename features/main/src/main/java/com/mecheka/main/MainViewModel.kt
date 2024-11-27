package com.mecheka.main

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.OutOfQuotaPolicy
import androidx.work.WorkManager
import com.mecheka.domain.character.GetAllCharacterUseCase
import com.mecheka.domain.character.model.Character
import com.mecheka.domain.character.model.Location
import com.mecheka.domain.location.GetAllLocationUseCase
import com.mecheka.main.worker.HiltWorker
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn

@HiltViewModel
class MainViewModel @Inject constructor (
    private val getAllCharacterUseCase: GetAllCharacterUseCase,
    private val getAllLocationUseCase: GetAllLocationUseCase,
    private val randomNumber: RandomNumber,
    @ApplicationContext private val context: Context
) : ViewModel() {
    private val characterFlow = MutableStateFlow<UiState<List<Character>>>(UiState.Loading)
    private val locationFlow = MutableStateFlow<UiState<List<Location>>>(UiState.Loading)
    val character: StateFlow<UiState<List<Character>>> = characterFlow
    val locations: StateFlow<UiState<List<Location>>> = locationFlow
    val isLoading = combine(listOf(characterFlow, locationFlow)) { flow ->
        flow.any { it is UiState.Loading }
    }.stateIn(viewModelScope, SharingStarted.Eagerly, true)

    fun loadAllCharacter() {
        Log.d("Random number", "Random number: ${randomNumber.number}")
        val workRequest  = OneTimeWorkRequestBuilder<HiltWorker>()
            .setExpedited(OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST)
            .build()
        WorkManager.getInstance(context).enqueue(workRequest)
        getAllCharacterUseCase()
            .onEach { result ->
                result.onSuccess {
                    characterFlow.value = UiState.Success(it.take(5))
                }.onFailure {
                    characterFlow.value = UiState.Error(it)
                }
            }.launchIn(viewModelScope)
    }

    fun getAllLocation() {
        getAllLocationUseCase()
            .onEach { result ->
                result.onSuccess {
                    locationFlow.value = UiState.Success(it.take(5))
                }.onFailure {
                    locationFlow.value = UiState.Error(it)
                }
            }.launchIn(viewModelScope)
    }
}
