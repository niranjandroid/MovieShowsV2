package com.niranjan.data.di

import com.niranjan.data.repositories.MovieRepository
import com.niranjan.data.repositories.impl.MovieRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Binds
    fun bindsMovieRepository(impl: MovieRepositoryImpl): MovieRepository
}