package com.example.footballapp.data.mapper

import com.example.footballapp.data.remote.dto.CompetitionDto
import com.example.footballapp.ui.model.CompetitionUiModel

fun CompetitionDto.toUiModel() =
    CompetitionUiModel(
        id = leagueId,
        name = name,
        country = country,
        logoUrl = logoUrl
    )