package com.example.footballapp.ui.previews

import com.example.footballapp.ui.model.CompetitionGroupUiModel
import com.example.footballapp.ui.model.CompetitionUiModel

object PreviewData {

    // -------------------------------------------------------------------------
    // Scotland - Leagues
    // -------------------------------------------------------------------------

    val ScottishPremiership = CompetitionUiModel(
        id = 179,
        name = "Scottish Premiership",
        logoUrl = ""
    )

    val ScottishChampionship = CompetitionUiModel(
        id = 180,
        name = "Scottish Championship",
        logoUrl = ""
    )

    val ScottishLeagueOne = CompetitionUiModel(
        id = 181,
        name = "Scottish League One",
        logoUrl = ""
    )

    val ScottishLeagueTwo = CompetitionUiModel(
        id = 182,
        name = "Scottish League Two",
        logoUrl = ""
    )

    // -------------------------------------------------------------------------
    // Scotland - Domestic Cups
    // -------------------------------------------------------------------------

    val ScottishCup = CompetitionUiModel(
        id = 183,
        name = "Scottish Cup",
        logoUrl = ""
    )

    val LeagueCup = CompetitionUiModel(
        id = 184,
        name = "League Cup",
        logoUrl = ""
    )

    // -------------------------------------------------------------------------
    // Competition Groups
    // -------------------------------------------------------------------------

    val Scotland = CompetitionGroupUiModel(

        displayOrder = 1,

        title = "Scotland",

        headerIcon = "🏴",

        leagues = listOf(
            ScottishPremiership,
            ScottishChampionship,
            ScottishLeagueOne,
            ScottishLeagueTwo
        ),

        domesticCups = listOf(
            ScottishCup,
            LeagueCup
        )

    )

}