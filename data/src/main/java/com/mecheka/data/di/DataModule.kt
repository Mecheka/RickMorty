package com.mecheka.data.di

import com.mecheka.data.KtorClient
import com.mecheka.data.RetrofitClient
import com.mecheka.data.repository.RickAndMortyRepository
import com.mecheka.data.repository.RickAndMortyRepositoryImpl
import org.koin.dsl.module

val dataModule = module {
    single { RetrofitClient().create() }
    single { KtorClient().create() }

    factory<RickAndMortyRepository> { RickAndMortyRepositoryImpl(get(), get()) }
}
