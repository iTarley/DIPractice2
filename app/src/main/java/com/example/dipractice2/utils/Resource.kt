package com.example.dipractice2.utils

sealed class Resource<T> {
    class Success<T>(val result: T): Resource<T>()
    class Error<T>(val errorMessage: String): Resource<T>()
    class Loading<T>(val isLoading: Boolean): Resource<T>()
}