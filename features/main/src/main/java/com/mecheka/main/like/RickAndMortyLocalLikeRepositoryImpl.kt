package com.mecheka.main.like

import com.mecheka.domain.character.model.Character
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class RickAndMortyLocalLikeRepositoryImpl : RickAndMortyLocalLikeRepository {
    private val characterLikeFlow = MutableStateFlow(listOf<Character>())
    private val likeCharacterCache = mutableListOf<Character>()

    override fun getAllLikeCharacter(): StateFlow<List<Character>> {
        return characterLikeFlow.asStateFlow()
    }

    override fun saveLikeCharacter(character: Character) {
        val item = likeCharacterCache.find { it.id == character.id }
        val index = likeCharacterCache.indexOf(item)
        val newItem = item?.copy(
            isLike = true,
            likeCount = item.likeCount + 1
        )
        likeCharacterCache[index] = newItem!!
        characterLikeFlow.value = likeCharacterCache.toList()
    }

    override fun saveAllCharacter(characters: List<Character>) {
        likeCharacterCache.addAll(characters)
    }

    override fun removeLikeCharacter(character: Character) {
        val item = likeCharacterCache.find { it.id == character.id }
        val index = likeCharacterCache.indexOf(item)
        val newItem = item?.copy(
            isLike = false,
            likeCount = item.likeCount - 1
        )
        likeCharacterCache[index] = newItem!!
        characterLikeFlow.value = likeCharacterCache.toList()
    }
}