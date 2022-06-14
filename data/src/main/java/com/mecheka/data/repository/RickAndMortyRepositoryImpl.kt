package com.mecheka.data.repository

import com.mecheka.data.api.RickAndMortyApi
import com.mecheka.data.model.character.CharacterEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class RickAndMortyRepositoryImpl(private val api: RickAndMortyApi) : RickAndMortyRepository {
    override fun getAllCharacter(): Flow<Result<List<CharacterEntity>>> {
        return flow {
            try {
                val result = api.getAllCharacter()
                emit(Result.success(api.getAllCharacter().results.orEmpty()))
            } catch (e: Exception) {
                emit(Result.failure(e))
            }
        }
    }
}