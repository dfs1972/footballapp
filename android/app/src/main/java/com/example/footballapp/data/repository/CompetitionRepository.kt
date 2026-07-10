package com.example.footballapp.data.repository

import com.example.footballapp.data.remote.FootballApiClient
import com.example.footballapp.data.remote.dto.CompetitionDto

class CompetitionRepository {

    suspend fun getCompetitions(): List<CompetitionDto> {

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