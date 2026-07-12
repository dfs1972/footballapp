package com.example.footballapp.data.mapper

import com.example.footballapp.data.remote.dto.LeagueTableRowDto
import com.example.footballapp.ui.model.LeagueTableRowUiModel
import com.example.footballapp.ui.model.QualificationType

/**
 * Maps a LeagueTableRowDto to the UI model.
 */
fun LeagueTableRowDto.toUiModel(): LeagueTableRowUiModel {

    return LeagueTableRowUiModel(

        position = position,

        teamId = teamId,

        teamName = teamName,

        teamLogo = null,

        played = played,

        wins = wins,

        draws = draws,

        losses = losses,

        goalDifference = goalDifference,

        points = points,

        qualification = position.toQualification(),

        form = null

    )

}

/**
 * Converts a league position into the qualification band
 * displayed by the UI.
 *
 * Current implementation is for the Scottish Premiership.
 * This can be expanded later to support league-specific
 * qualification rules.
 */
private fun Int.toQualification(): QualificationType =
    when (this) {

        1 -> QualificationType.CHAMPION

        12 -> QualificationType.RELEGATION

        else -> QualificationType.SAFE

    }