package com.niranjan.data.repositories

import com.niranjan.domain.models.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun observeMovies(page: Int): Flow<List<Movie>>
}