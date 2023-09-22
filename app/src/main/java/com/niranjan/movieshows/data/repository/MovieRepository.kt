package com.niranjan.movieshows.data.repository

import com.niranjan.movieshows.data.model.responses.MovieResponse
import com.niranjan.movieshows.data.network.NetworkResponse
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    suspend fun fetchMovies(page: Int = 1): NetworkResponse<MovieResponse>
}