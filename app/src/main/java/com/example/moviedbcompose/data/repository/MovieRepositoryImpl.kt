package com.example.moviedbcompose.data.repository

import androidx.paging.PagingData
import com.example.moviedbcompose.data.model.Movie
import com.example.moviedbcompose.data.network.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(val apiService: ApiService) : MovieRepository {
    override fun getPopularMovies(): Flow<PagingData<Movie>> {
      return flow {

      }
    }
}