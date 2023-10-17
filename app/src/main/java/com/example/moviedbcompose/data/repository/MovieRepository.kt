package com.example.moviedbcompose.data.repository

import androidx.paging.PagingData
import com.example.moviedbcompose.data.model.Genre
import com.example.moviedbcompose.data.model.GenreResponse
import com.example.moviedbcompose.data.model.Movie
import com.example.moviedbcompose.utils.Resource
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getPopularMovies(): Flow<PagingData<Movie>>
    fun getMoviesByCategories(category:String): Flow<PagingData<Movie>>
    fun getGenres():Flow<Resource<List<Genre>>>
}