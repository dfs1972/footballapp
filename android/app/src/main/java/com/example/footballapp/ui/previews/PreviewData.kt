package com.example.footballapp.ui.previews

import com.example.footballapp.ui.model.CompetitionGroupUiModel
import com.example.footballapp.ui.model.CompetitionUiModel
import com.example.footballapp.ui.model.LeagueTableRowUiModel
import com.example.footballapp.ui.model.QualificationType
import com.example.footballapp.ui.model.StandingUiModel

object PreviewData {

    // -------------------------------------------------------------------------
    // Scotland - Leagues
    // -------------------------------------------------------------------------

    val ScottishPremiership = CompetitionUiModel(
        id = 179,
        name = "Scottish Premiership",
        season = "2024/25",
        logoUrl = ""
    )

    val ScottishChampionship = CompetitionUiModel(
        id = 180,
        name = "Scottish Championship",
        season = "2025/26",
        logoUrl = ""
    )

    val ScottishLeagueOne = CompetitionUiModel(
        id = 181,
        name = "Scottish League One",
        season = "2025/26",
        logoUrl = ""
    )

    val ScottishLeagueTwo = CompetitionUiModel(
        id = 182,
        name = "Scottish League Two",
        season = "2025/26",
        logoUrl = ""
    )

    // -------------------------------------------------------------------------
    // Scotland - Domestic Cups
    // -------------------------------------------------------------------------

    val ScottishCup = CompetitionUiModel(
        id = 183,
        name = "Scottish Cup",
        season = "2025/26",
        logoUrl = ""
    )

    val LeagueCup = CompetitionUiModel(
        id = 184,
        name = "League Cup",
        season = "2025/26",
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

    // ---------------------------------------------------------------------
    // Standings
    // ---------------------------------------------------------------------
    val ScottishPremiershipStandings = listOf(

        StandingUiModel(
            position = 1,
            teamId = 1,
            teamName = "Celtic",
            points = 86
        ),

        StandingUiModel(
            position = 2,
            teamId = 2,
            teamName = "Rangers",
            points = 82
        ),

        StandingUiModel(
            position = 3,
            teamId = 3,
            teamName = "Hibernian",
            points = 68
        ),

        StandingUiModel(
            position = 4,
            teamId = 4,
            teamName = "Aberdeen",
            points = 61
        ),

        StandingUiModel(
            position = 5,
            teamId = 5,
            teamName = "Hearts",
            points = 59
        )

    )

// -----------------------------------------------------------------------------
// League Table Preview Data
// -----------------------------------------------------------------------------

    val ScottishPremiershipTable = listOf(

        LeagueTableRowUiModel(
            position = 1,
            teamId = 1,
            teamName = "Celtic",
            played = 38,
            wins = 29,
            draws = 4,
            losses = 5,
            points = 91,
            qualification = QualificationType.SAFE
        ),

        LeagueTableRowUiModel(
            position = 2,
            teamId = 2,
            teamName = "Rangers",
            played = 38,
            wins = 27,
            draws = 3,
            losses = 8,
            points = 84,
            qualification = QualificationType.SAFE
        ),

        LeagueTableRowUiModel(
            position = 3,
            teamId = 3,
            teamName = "Hibernian",
            played = 38,
            wins = 18,
            draws = 11,
            losses = 9,
            points = 65,
            qualification = QualificationType.SAFE
        ),

        LeagueTableRowUiModel(
            position = 4,
            teamId = 4,
            teamName = "Aberdeen",
            played = 38,
            wins = 17,
            draws = 10,
            losses = 11,
            points = 61,
            qualification = QualificationType.SAFE
        ),

        LeagueTableRowUiModel(
            position = 5,
            teamId = 5,
            teamName = "Hearts",
            played = 38,
            wins = 16,
            draws = 8,
            losses = 14,
            points = 56,
            qualification = QualificationType.SAFE
        ),

        LeagueTableRowUiModel(
            position = 6,
            teamId = 6,
            teamName = "Motherwell",
            played = 38,
            wins = 15,
            draws = 9,
            losses = 14,
            points = 54,
            qualification = QualificationType.SAFE
        ),

        LeagueTableRowUiModel(
            position = 7,
            teamId = 7,
            teamName = "St Mirren",
            played = 38,
            wins = 13,
            draws = 11,
            losses = 14,
            points = 50,
            qualification = QualificationType.SAFE
        ),

        LeagueTableRowUiModel(
            position = 8,
            teamId = 8,
            teamName = "Dundee United",
            played = 38,
            wins = 13,
            draws = 9,
            losses = 16,
            points = 48,
            qualification = QualificationType.SAFE
        ),

        LeagueTableRowUiModel(
            position = 9,
            teamId = 9,
            teamName = "Kilmarnock",
            played = 38,
            wins = 11,
            draws = 10,
            losses = 17,
            points = 43,
            qualification = QualificationType.SAFE
        ),

        LeagueTableRowUiModel(
            position = 10,
            teamId = 10,
            teamName = "Dundee",
            played = 38,
            wins = 10,
            draws = 8,
            losses = 20,
            points = 38,
            qualification = QualificationType.SAFE
        ),

        LeagueTableRowUiModel(
            position = 11,
            teamId = 11,
            teamName = "Ross County",
            played = 38,
            wins = 8,
            draws = 9,
            losses = 21,
            points = 33,
            qualification = QualificationType.RELEGATION
        ),

        LeagueTableRowUiModel(
            position = 12,
            teamId = 12,
            teamName = "St Johnstone",
            played = 38,
            wins = 7,
            draws = 8,
            losses = 23,
            points = 29,
            qualification = QualificationType.RELEGATION
        )

    )

}