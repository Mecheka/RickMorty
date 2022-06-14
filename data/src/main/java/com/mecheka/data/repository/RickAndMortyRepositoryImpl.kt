package com.mecheka.data.repository

import com.mecheka.data.api.RickAndMortyApi
import com.mecheka.data.model.character.CharacterEntity
import com.mecheka.data.model.character.LocationEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class RickAndMortyRepositoryImpl(private val api: RickAndMortyApi) :
    RickAndMortyRepository {
    override fun getAllCharacter(): Flow<Result<List<CharacterEntity>>> {
        return flow {
            val response = api.getAllCharacter()
            if (response.isSuccessful) {
                emit(Result.success(response.body()?.results.orEmpty()))
            } else {
                emit(Result.failure(IllegalStateException()))
            }
        }
    }

    override fun getAllLocation(): Flow<Result<List<LocationEntity>>> {
        return flow {
            val response = api.getAllLocation()
            if (response.isSuccessful) {
                emit(Result.success(response.body()?.results.orEmpty()))
            } else {
                emit(Result.failure(IllegalStateException()))
            }
        }
    }
}
