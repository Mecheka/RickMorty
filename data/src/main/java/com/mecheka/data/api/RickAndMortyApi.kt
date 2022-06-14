package com.mecheka.data.api

import com.mecheka.data.model.BaseResponse
import com.mecheka.data.model.character.CharacterEntity
import com.mecheka.data.model.character.LocationEntity
import retrofit2.Response
import retrofit2.http.GET

interface RickAndMortyApi {

    @GET("character")
    suspend fun getAllCharacter(): Response<BaseResponse<List<CharacterEntity>>>

    @GET("location")
    suspend fun getAllLocation(): Response<BaseResponse<List<LocationEntity>>>
}
