package com.example.moviedbcompose.presentation.screens.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.moviedbcompose.data.model.GenreResponse
import com.example.moviedbcompose.data.model.Movie
import com.example.moviedbcompose.data.repository.MovieRepository
import com.example.moviedbcompose.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeVIewModel @Inject constructor(private val repository: MovieRepository) : ViewModel() {

    private var _popularMovies = mutableStateOf<Flow<PagingData<Movie>>>(emptyFlow())
    val popularMovies: State<Flow<PagingData<Movie>>> = _popularMovies

    private var _genres = mutableStateOf<Resource<GenreResponse>>(Resource.Idle())
    val genres: State<Resource<GenreResponse>> = _genres

    init {
        getPopularMovies()
        getGenres()
    }

    private fun getPopularMovies() {
        viewModelScope.launch {
            _popularMovies.value = repository.getPopularMovies().cachedIn(viewModelScope)
        }
    }

    private fun getGenres() {
        viewModelScope.launch {
            repository.getGenres().collect {
                _genres.value = it
            }
        }
    }
}
