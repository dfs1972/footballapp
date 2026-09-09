package com.example.footballapp.data.remote

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

object FootballApiClient {

    private val logging =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    private val client =
        OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

    private val mapper =
        jacksonObjectMapper()
            .configure(
                DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
                false
            )

    val service: FootballApiService =
        Retrofit.Builder()
            .baseUrl(NetworkConfig.baseUrl)
            .client(client)
            .addConverterFactory(
                JacksonConverterFactory.create(mapper)
            )
            .build()
            .create(FootballApiService::class.java)

}