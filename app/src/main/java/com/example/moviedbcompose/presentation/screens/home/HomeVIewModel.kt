package com.example.moviedbcompose.presentation.screens.home

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.moviedbcompose.data.model.Genre
import com.example.moviedbcompose.data.model.Movie
import com.example.moviedbcompose.data.repository.MovieRepository
import com.example.moviedbcompose.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeVIewModel @Inject constructor(private val repository: MovieRepository) : ViewModel() {

    private var _popularMovies = mutableStateOf<Flow<PagingData<Movie>>>(emptyFlow())
    val popularMovies: State<Flow<PagingData<Movie>>> = _popularMovies

    private var _categoryBasedMovies = mutableStateOf<Flow<PagingData<Movie>>>(emptyFlow())
    val categoryBasedMovies: State<Flow<PagingData<Movie>>> = _categoryBasedMovies

    private var _genres: MutableStateFlow<List<Genre>> = MutableStateFlow(emptyList())
    val genres = _genres.asStateFlow()


    var movieCategories = mutableStateListOf<String>()
        private set

    init {
        getGenres()
        getPopularMovies()
        movieCategories.addAll(listOf("top_rated", "upcoming", "now_playing", "popular"))
        getMoviesByCategory("top_rated")
    }

    private fun getPopularMovies() {
        viewModelScope.launch {
            _popularMovies.value = repository.getPopularMovies().cachedIn(viewModelScope)
        }
    }

     fun getMoviesByCategory(category: String) {
        viewModelScope.launch {
            _categoryBasedMovies.value =
                repository.getMoviesByCategories(category).cachedIn(viewModelScope)
        }
    }


    private fun getGenres() {
        viewModelScope.launch {
            repository.getGenres().collect {
                when (it) {
                    is Resource.Error -> {
                        Log.d("getGenres ", "1")
                    }

                    is Resource.Loading -> {
                        Log.d("getGenres ", "2")
                    }

                    is Resource.Success -> {
                        Log.d("getGenres ", "3 ${it.data?.size}")
                        _genres.emit(it.data!!.toMutableList())
                    }
                }
            }
        }
    }
}
