package com.example.footballapp.data.mapper

import com.example.footballapp.data.remote.dto.FixtureDetailsDto
import com.example.footballapp.ui.model.FixtureDetailsUiModel

fun FixtureDetailsDto.toUiModel() =
    FixtureDetailsUiModel(

        fixtureId = fixtureId,

        fixtureDate = fixtureDate,

        homeTeamId = homeTeamId,

        homeTeam = homeTeam,

        homeTeamLogo = null,

        awayTeamId = awayTeamId,

        awayTeam = awayTeam,

        awayTeamLogo = null,

        homeGoals = homeGoals,

        awayGoals = awayGoals,

        venueName = venueName,

        leagueName = leagueName,

        season = season.toString(),

        round = round,

        statusLong = statusLong,

        statusShort = statusShort,

        elapsed = elapsed

    )