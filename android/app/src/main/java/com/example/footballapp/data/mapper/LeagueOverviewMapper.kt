package com.example.footballapp.data.mapper

import com.example.footballapp.data.remote.dto.LeagueOverviewDto
import com.example.footballapp.ui.model.LeagueOverviewUiModel
import com.example.footballapp.util.LeagueNameFormatter

/**
 * Maps a LeagueOverviewDto received from the backend
 * into a LeagueOverviewUiModel used by the Compose UI.
 */
fun LeagueOverviewDto.toUiModel(): LeagueOverviewUiModel {

    return LeagueOverviewUiModel(

        leagueId = leagueId,

        leagueName = LeagueNameFormatter.displayName(

            leagueId,

            leagueName
        ),

        season = season.toString(),

        teamCount = teamCount,

        fixtureCount = fixtureCount

    )

}

//private fun displayLeagueName(
//    leagueId: Int,
//    leagueName: String
//): String {
//
//    return when (leagueId) {
//
//        179 -> "Scottish Premiership"
//
//        180 -> "Scottish Championship"
//
//        183 -> "Scottish League One"
//
//        184 -> "Scottish League Two"
//
//        else -> leagueName
//
//    }
//
//}