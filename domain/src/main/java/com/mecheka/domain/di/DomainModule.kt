package com.mecheka.domain.di

import com.mecheka.domain.character.GetAllCharacterUseCase
import com.mecheka.domain.character.GetAllCharacterUseCaseImpl
import com.mecheka.domain.location.GetAllLocationUseCase
import com.mecheka.domain.location.GetAllLocationUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DomainModule {
    @Binds
    abstract fun bindsGetGetAllCharacterUseCase(impl: GetAllCharacterUseCaseImpl): GetAllCharacterUseCase

    @Binds
    abstract fun bindsGetAllLocationUseCase(impl: GetAllLocationUseCaseImpl): GetAllLocationUseCase
}