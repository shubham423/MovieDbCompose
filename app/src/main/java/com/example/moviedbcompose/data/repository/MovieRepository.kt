package com.example.moviedbcompose.data.repository

import androidx.paging.PagingData
import com.example.moviedbcompose.data.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getPopularMovies(): Flow<PagingData<Movie>>
}