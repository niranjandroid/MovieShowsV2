package com.niranjan.network.retrofit

import com.niranjan.network.MovieShowsDataSource
import com.niranjan.network.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject
import javax.inject.Singleton

interface TMDBApi {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("page") page: Int): MovieResponse

}
@Singleton
class TBDBNetworkClient @Inject constructor(
    private val tmdbApi: TMDBApi
): MovieShowsDataSource {
    override suspend fun getPopularMovies(page: Int): MovieResponse {
        return tmdbApi.getPopularMovies(page)
    }
}