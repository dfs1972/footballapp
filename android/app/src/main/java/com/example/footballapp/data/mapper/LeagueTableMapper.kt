package com.example.footballapp.data.mapper

import com.example.footballapp.data.remote.dto.LeagueTableGroupDto
import com.example.footballapp.data.remote.dto.LeagueTableRowDto
import com.example.footballapp.ui.model.LeagueTableGroupUiModel
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

fun LeagueTableGroupDto.toUiModel(): LeagueTableGroupUiModel {
    return LeagueTableGroupUiModel(
        group = group,
        standings = standings.map {
            it.toUiModel()
        }
    )
}

/**
 * Converts a league position into the qualification band
 * displayed by the UI.
 *
 * Currently only the champion position is generic.
 * Competition-specific qualification rules are not yet
 * applied.
 */
private fun Int.toQualification(): QualificationType =
    when (this) {

        1 -> QualificationType.CHAMPION

        else -> QualificationType.SAFE
    }