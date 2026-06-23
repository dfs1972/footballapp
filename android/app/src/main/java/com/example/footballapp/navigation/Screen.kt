package com.example.footballapp.navigation

sealed class Screen(
    val route: String
) {

    object Home :
        Screen("home")

    object LeagueSelection :
        Screen("league_selection")

    object LeagueTable :
        Screen("league_table")

    object Team :
        Screen("team/{teamId}")

    object Fixtures :
        Screen("fixtures")

    object Teams :
        Screen("teams")

    object TeamFixtures :
        Screen("team_fixtures/{teamName}")

    object LeagueOverview :
        Screen("league_overview")

    object FixtureDetails :
        Screen(
            "fixture_details/{fixtureId}"
        )


}