package com.niranjan.movieshows

import androidx.compose.runtime.Composable

@Composable
fun MovieShowsListScreen(
) {

}

sealed interface MovieShowsListState {
    object Success : MovieShowsListState

    data class Failed(val message: String) : MovieShowsListState

    object Loading : MovieShowsListState

    object Paginating: MovieShowsListState

    object Idle: MovieShowsListState
}