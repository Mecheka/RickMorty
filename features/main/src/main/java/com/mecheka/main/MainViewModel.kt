package com.mecheka.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mecheka.domain.character.GetAllCharacterUseCase
import com.mecheka.domain.character.model.Character
import com.mecheka.domain.character.model.Location
import com.mecheka.domain.location.GetAllLocationUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn

class MainViewModel(
    private val getAllCharacterUseCase: GetAllCharacterUseCase,
    private val getAllLocationUseCase: GetAllLocationUseCase,
) : ViewModel() {
    private val characterFlow = MutableStateFlow<UiState<List<Character>>>(UiState.Loading)
    private val locationFlow = MutableStateFlow<UiState<List<Location>>>(UiState.Loading)
    val character: StateFlow<UiState<List<Character>>> = characterFlow
    val locations: StateFlow<UiState<List<Location>>> = locationFlow
    val isLoading = combine(listOf(characterFlow, locationFlow)) { flow ->
        flow.any { it is UiState.Loading }
    }.stateIn(viewModelScope, SharingStarted.Eagerly, true)

    fun loadAllCharacter() {
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
