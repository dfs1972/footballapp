package com.example.footballapp.repositories

import com.example.footballapp.ApiConfig
import com.example.footballapp.model.TeamRow
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import okhttp3.OkHttpClient
import okhttp3.Request

class TeamsApiRepository {

    fun getTeams(
        leagueId: Int,
        season: Int
    ): List<TeamRow> {

        val client =
            OkHttpClient()

        val request =
            Request.Builder()
                .url(
                    "${ApiConfig.BASE_URL}/teams" +
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

        return mapper.readValue(json)
    }
}