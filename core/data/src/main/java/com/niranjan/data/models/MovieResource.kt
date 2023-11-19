package com.niranjan.data.models

import com.niranjan.domain.models.Movie
import com.niranjan.network.models.NetworkMovieResource

fun NetworkMovieResource.toDomainModel() = Movie(
    id = id,
    title = title,
    backdropPath = backdropPath,
    genreIds = genreIds,
    originalLanguage = originalLanguage,
    originalTitle = originalTitle,
    overview = overview,
    popularity = popularity,
    posterPath = posterPath,
    releaseDate = releaseDate,
    voteAverage = voteAverage,
    voteCount = voteCount,
)