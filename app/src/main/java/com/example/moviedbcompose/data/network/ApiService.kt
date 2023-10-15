package com.example.moviedbcompose.data.network

import com.example.moviedbcompose.data.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("page") page: Int = 0
    ): MovieResponse
}