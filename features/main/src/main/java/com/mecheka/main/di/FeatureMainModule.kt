package com.mecheka.main.di

import com.mecheka.main.MainViewModel
import com.mecheka.main.like.RickAndMortyLocalLikeRepository
import com.mecheka.main.like.RickAndMortyLocalLikeRepositoryImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val featureMainModule = module {
    single<RickAndMortyLocalLikeRepository> { RickAndMortyLocalLikeRepositoryImpl() }
    viewModel { MainViewModel(get(), get(), get()) }
}
