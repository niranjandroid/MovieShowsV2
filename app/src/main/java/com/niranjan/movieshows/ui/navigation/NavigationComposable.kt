package com.niranjan.movieshows.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.niranjan.movieshows.ui.features.detail.MovieDetailsScreen
import com.niranjan.movieshows.ui.features.home.MovieShowsListScreen

/*
@Composable
fun NavigationComposable(
    paddingValues: PaddingValues,
    navController: NavHostController,
) {
    NavHost(
        modifier = Modifier
            .padding(paddingValues),
        navController = navController,
        startDestination = "paging"
    ) {
        composable("movie_listing") {
            MovieShowsListScreen()
        }

        composable("movie_details") {
            MovieDetailsScreen()
        }
    }
}*/
