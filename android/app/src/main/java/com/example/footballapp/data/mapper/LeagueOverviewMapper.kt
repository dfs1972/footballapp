package com.example.footballapp.data.mapper

import com.example.footballapp.data.remote.dto.LeagueOverviewDto
import com.example.footballapp.ui.model.LeagueOverviewUiModel

/**
 * Maps a LeagueOverviewDto received from the backend
 * into a LeagueOverviewUiModel used by the Compose UI.
 */
fun LeagueOverviewDto.toUiModel(): LeagueOverviewUiModel {

    return LeagueOverviewUiModel(

        leagueId = leagueId,

        leagueName = leagueName,

        season = season.toString(),

        teamCount = teamCount,

        fixtureCount = fixtureCount

    )

}