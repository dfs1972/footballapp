package com.example.footballapp.data.mapper

import com.example.footballapp.data.remote.dto.FixtureDetailsDto
import com.example.footballapp.ui.model.FixtureDetailsUiModel

fun FixtureDetailsDto.toUiModel() =
    FixtureDetailsUiModel(

        fixtureId = fixtureId,

        fixtureDate = fixtureDate,

        homeTeam = homeTeam,

        homeTeamLogo = homeTeamLogo,

        awayTeam = awayTeam,

        awayTeamLogo = awayTeamLogo,

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