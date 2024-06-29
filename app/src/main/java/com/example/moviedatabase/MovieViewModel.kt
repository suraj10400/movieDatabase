package com.example.moviedatabase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviedatabase.data.Movie
import com.example.moviedatabase.data.RetrofitInstance
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {

    private val _trendingMovies = MutableLiveData<List<Movie>>()
    val trendingMovies: LiveData<List<Movie>> = _trendingMovies

    private val _nowPlayingMovies = MutableLiveData<List<Movie>>()
    val nowPlayingMovies: LiveData<List<Movie>> = _nowPlayingMovies

    private val _upcomingMovies = MutableLiveData<List<Movie>>()
    val upcomingMovies: LiveData<List<Movie>> = _upcomingMovies

    init {
        fetchMovies()
    }

    fun updateNowPlayingMovies(movies: List<Movie>) {
        _nowPlayingMovies.value = movies
    }

    fun updateUpcomingMovies(movies: List<Movie>) {
        _upcomingMovies.value = movies
    }

    private fun fetchMovies() {
        viewModelScope.launch {
            try {
                _trendingMovies.value = RetrofitInstance.api.getPopularMovies().results
                _upcomingMovies.value = RetrofitInstance.api.getUpcomingMovies().results
            } catch (e: Exception) {
                //
            }
        }
    }
}