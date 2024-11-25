package com.mecheka.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.mecheka.features.main.R
import com.mecheka.main.compose.MainScreen
import com.mecheka.resource.JetRickMortyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetRickMortyTheme() {
                MainScreen()
            }
        }
    }
}
