package com.niranjan.movieshows.ui.movies

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun MovieShowsListScreen(
    viewModel: MoviesViewModel = hiltViewModel()
) {
    val moviesListUiState by viewModel.movies.collectAsStateWithLifecycle()
}

sealed interface MovieShowsListState {
    object Success : MovieShowsListState

    data class Failed(val message: String) : MovieShowsListState

    object Loading : MovieShowsListState

    object Paginating: MovieShowsListState

    object Idle: MovieShowsListState
}