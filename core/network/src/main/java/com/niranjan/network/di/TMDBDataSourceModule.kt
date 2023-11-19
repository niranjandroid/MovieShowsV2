package com.niranjan.network.di

import com.niranjan.network.MovieShowsDataSource
import com.niranjan.network.retrofit.TBDBNetworkClient
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
interface TMDBDataSourceModule {
    @Binds
    fun binds(impl: TBDBNetworkClient): MovieShowsDataSource
}