package com.example.footballapp.data.repository

import com.example.footballapp.data.mapper.toUiModel
import com.example.footballapp.data.remote.FootballApiClient
import com.example.footballapp.ui.model.CountryUiModel

/**
 * Repository responsible for retrieving country data
 * from the FootballApp backend.
 */
class CountryRepository {

    suspend fun getCountries(): List<CountryUiModel> {

        val response =
            FootballApiClient
                .service
                .getCountries()

        if (!response.isSuccessful) {

            throw Exception(
                "Failed to load countries " +
                        "(HTTP ${response.code()})"
            )
        }

        val dto =
            response.body()
                ?: throw Exception(
                    "Countries response was empty."
                )

        return dto.map {
            it.toUiModel()
        }
    }
}