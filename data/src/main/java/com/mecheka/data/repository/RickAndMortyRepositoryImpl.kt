package com.mecheka.data.repository

import com.mecheka.data.api.RickAndMortyApi
import com.mecheka.data.model.BaseResponse
import com.mecheka.data.model.character.CharacterEntity
import com.mecheka.data.model.character.LocationEntity
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.isSuccess
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class RickAndMortyRepositoryImpl(
    private val api: RickAndMortyApi,
    private val httpClient: HttpClient,
) :
    RickAndMortyRepository {
    override fun getAllCharacter(): Flow<Result<List<CharacterEntity>>> {
        return flow {
//            val response = api.getAllCharacter()
            val response = httpClient.get("character")
            if (response.status.isSuccess()) {
                emit(Result.success(response.body<BaseResponse<List<CharacterEntity>>>().results.orEmpty()))
            } else {
                emit(Result.failure(IllegalStateException()))
            }
        }
    }

    override fun getAllLocation(): Flow<Result<List<LocationEntity>>> {
        return flow {
//            val response = api.getAllLocation()
            val response = httpClient.get("location")
            if (response.status.isSuccess()) {
                emit(Result.success(response.body<BaseResponse<List<LocationEntity>>>().results.orEmpty()))
            } else {
                emit(Result.failure(IllegalStateException()))
            }
        }
    }
}
