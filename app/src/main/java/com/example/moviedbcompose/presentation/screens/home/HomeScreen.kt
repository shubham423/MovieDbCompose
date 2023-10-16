package com.example.moviedbcompose.presentation.screens.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.compose.LazyPagingItems
import com.example.moviedbcompose.data.model.Genre
import com.example.moviedbcompose.data.model.Movie
import com.example.moviedbcompose.presentation.components.GenreItem
import com.example.moviedbcompose.presentation.components.MovieItem
import com.example.moviedbcompose.presentation.components.SearchBar

@Composable
fun HomeScreen(
    navigateToMovieDetail: (movieId: String) -> Unit,
    popularMovies: LazyPagingItems<Movie>,
    genres: List<Genre>
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
            .statusBarsPadding()
            .padding(top = 36.dp, start = 16.dp, end = 16.dp)
    ) {
        Text(
            text = "What do you want to watch?", style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFFFFFFF),
            )
        )
        Spacer(modifier = Modifier.height(24.dp))
        SearchBar(onSearch = {})
        Spacer(modifier = Modifier.height(24.dp))
        LazyRow(horizontalArrangement = Arrangement.spacedBy(26.dp)) {
            items(popularMovies.itemCount) { index ->
                val movie = popularMovies[index]
                if (movie != null) {
                    MovieItem(movie = movie)
                }
            }
        }
        Spacer(modifier = Modifier.height(24.dp))

        LazyRow(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
            Log.d("getGenres ", "4 ${genres.size}")
            items(genres.size) { index ->
                val genre = genres[index]
                GenreItem(genre = genre, onGenreClicked = {})
            }
        }
    }

}