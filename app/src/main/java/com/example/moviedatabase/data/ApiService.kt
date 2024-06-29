package com.example.moviedatabase.data

import retrofit2.http.GET

interface ApiService {

    @GET("movie/popular?language=en-US&page=1")
    suspend fun getPopularMovies(): MovieResponse

    @GET("movie/now_playing?language=en-US&page=1")
    suspend fun getNowPLayingMovies(): MovieResponse

    @GET("movie/upcoming?language=en-US&page=1")
    suspend fun getUpcomingMovies(): MovieResponse
}