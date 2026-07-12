package com.example.footballapp.ui.navigation

sealed class FootballDestination(
    val route: String
) {

    object Competitions :
        FootballDestination(
            "competitions"
        )

    // -------------------------------------------------------------------------
    // Competition
    // -------------------------------------------------------------------------

    object LeagueOverview :
        FootballDestination(
            "leagueOverview/{leagueId}"
        ) {

        fun createRoute(
            leagueId: Int
        ) = "leagueOverview/$leagueId"

    }

    object LeagueTable :
        FootballDestination(
            "leagueTable/{leagueId}"
        ) {

        fun createRoute(
            leagueId: Int
        ) = "leagueTable/$leagueId"

    }

    object Fixtures :
        FootballDestination(
            "fixtures/{leagueId}"
        ) {

        fun createRoute(
            leagueId: Int
        ) = "fixtures/$leagueId"

    }

    object Clubs :
        FootballDestination(
            "clubs/{leagueId}"
        ) {

        fun createRoute(
            leagueId: Int
        ) = "clubs/$leagueId"

    }

    // -------------------------------------------------------------------------
    // Club
    // -------------------------------------------------------------------------

    object Club :
        FootballDestination(
            "club/{clubId}"
        ) {

        fun createRoute(
            clubId: Int
        ) = "club/$clubId"

    }

    object Squad :
        FootballDestination(
            "squad/{clubId}"
        ) {

        fun createRoute(
            clubId: Int
        ) = "squad/$clubId"

    }

    // -------------------------------------------------------------------------
    // Player
    // -------------------------------------------------------------------------

    object PlayerDetails :
        FootballDestination(
            "player/{playerId}"
        ) {

        fun createRoute(
            playerId: Int
        ) = "player/$playerId"

    }

}