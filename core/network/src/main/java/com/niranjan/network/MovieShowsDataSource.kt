package com.niranjan.network

import com.niranjan.network.models.MovieResponse

interface MovieShowsDataSource {
    suspend fun getPopularMovies(page: Int): MovieResponse
}