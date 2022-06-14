package com.mecheka.data.repository

import com.mecheka.data.model.character.CharacterEntity
import kotlinx.coroutines.flow.Flow

interface RickAndMortyRepository {
    fun getAllCharacter(): Flow<Result<List<CharacterEntity>>>
}