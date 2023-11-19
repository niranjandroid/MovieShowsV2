package com.niranjan.data.repositories.impl

import android.util.Log
import com.niranjan.data.repositories.MovieRepository
import com.niranjan.domain.models.Movie
import com.niranjan.network.MovieShowsDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieShowsDataSource: MovieShowsDataSource
): MovieRepository {
    override fun observeMovies(page: Int): Flow<List<Movie>> {
        return flow { movieShowsDataSource.getPopularMovies(page).movies.apply {
            Log.d("TEST@!", joinToString { it.title })
        } }
    }
}