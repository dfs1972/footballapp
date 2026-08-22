package com.example.footballapp.data.repository

import com.example.footballapp.data.remote.FootballApiClient
import com.example.footballapp.data.remote.dto.CompetitionGroupDto
import com.example.footballapp.data.remote.dto.LeagueApiResponseDto

class CompetitionRepository {

    suspend fun getCompetitions(): List<CompetitionGroupDto> {

        val response =
            FootballApiClient.service.getLeagues()

        if (response.isSuccessful) {

            return response.body() ?: emptyList()

        }

        throw Exception(
            "Failed to load competitions: ${response.code()}"
        )
    }

    suspend fun getLeaguesByCountry(
        country: String,
        season: Int
    ): List<LeagueApiResponseDto> {

        val response =
            FootballApiClient
                .service
                .getLeaguesByCountry(
                    country = country,
                    season = season
                )

        if (!response.isSuccessful) {

            throw Exception(
                "Failed to load competitions " +
                        "(HTTP ${response.code()})"
            )
        }

        return response.body()
            ?: throw Exception(
                "Competitions response was empty."
            )
    }
}