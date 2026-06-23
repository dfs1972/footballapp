package com.example.footballapp.repositories

import com.example.footballapp.ApiConfig
import com.example.footballapp.AppState
import com.example.footballapp.model.TeamDetails
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import okhttp3.OkHttpClient
import okhttp3.Request

class TeamDetailsApiRepository {

    fun getTeamDetails(
        teamId: Int
    ): TeamDetails {


        val client =
            OkHttpClient()

//        val request =
//            Request.Builder()
//                .url(
//                    "${ApiConfig.BASE_URL}/teamDetails" +
//                            "?leagueId=${AppState.selectedLeagueId}" +
//                            "&season=${AppState.selectedSeason}" +
//                            "&teamId=$teamId"
//                )
//                .build()
        val url =
            "${ApiConfig.BASE_URL}/teamDetails" +
                    "?leagueId=${AppState.selectedLeagueId}" +
                    "&season=${AppState.selectedSeason}" +
                    "&teamId=$teamId"

        println(url)

        val request =
            Request.Builder()
                .url(url)
                .build()

        val json =
            client.newCall(request)
                .execute()
                .body
                ?.string()
                ?: "{}"

        println(json)

        val mapper =
            jacksonObjectMapper()

        println(json)
        return mapper.readValue(json)
    }
}