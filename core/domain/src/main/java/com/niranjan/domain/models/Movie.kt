package com.niranjan.domain.models

data class Movie(
    val id: Long,
    val title: String,
    val backdropPath: String,
    val genreIds: List<Long>,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String,
    val voteAverage: Double,
    val voteCount: Long,
)
