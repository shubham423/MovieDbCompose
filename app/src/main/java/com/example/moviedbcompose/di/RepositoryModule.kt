package com.example.moviedbcompose.di

import com.example.moviedbcompose.data.network.ApiService
import com.example.moviedbcompose.data.repository.MovieRepository
import com.example.moviedbcompose.data.repository.MovieRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(apiService: ApiService): MovieRepository =
        MovieRepositoryImpl(apiService)
}