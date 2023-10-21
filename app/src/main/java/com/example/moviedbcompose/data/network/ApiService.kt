package com.example.moviedbcompose.data.network

import com.example.moviedbcompose.data.model.GenreResponse
import com.example.moviedbcompose.data.model.Movie
import com.example.moviedbcompose.data.model.MovieResponse
import com.example.moviedbcompose.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("page") page: Int = 0,
        @Query("api_key") apiKey: String = Constants.API_KEY,
    ): MovieResponse

    @GET("genre/movie/list")
    suspend fun getMovieGenres(
        @Query("api_key") apiKey: String = Constants.API_KEY,
        @Query("language") language: String = "en"
    ): GenreResponse

    @GET("movie/{category}")
    suspend fun getMoviesByCategories(
        @Path("category") category: String,
        @Query("page") page: Int = 0,
        @Query("api_key") apiKey: String = Constants.API_KEY
    ): MovieResponse

    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") id: Int,
        @Query("append_to_response") appendQuery: String,
        @Query("api_key") apiKey: String = Constants.API_KEY
    ): Movie
}