package com.niranjan.movieshows.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.niranjan.movieshows.data.model.Movie
import javax.inject.Inject
/*

class MoviePagingSource @Inject constructor(private val movieRepository: MovieRepository): PagingSource<Int, Movie>() {
    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        try {
            val page = params.key ?: 1
            val data = movieRepository.fetchMovies(page = page)
            if (params.placeholdersEnabled) {
                val itemsAfter = data.
                LoadResult.Page(
                    data = data.results,
                    prevKey = if (page == 0) null else page - 1,
                    nextKey = if (data.results.isEmpty()) null else page + 1,
                    itemsAfter = if (itemsAfter > size) size else itemsAfter.toInt(),
                    itemsBefore = from
                )
            } else {
                LoadResult.Page(
                    data = data.results,
                    prevKey = if (page == 0) null else page - 1,
                    nextKey = if (data.results.isEmpty()) null else page + 1
                )
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

}*/
