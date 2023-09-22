package com.niranjan.movieshows.ui.features.home

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.niranjan.movieshows.data.model.Movie

@Composable
fun MovieShowsListScreen(
    viewModel: MovieShowsListViewModel = hiltViewModel(),
) {
    if(viewModel.nextPage == 1) {
        viewModel.fetchMovies()
    }
    val uiState =
        viewModel.movieShowsListState.observeAsState(initial = MovieShowsListState.Loading).value
    when (uiState) {
        is MovieShowsListState.Success -> {
            Box(modifier = Modifier.fillMaxSize()) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    items(items = viewModel.movies) { movie ->
                        MovieShowsItem(
                            movie = movie,
                            modifier = Modifier.fillMaxWidth()
                        )
                        Divider()
                    }
                    item {
                        if (false) {
                            CircularProgressIndicator()
                        }
                    }
                }
            }
        }

        is MovieShowsListState.Failed -> {
            Toast.makeText(
                LocalContext.current,
                "Something went wrong",
                Toast.LENGTH_LONG
            ).show()
        }

        MovieShowsListState.Loading -> {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}


@Composable
private fun MovieShowsItem(movie: Movie, modifier: Modifier = Modifier) {

    Log.d("TEST@!", "uistate $movie")
    Card(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Max)
                .padding(16.dp)
        ) {
            AsyncImage(
                model = movie.posterPath,
                contentDescription = movie.title,
                modifier = Modifier
                    .weight(1f)
                    .height(150.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier
                    .weight(3f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                movie.title?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.headlineSmall,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
                movie.overview?.let {
                    Text(
                        text = it,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
                movie.releaseDate?.let {
                    Text(
                        text = "First released in $it",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.End,
                        fontSize = 8.sp
                    )
                }

            }
        }
    }
}

sealed interface MovieShowsListState {
    object Success : MovieShowsListState

    data class Failed(val message: String) : MovieShowsListState

    object Loading : MovieShowsListState

    object Paginating: MovieShowsListState

    object Idle: MovieShowsListState
}