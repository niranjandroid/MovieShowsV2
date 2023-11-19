package com.niranjan.network.di

import com.niranjan.network.BuildConfig
import com.niranjan.network.BuildConfig.BASE_URL
import com.niranjan.network.retrofit.TMDBApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object TMDBNetworkModule {


    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
            .addInterceptor {chain ->
                val request = chain.request()
                    .newBuilder() // returns Request.Builder
                    .addHeader("Authorization", "Bearer ${BuildConfig.API_TOKEN}")
                    .build()
                chain.proceed(request)
            }
            .build()
    }

    @Provides
    @Singleton
    fun provideLoginInterceptor(): Interceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    @Singleton
    fun provideHeaderInterceptor(): Interceptor {
        return Interceptor { chain ->
            val request = chain.request()
                .newBuilder() // returns Request.Builder
                .addHeader("Authorization", "Bearer ${BuildConfig.API_TOKEN}")
                .build()
            chain.proceed(request)
        }
    }

    @Provides
    @Singleton
    fun provideTMDBApi(client: OkHttpClient): TMDBApi {
        val contentType = "application/json".toMediaType()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()
            .create(TMDBApi::class.java)
    }
}