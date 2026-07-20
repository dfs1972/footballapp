package com.example.footballapp.repositories

import com.example.footballapp.api.ApiConfig
import com.example.footballapp.model.FixtureRow
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import okhttp3.OkHttpClient
import okhttp3.Request

class FixturesApiRepository {

    fun getFixtures(
        leagueId: Int,
        season: Int
    ): List<FixtureRow> {

        val client =
            OkHttpClient()

        val request =
            Request.Builder()
                .url(
                    "${ApiConfig.BASE_URL}/fixtures" +
                            "?leagueId=$leagueId" +
                            "&season=$season"
                )
                .build()

        val json =
            client.newCall(request)
                .execute()
                .body
                ?.string()
                ?: "[]"

        val mapper =
            jacksonObjectMapper()
        System.out.println(json)

        return mapper.readValue(json)
    }
}