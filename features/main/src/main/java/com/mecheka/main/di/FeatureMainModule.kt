package com.mecheka.main.di

import com.mecheka.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val featureMainModule = module {
    viewModel { MainViewModel(get()) }
}