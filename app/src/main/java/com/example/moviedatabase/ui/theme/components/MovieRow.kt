package com.example.moviedatabase.ui.theme.components

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.moviedatabase.data.Movie


@Composable
fun MovieRow(movies: List<Movie>) {
    LazyRow {
        items(movies) { movie ->
            MovieCard(movie = movie)
        }
    }
}