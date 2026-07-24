package com.example.footballapp.data.repository

import com.example.footballapp.data.remote.FootballApiClient
import com.example.footballapp.data.remote.dto.CompetitionGroupDto

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
}