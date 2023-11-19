package com.niranjan.movieshows.ui.movies

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.niranjan.data.repositories.MovieRepository
import com.niranjan.domain.models.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(private val movieRepository: MovieRepository): ViewModel() {


    val movies: StateFlow<MoviesListUiState> = movieRepository.observeMovies(1)
        .map (MoviesListUiState::Success)
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = MoviesListUiState.Loading
        )
/*    fun loadMovies(page: Int = 1) {
        viewModelScope.launch {
            try {
                val data = movieRepository.observeMovies(page) //load movies
               // Log.d("TEST@!", "populateMovies: ${data.movies.map { it.title }.joinToString()} ")
            }catch (ex: Exception) {
                Log.d("TEST@!", "Failed ${ex.message}")
            }
        }
    }*/
}