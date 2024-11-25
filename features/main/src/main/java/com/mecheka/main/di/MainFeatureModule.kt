package com.mecheka.main.di

import com.mecheka.main.RandomNumber
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object MainFeatureModule {

    @Singleton
    @Provides
    fun providesRandomNumber(): RandomNumber {
        return RandomNumber()
    }
}