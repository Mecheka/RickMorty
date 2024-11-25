package com.mecheka.main

import android.content.Context
import android.util.Log
import androidx.startup.Initializer
import com.mecheka.main.di.MainFeatureStartupEntryPoint
import dagger.hilt.android.EntryPointAccessors

class MainFeatureInitializer: Initializer<Unit> {
    override fun create(context: Context) {
        val random = EntryPointAccessors.fromApplication<MainFeatureStartupEntryPoint>(context).randomNumber()
        random.random()
        Log.d("Random number", "Random number: ${random.number}")
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> {
        return emptyList<Class<out Initializer<*>>>().toMutableList()
    }
}