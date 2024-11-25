package com.mecheka.data.di

import com.mecheka.data.RetrofitClient
import com.mecheka.data.api.RickAndMortyApi
import com.mecheka.data.repository.RickAndMortyRepository
import com.mecheka.data.repository.RickAndMortyRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Singleton
    @Provides
    fun providesRetrofit(): RickAndMortyApi = RetrofitClient().create()

    @Provides
    fun providesRickAndMortyRepository(api: RickAndMortyApi): RickAndMortyRepository = RickAndMortyRepositoryImpl(api)
}