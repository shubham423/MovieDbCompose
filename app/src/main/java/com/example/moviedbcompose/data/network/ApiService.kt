package com.example.moviedbcompose.data.network

import com.example.moviedbcompose.data.model.MovieResponse
import retrofit2.http.GET

interface ApiService {

    @GET("movie/popular")
    suspend fun getPopularMovies(): MovieResponse
}