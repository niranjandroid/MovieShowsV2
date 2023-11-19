package com.niranjan.network.models

import com.squareup.moshi.Json

data class MovieResponse(
    val page: Long,
    @field:Json(name = "results")
    val movies: List<NetworkMovieResource>,
    @field:Json(name = "total_pages")
    val totalPages: Long,
    @field:Json(name = "total_results")
    val totalResults: Long,
)