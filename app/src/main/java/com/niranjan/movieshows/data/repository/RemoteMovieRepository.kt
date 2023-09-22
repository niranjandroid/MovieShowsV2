package com.niranjan.movieshows.data.repository

import com.niranjan.movieshows.data.model.responses.MovieResponse
import com.niranjan.movieshows.data.network.MovieApiService
import com.niranjan.movieshows.data.network.NetworkResponse
import com.niranjan.movieshows.data.network.safeApiCall
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class RemoteMovieRepository @Inject constructor(
    private val movieApiService: MovieApiService,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : MovieRepository {
    override suspend fun fetchMovies(page: Int): NetworkResponse<MovieResponse> {
        return safeApiCall(dispatcher) { movieApiService.fetchPopularMovies(page) }
    }
}