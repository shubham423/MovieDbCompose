package com.example.moviedbcompose.presentation.screens.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.example.moviedbcompose.data.model.Movie
import com.example.moviedbcompose.data.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import javax.inject.Inject

@HiltViewModel
class HomeVIewModel @Inject constructor(val repository: MovieRepository) : ViewModel() {

    private var _popularMovies = mutableStateOf<Flow<PagingData<Movie>>>(emptyFlow())
    val popularMovies: State<Flow<PagingData<Movie>>> = _popularMovies
}