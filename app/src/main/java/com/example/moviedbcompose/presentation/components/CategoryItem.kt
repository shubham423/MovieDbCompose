package com.example.moviedbcompose.presentation.components

import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Locale

@Composable
fun CategoryItem(category: String, selectedCategory: String, onCategoryClicked: (String) -> Unit) {
    var componentWidth by remember { mutableStateOf(0.dp) }
    val density = LocalDensity.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable {
                onCategoryClicked(category)
            },
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = formatStringForUI(category),
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center,
            ),
            modifier = Modifier.onGloballyPositioned {
                componentWidth = with(density) {
                    it.size.width.toDp()
                }
            }
        )
        Spacer(modifier = Modifier.height(8.dp))
        AnimatedVisibility(visible = category == selectedCategory) {
            Divider(
                modifier = Modifier
                    .height(6.dp)
                    .width(componentWidth), color = Color(0xFF3A3F47),
                thickness = 12.dp
            )
        }
    }
}

fun formatStringForUI(input: String): String {
    val parts = input.split("_")
    val formattedParts =
        parts.map { it.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() } }
    return formattedParts.joinToString(" ")
}
