package com.mecheka.main.like

import com.mecheka.domain.character.model.Character
import kotlinx.coroutines.flow.StateFlow

interface RickAndMortyLocalLikeRepository {
    fun getAllLikeCharacter(): StateFlow<List<Character>>
    fun saveLikeCharacter(character: Character)
    fun saveAllCharacter(characters: List<Character>)
    fun removeLikeCharacter(character: Character)
}