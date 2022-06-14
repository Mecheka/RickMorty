package com.mecheka.main

sealed class UiState<out T> {
    object Loading : UiState<Nothing>()
    data class Success<R>(val data: R) : UiState<R>()
    data class Error(val error: Throwable) : UiState<Nothing>()
}
