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

        season =
            "$season/${(season + 1).toString().takeLast(2)}"

    )
}