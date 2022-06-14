package com.mecheka.data.api

import com.mecheka.data.model.BaseResponse
import com.mecheka.data.model.character.CharacterEntity
import retrofit2.http.GET

interface RickAndMortyApi {

    @GET("character")
    suspend fun getAllCharacter(): BaseResponse<List<CharacterEntity>>
}