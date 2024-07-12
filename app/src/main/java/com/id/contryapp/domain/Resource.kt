package com.id.contryapp.domain

sealed class Resource<out T> {
    data class Error(val errorMessage: String): Resource<Nothing>()
    data class Success<T>(val data: T): Resource<T>()
}