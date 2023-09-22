package com.niranjan.movieshows.data.network

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

suspend fun <T> safeApiCall(dispatcher: CoroutineDispatcher, apiCall: suspend () -> T): NetworkResponse<T> {
    return withContext(dispatcher) {
        try {
            NetworkResponse.Success(apiCall.invoke())
        } catch (throwable: Throwable) {
            when (throwable) {
                is IOException -> NetworkResponse.NetworkError
                else -> {
                    NetworkResponse.GenericError(null, null)
                }
            }
        }
    }
}