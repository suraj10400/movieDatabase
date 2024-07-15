package com.example.moviedatabase.data

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private const val BASE_URL = "https://api.themoviedb.org/3"

    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .addInterceptor { chain ->
                        val request = chain
                            .request()
                            .newBuilder()
                            .addHeader(
                                "Authorization",
                                "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxNjg4ZTI4MWRjYTVmOWM0NGY4NzFhNmVhYTJmODMxMCIsIm5iZiI6MTcxOTU2NTAzMS4zODgzNDcsInN1YiI6IjY2N2U3YTcyZGI2Njc1YzMyYjhkNzI0NiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.aZtcEIuonqZH3BFArwQ3Z0QX5ysYpPaUglyINAFuLBo"
                            )
                            .build()
                        chain.proceed(request)
                    }.build()
            )
            .build()
            .create(ApiService::class.java)
    }
}