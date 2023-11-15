package com.mecheka.data

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.observer.ResponseObserver
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.serialization.gson.gson

class KtorClient {

    private companion object {
        const val TAG = "Logger_Ktor"
    }

    fun create() = HttpClient {
        install(ContentNegotiation) {
            gson()
        }
        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    Log.v(TAG, message)
                }
            }
            level = LogLevel.ALL
        }
        install(ResponseObserver) {
            onResponse {
                Log.d(TAG, "Http status: ${it.status}")
            }
        }
        install(DefaultRequest) {
            url("https://rickandmortyapi.com/api/")
            header(HttpHeaders.ContentType, ContentType.Application.Json)
        }
    }
}