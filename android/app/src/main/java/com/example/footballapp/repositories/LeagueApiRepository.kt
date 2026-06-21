package com.example.footballapp.repositories

import com.example.footballapp.ApiConfig
import com.example.footballapp.model.TableRow
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import okhttp3.OkHttpClient
import okhttp3.Request

class LeagueApiRepository {

    fun getLeagueTable(leagueId: Int, season: Int): List<TableRow> {

        val client =
            OkHttpClient()

        val request =
            Request.Builder()
                .url(
                    "${ApiConfig.BASE_URL}/leagueTable?leagueId=179&season=2024"
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