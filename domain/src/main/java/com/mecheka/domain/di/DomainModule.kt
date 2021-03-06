package com.mecheka.domain.di

import com.mecheka.domain.character.GetAllCharacterUseCase
import com.mecheka.domain.character.GetAllCharacterUseCaseImpl
import com.mecheka.domain.location.GetAllLocationUseCase
import com.mecheka.domain.location.GetAllLocationUseCaseImpl
import org.koin.dsl.module

val domainModule = module {
    factory<GetAllCharacterUseCase> { GetAllCharacterUseCaseImpl(get()) }
    factory<GetAllLocationUseCase> { GetAllLocationUseCaseImpl(get()) }
}
