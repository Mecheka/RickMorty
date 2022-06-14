package com.mecheka.rickmorty

import android.app.Application
import com.mecheka.data.di.dataModule
import com.mecheka.domain.di.domainModule
import com.mecheka.main.di.featureMainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class RickAndMortyApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@RickAndMortyApplication)
            modules(dataModule, domainModule, featureMainModule)
        }
    }
}