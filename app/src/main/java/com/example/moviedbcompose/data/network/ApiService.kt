package com.example.moviedbcompose.data.network

import com.example.moviedbcompose.data.model.MovieResponse
import com.example.moviedbcompose.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("page") page: Int = 0,
        @Query("api_key") apiKey: String =Constants.API_KEY,
    ): MovieResponse
}