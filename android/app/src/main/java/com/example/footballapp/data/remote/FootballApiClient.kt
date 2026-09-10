package com.example.footballapp.data.remote

import android.util.Log
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

    private var currentBaseUrl: String = NetworkConfig.baseUrl
    private var cachedService: FootballApiService? = null

    val service: FootballApiService
        get() {
            val latestUrl = NetworkConfig.baseUrl
            if (latestUrl != currentBaseUrl || cachedService == null) {
                currentBaseUrl = latestUrl
                cachedService = createService(latestUrl)
            }
            return cachedService!!
        }

    private fun createService(baseUrl: String): FootballApiService {
        val normalizedUrl = if (baseUrl.endsWith("/")) baseUrl else "$baseUrl/"
        Log.d("FootballApiClient", "Creating service with URL: $normalizedUrl")
        
        return Retrofit.Builder()
            .baseUrl(normalizedUrl)
            .client(client)
            .addConverterFactory(
                JacksonConverterFactory.create(mapper)
            )
            .build()
            .create(FootballApiService::class.java)
    }
}