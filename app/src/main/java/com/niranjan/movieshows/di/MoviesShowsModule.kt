package com.niranjan.movieshows.di

import com.niranjan.movieshows.data.network.MovieApiService
import com.niranjan.movieshows.data.repository.MovieRepository
import com.niranjan.movieshows.data.repository.RemoteMovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
 class MoviesShowsModule {
    @Provides
    fun providesMovieRepository(
        movieApiService: MovieApiService,
    ): MovieRepository {
        return RemoteMovieRepository(movieApiService)
    }
}