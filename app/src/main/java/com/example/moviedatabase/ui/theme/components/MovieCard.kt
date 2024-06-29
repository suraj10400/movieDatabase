package com.example.moviedatabase.ui.theme.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.moviedatabase.data.Movie


@Composable
fun MovieCard(movie: Movie) {
    Column(modifier = Modifier.padding(8.dp)) {
        movie.posterPath?.let { posterPath ->
            val imageUrl = "https://image.tmdb.org/t/p/w500$posterPath"
            val painter: Painter = rememberImagePainter(data = imageUrl)
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier.size(120.dp)
            )
        }
        Text(text = movie.title ?: "Title not available")
    }
}