package com.example.footballapp.repositories

import com.example.footballapp.api.ApiConfig
import com.example.footballapp.model.LeagueUk
import com.example.footballapp.model.TableRow
import com.example.footballapp.model.LeagueOverview
import com.example.footballapp.model.PlayerSummary
import com.example.footballapp.model.PlayerDetails
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import okhttp3.OkHttpClient
import okhttp3.Request

class LeagueApiRepository {

    fun getTeamPlayers(
        teamId: Int,
        leagueId: Int,
        season: Int
    ): List<PlayerSummary> {

        val client = OkHttpClient()

        val request =
            Request.Builder()
                .url(
                    "${ApiConfig.BASE_URL}/teamPlayers" +
                            "?teamId=$teamId" +
                            "&leagueId=$leagueId" +
                            "&season=$season"
                )
                .build()

        val json =
            client.newCall(request)
                .execute()
                .body
                ?.string()
                ?: "[]"

        return jacksonObjectMapper()
            .readValue(json)
    }

    fun getPlayerDetails(
        playerId: Int,
        leagueId: Int,
        season: Int
    ): PlayerDetails {

        val client = OkHttpClient()

        val request =
            Request.Builder()
                .url(
                    "${ApiConfig.BASE_URL}/playerDetails" +
                            "?playerId=$playerId" +
                            "&leagueId=$leagueId" +
                            "&season=$season"
                )
                .build()

        val json =
            client.newCall(request)
                .execute()
                .body
                ?.string()
                ?: throw RuntimeException(
                    "Empty response from server."
                )

        return jacksonObjectMapper()
            .readValue(json)
    }

    fun getLeagueTable(leagueId: Int, season: Int): List<TableRow> {

        val client =
            OkHttpClient()

        val request =
            Request.Builder()
                .url(
                    "${ApiConfig.BASE_URL}/leagueTable" +
                            "?leagueId=$leagueId" +
                            "&season=$season"                )
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

    fun getLeagues(): List<LeagueUk> {

        val client =
            OkHttpClient()

        val request =
            Request.Builder()
                .url(
                    "${ApiConfig.BASE_URL}/leagues"
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
    } // End of getLeagues()

    fun getLeagueOverview(
        leagueId: Int,
        season: Int
    ): LeagueOverview {

        val client =
            OkHttpClient()

        val request =
            Request.Builder()
                .url(
                    "${ApiConfig.BASE_URL}/leagueOverview" +
                            "?leagueId=$leagueId" +
                            "&season=$season"
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

        return mapper.readValue(json)
    } // End of getLeagueOverview()
}