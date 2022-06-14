package com.mecheka.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mecheka.domain.character.GetAllCharacterUseCase
import com.mecheka.domain.character.model.Character
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class MainViewModel(private val getAllCharacterUseCase: GetAllCharacterUseCase): ViewModel() {
    private val characterLiveData = MutableLiveData<List<Character>>()
    val character: LiveData<List<Character>> = characterLiveData

    fun loadAllCharacter() {
        getAllCharacterUseCase()
            .onEach { result ->
                result.onSuccess {
                    characterLiveData.value = it
                }
            }.launchIn(viewModelScope)
    }
}