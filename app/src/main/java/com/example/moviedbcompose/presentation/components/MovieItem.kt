package com.example.moviedbcompose.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.moviedbcompose.R
import com.example.moviedbcompose.data.model.Movie
import com.example.moviedbcompose.utils.Constants.BASE_POSTER_IMAGE_URL

@Composable
fun MovieItem(movie: Movie, height: Dp = 210.dp) {


    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card {
            val imagePath = "$BASE_POSTER_IMAGE_URL/${movie.posterPath}"
            AsyncImage(
                model = imagePath,
                placeholder = painterResource(id = R.drawable.movie_placeholder),
                error = painterResource(id = R.drawable.movie_placeholder),
                contentDescription = null,
                modifier = Modifier
                    .height(height)
                    .width(145.dp),
                contentScale = ContentScale.FillBounds
            )
        }
        Text(
            text = trimTitle(movie.title),
            color = Color.White,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

fun trimTitle(text: String) = if (text.length <= 18) text else {
    val textWithEllipsis = text.removeRange(startIndex = 18, endIndex = text.length)
    "$textWithEllipsis..."
}