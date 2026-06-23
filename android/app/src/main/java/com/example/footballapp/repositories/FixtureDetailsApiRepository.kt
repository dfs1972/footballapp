package com.example.footballapp.repositories

import com.example.footballapp.ApiConfig
import com.example.footballapp.model.FixtureRow
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import okhttp3.OkHttpClient
import okhttp3.Request

class FixtureDetailsApiRepository {

    fun getFixture(
        fixtureId: Long
    ): FixtureRow {

        val client =
            OkHttpClient()

        val request =
            Request.Builder()
                .url(
                    "${ApiConfig.BASE_URL}/fixture" +
                            "?fixtureId=$fixtureId"
                )
                .build()

        val json =
            client.newCall(request)
                .execute()
                .body
                ?.string()
                ?: "{}"

        val mapper =
            jacksonObjectMapper()

        System.out.println(json)
        return mapper.readValue(json)
    }
}