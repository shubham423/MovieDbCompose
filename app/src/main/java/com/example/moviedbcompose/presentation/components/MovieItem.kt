package com.example.moviedbcompose.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import com.example.moviedbcompose.R
import com.example.moviedbcompose.data.model.Movie
import com.example.moviedbcompose.utils.Constants.BASE_POSTER_IMAGE_URL

@Composable
fun MovieItem(movie: Movie) {
    Column(modifier = Modifier.fillMaxWidth()) {
        val imagePath = "$BASE_POSTER_IMAGE_URL/${movie.posterPath}"
        AsyncImage(
            model = imagePath,
            placeholder = painterResource(id = R.drawable.ic_launcher_background),
            error = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null,
        )
        Text(
            text = movie.title,
        )
    }
}