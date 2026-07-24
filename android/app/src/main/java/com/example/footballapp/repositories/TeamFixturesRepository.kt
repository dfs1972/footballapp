package com.example.footballapp.repositories

import com.example.footballapp.model.TeamFixtureRow

/**
 * TeamFixturesRepository
 */

class TeamFixturesRepository {

    fun getFixtures(
        teamName: String
    ): List<TeamFixtureRow> {

        return listOf(

            TeamFixtureRow(
                "Celtic",
                "Aberdeen",
                4,
                0
            ),

            TeamFixtureRow(
                "Rangers",
                "Celtic",
                1,
                1
            ),

            TeamFixtureRow(
                "Celtic",
                "Hibernian",
                3,
                1
            ),

            TeamFixtureRow(
                "Hearts",
                "Celtic",
                0,
                2
            )
        )
    }
}