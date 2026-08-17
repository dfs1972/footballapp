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

    /**
     * Call any League
     */
    object LeagueExplorer :
        FootballDestination(
            "leagueExplorer"
        )

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
            "club/{leagueId}/{clubId}"
        ) {

        fun createRoute(
            leagueId: Int,
            clubId: Int
        ) = "club/$leagueId/$clubId"

    }

    /**
     * Squad
     */

    object Squad :
        FootballDestination(
            "squad/{leagueId}/{clubId}"
        ) {

        fun createRoute(
            leagueId: Int,
            clubId: Int
        ) = "squad/$leagueId/$clubId"

    }

    /**
     * Team Fixtures
     */

    object TeamFixtures :
        FootballDestination(
            "teamFixtures/{leagueId}/{teamId}"
        ) {

        fun createRoute(
            leagueId: Int,
            teamId: Int
        ) = "teamFixtures/$leagueId/$teamId"

    }

    /**
     * Fixture Details
     */

    object FixtureDetails : FootballDestination(
        "fixtureDetails/{leagueId}/{fixtureId}"
    ) {

        fun createRoute(
            leagueId: Int,
            fixtureId: Long
        ) = "fixtureDetails/$leagueId/$fixtureId"

    }

    /**
     * Player Details
     */
    object PlayerDetails :
        FootballDestination(
            "player/{leagueId}/{playerId}"
        ) {

        fun createRoute(
            leagueId: Int,
            playerId: Int
        ) = "player/$leagueId/$playerId"

    }

}