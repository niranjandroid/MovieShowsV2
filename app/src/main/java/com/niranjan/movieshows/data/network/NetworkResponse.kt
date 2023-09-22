package com.niranjan.movieshows.data.network

sealed class NetworkResponse<out T> {
    data class Success<out T>(val value: T): NetworkResponse<T>()
    data class GenericError(val code: Int? = null, val error: Throwable? = null): NetworkResponse<Nothing>()
    object NetworkError: NetworkResponse<Nothing>()
}