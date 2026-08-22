package com.example.footballapp.ui.navigation

sealed class FootballDestination(
    val route: String
) {

    object Competitions :
        FootballDestination(
            "competitions"
        ) {

        fun createRoute() =
            "competitions"
    }

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
            "leagueOverview/{leagueId}/{season}"
        ) {

        fun createRoute(
            leagueId: Int,
            season: Int
        ) = "leagueOverview/$leagueId/$season"
    }

    object LeagueTable :
        FootballDestination(
            "leagueTable/{leagueId}/{season}"
        ) {

        fun createRoute(
            leagueId: Int,
            season: Int
        ) = "leagueTable/$leagueId/$season"

    }

    object Fixtures :
        FootballDestination(
            "fixtures/{leagueId}/{season}"
        ) {

        fun createRoute(
            leagueId: Int,
            season: Int
        ) = "fixtures/$leagueId/$season"

    }

    object Clubs :
        FootballDestination(
            "clubs/{leagueId}/{season}"
        ) {

        fun createRoute(
            leagueId: Int,
            season: Int
        ) = "clubs/$leagueId/$season"

    }

    /**
     * Competition Metadata Debug
     */
    object CompetitionMetadataDebug :
        FootballDestination(
            "competitionMetadataDebug/{leagueId}/{season}"
        ) {

        fun createRoute(
            leagueId: Int,
            season: Int
        ) = "competitionMetadataDebug/$leagueId/$season"

    }

    // -------------------------------------------------------------------------
    // Club
    // -------------------------------------------------------------------------

    object Club :
        FootballDestination(
            "club/{leagueId}/{clubId}/{season}"
        ) {

        fun createRoute(
            leagueId: Int,
            clubId: Int,
            season: Int
        ) = "club/$leagueId/$clubId/$season"

    }

    /**
     * Squad
     */

    object Squad :
        FootballDestination(
            "squad/{leagueId}/{clubId}/{season}"
        ) {

        fun createRoute(
            leagueId: Int,
            clubId: Int,
            season: Int
        ) = "squad/$leagueId/$clubId/$season"
    }

    /**
     * Team Fixtures
     */

    object TeamFixtures :
        FootballDestination(
            "teamFixtures/{leagueId}/{teamId}/{season}"
        ) {

        fun createRoute(
            leagueId: Int,
            teamId: Int,
            season: Int
        ) = "teamFixtures/$leagueId/$teamId/$season"

    }

    /**
     * Fixture Details
     */

    object FixtureDetails : FootballDestination(
        "fixtureDetails/{leagueId}/{fixtureId}/{season}"
    ) {

        fun createRoute(
            leagueId: Int,
            fixtureId: Long,
            season: Int
        ) = "fixtureDetails/$leagueId/$fixtureId/$season"

    }

    /**
     * Player Details
     */
    object PlayerDetails :
        FootballDestination(
            "playerDetails/{leagueId}/{playerId}/{season}"
        ) {

        fun createRoute(
            leagueId: Int,
            playerId: Int,
            season: Int
        ) = "playerDetails/$leagueId/$playerId/$season"

    }
}