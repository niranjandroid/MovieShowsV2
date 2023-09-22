package com.niranjan.movieshows.di

import com.niranjan.movieshows.BuildConfig
import com.niranjan.movieshows.data.network.MovieApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.Interceptor.Chain
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    private fun okHttpClient(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(queryInterceptor())
        return httpClient.build()
    }

    private fun queryInterceptor(): Interceptor {
        return Interceptor { chain -> getResponse(chain) }
    }

    private fun getResponse(chain: Chain): Response {
        val original = chain.request()
        val originalHttpUrl = original.url
        val url = originalHttpUrl.newBuilder()
            .addQueryParameter("api_key", BuildConfig.API_KEY)
            .addQueryParameter("language", "en-US")
            .build()
        val request = original.newBuilder()
            .method(original.method, original.body)
            .url(url)
            .build()

        return chain.proceed(request)
    }


    @Singleton
    @Provides
    fun provideRetrofitInstance(): MovieApiService = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient())
        .build()
        .create(MovieApiService::class.java)
}