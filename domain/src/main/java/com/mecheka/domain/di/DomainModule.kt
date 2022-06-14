package com.mecheka.domain.di

import com.mecheka.domain.character.GetAllCharacterUseCase
import com.mecheka.domain.character.GetAllCharacterUseCaseImpl
import org.koin.dsl.module

val domainModule = module {
    factory<GetAllCharacterUseCase> { GetAllCharacterUseCaseImpl(get()) }
}