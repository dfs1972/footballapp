package com.example.footballapp.util

object LeagueNameFormatter {

    fun displayName(
        leagueId: Int,
        leagueName: String
    ): String {

        return when (leagueId) {

            179 -> "Scottish Premiership"

            180 -> "Scottish Championship"

            183 -> "Scottish League One"

            184 -> "Scottish League Two"

            else -> leagueName

        }

    }

}