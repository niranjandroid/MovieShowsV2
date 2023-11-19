package com.niranjan.movieshows.ui.movies

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.niranjan.network.MovieShowsDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(private val movieShowDataSource: MovieShowsDataSource): ViewModel() {

    init {
       // populateMovies()
    }

    fun populateMovies(page: Int = 1) {
        viewModelScope.launch {
            try {
                val data = movieShowDataSource.getPopularMovies(page)
                Log.d("TEST@!", "populateMovies: ${data.results.map { it.title }.joinToString()} ")
            }catch (ex: Exception) {
                Log.d("TEST@!", "Failed ${ex.message}")
            }
        }
    }
}