package com.mecheka.main.di

import com.mecheka.main.RandomNumber
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@EntryPoint
interface MainFeatureStartupEntryPoint {
    fun randomNumber(): RandomNumber
}