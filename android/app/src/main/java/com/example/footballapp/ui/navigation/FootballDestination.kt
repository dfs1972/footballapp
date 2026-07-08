package com.example.footballapp.ui.navigation

sealed class FootballDestination(
    val route: String
) {

    data object Competitions : FootballDestination(
        "competitions"
    )

    data object LeagueOverview : FootballDestination(
        "league_overview"
    )

    data object LeagueTable : FootballDestination("league_table")

    data object ClubDetails : FootballDestination(
        "club_details"
    ) {

        fun createRoute(clubId: Int) =
            "club_details/$clubId"

    }

    data object Fixtures : FootballDestination("fixtures")

    data object Clubs : FootballDestination("clubs")

    data object Club : FootballDestination("club")

    data object Squad : FootballDestination("squad")

    data object PlayerDetails : FootballDestination(
        "player_details"
    ) {

        fun createRoute(playerId: Int) =
            "player_details/$playerId"

    }

}