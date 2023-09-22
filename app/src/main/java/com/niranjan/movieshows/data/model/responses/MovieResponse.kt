package com.niranjan.movieshows.data.model.responses

import com.google.gson.annotations.SerializedName
import com.niranjan.movieshows.data.model.Movie

data class MovieResponse(
    @SerializedName("page") var page : Int,
    @SerializedName("results") var results : List<Movie>,
    @SerializedName("total_pages") var totalPages : Int,
    @SerializedName("total_results") var totalResults : Int
)
