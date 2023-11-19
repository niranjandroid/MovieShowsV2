package com.niranjan.movieshows.ui.movies

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MovieShowsListScreen(
    viewModel: MoviesViewModel = hiltViewModel()
) {
    viewModel.populateMovies()
}

sealed interface MovieShowsListState {
    object Success : MovieShowsListState

    data class Failed(val message: String) : MovieShowsListState

    object Loading : MovieShowsListState

    object Paginating: MovieShowsListState

    object Idle: MovieShowsListState
}