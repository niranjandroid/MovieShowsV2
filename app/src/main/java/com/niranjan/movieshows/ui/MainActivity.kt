package com.niranjan.movieshows.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.niranjan.movieshows.ui.movies.MovieShowsListScreen
import com.niranjan.movieshows.ui.theme.MovieShowsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieShowsTheme {
                MovieShowsListScreen()
            }
        }
    }
}