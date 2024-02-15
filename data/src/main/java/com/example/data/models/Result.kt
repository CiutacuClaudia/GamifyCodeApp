package com.example.data.models

sealed class Result<out T> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val message: String) : Result<Nothing>()
    data class Loading(val shouldShowLoading: Boolean) : Result<Nothing>()
}
