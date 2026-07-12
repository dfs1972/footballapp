package com.example.footballapp.data.mapper

import com.example.footballapp.data.remote.dto.FixtureDto
import com.example.footballapp.ui.model.FixtureStatus
import com.example.footballapp.ui.model.FixtureUiModel

fun FixtureDto.toUiModel() =
    FixtureUiModel(

        fixtureId = fixtureId.toLong(),

        fixtureDate = fixtureDate,

        homeTeamId = homeTeamId,
        homeTeamName = homeTeam,
        homeTeamLogo = null,

        awayTeamId = awayTeamId,
        awayTeamName = awayTeam,
        awayTeamLogo = null,

        kickOff = fixtureTime,

        status = FixtureStatus.SCHEDULED,

        homeScore = homeGoals,
        awayScore = awayGoals

    )