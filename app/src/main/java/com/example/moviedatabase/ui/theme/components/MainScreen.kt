package com.example.moviedatabase.ui.theme.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.moviedatabase.MovieViewModel
import com.example.moviedatabase.data.Movie

@Composable
fun MainScreen(viewModel: MovieViewModel) {

    val nowPlayingMovies: List<Movie> by viewModel.nowPlayingMovies.collectAsState(initial = emptyList())
    val upcomingMovies: List<Movie> by viewModel.upcomingMovies.collectAsState(initial = emptyList())

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Now Playing Movies", modifier = Modifier.padding(bottom = 8.dp))
        MovieRow(movies = nowPlayingMovies.value.orEmpty())
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Upcoming Movies", modifier = Modifier.padding(bottom = 8.dp))
        MovieRow(movies = upcomingMovies.value.orEmpty())
    }
}