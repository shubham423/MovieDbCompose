package com.example.moviedbcompose.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moviedbcompose.data.model.Genre

@Composable
fun GenreItem(genre: Genre, onGenreClicked: (Int) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .clickable {
                genre.id?.let { onGenreClicked(it) }
            },
        horizontalAlignment = Alignment.CenterHorizontally
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
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
                .background(color = MaterialTheme.colorScheme.primary)
        )
    }
}