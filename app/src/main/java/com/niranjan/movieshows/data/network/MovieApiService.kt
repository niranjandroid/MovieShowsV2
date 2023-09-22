package com.niranjan.movieshows.data.network

import com.niranjan.movieshows.data.model.responses.MovieResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {
    @GET("movie/popular?language=en-US")
    suspend fun fetchPopularMovies(
        @Query("page") page: Int = 1
    ): MovieResponse
}