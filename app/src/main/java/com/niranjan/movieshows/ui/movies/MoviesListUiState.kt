package com.niranjan.movieshows.ui.movies

import com.niranjan.domain.models.Movie

sealed interface MoviesListUiState {
    data object Loading : MoviesListUiState

    data class Success(val data: List<Movie>) : MoviesListUiState
}