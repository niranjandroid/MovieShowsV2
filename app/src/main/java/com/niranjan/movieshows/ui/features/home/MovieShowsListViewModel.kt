package com.niranjan.movieshows.ui.features.home

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.niranjan.movieshows.data.model.Movie
import com.niranjan.movieshows.data.network.NetworkResponse
import com.niranjan.movieshows.data.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MovieShowsListViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {



    private val _movieShowsListState: MutableLiveData<MovieShowsListState> = MutableLiveData()
    val movieShowsListState: LiveData<MovieShowsListState> = _movieShowsListState

    var movies = mutableStateListOf<Movie>()

    var nextPage = 1
    var canPaginate by mutableStateOf(false)


    fun fetchMovies() {
        Log.d("TEST@!", "called")
        _movieShowsListState.postValue(MovieShowsListState.Loading)
        if(nextPage == 1 || ( canPaginate && movieShowsListState.value == MovieShowsListState.Idle )) {
            viewModelScope.launch {
                when (val response = movieRepository.fetchMovies(nextPage)) {
                    is NetworkResponse.Success -> {
                        with(response.value) {
                            nextPage = page + 1
                            if(page == 1) movies = results.toMutableStateList()
                            else movies.addAll(results)
                            canPaginate = totalPages - page > 0
                            _movieShowsListState.postValue(MovieShowsListState.Success)
                        }
                    }
                    is NetworkResponse.NetworkError -> _movieShowsListState.postValue(MovieShowsListState.Failed("Network Error"))
                    is NetworkResponse.GenericError -> _movieShowsListState.postValue(MovieShowsListState.Failed("Something went wrong"))

                }
            }
        }
    }
}