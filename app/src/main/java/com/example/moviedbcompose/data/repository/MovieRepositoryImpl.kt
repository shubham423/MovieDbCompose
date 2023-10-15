package com.example.moviedbcompose.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.moviedbcompose.data.model.Movie
import com.example.moviedbcompose.data.network.ApiService
import com.example.moviedbcompose.data.paging.PopularMoviesPagingSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val apiService: ApiService) :
    MovieRepository {
    override fun getPopularMovies(): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = 20),
            pagingSourceFactory = {
                PopularMoviesPagingSource(api = apiService)
            }
        ).flow
    }
}