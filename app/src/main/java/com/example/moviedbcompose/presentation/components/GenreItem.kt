package com.example.moviedbcompose.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moviedbcompose.data.model.Genre

@Composable
fun GenreItem(genre: Genre, onGenreClicked: (Int) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable {
                genre.id?.let { onGenreClicked(it) }
            },
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = genre.name,
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center,
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        Divider(
            modifier = Modifier
                .height(4.dp)
                .width(46.dp), color = Color(0xFF3A3F47),
            thickness = 12.dp
        )
    }
}

@Preview(backgroundColor = 0xFFE4CFCF)
@Composable
fun DividerPreview() {
    val genre = Genre(id = 1, name = "upcoming")
    GenreItem(genre = genre, onGenreClicked = {})
}