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
                                "Bearer test"
                            )
                            .build()
                        chain.proceed(request)
                    }.build()
            )
            .build()
            .create(ApiService::class.java)
    }
}