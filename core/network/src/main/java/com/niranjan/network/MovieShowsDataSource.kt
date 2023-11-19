package com.niranjan.network

import com.niranjan.network.model.MovieResponse

interface MovieShowsDataSource {
    suspend fun getPopularMovies(page: Int): MovieResponse
}