package com.example.footballapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.footballapp.ui.previews.PreviewData
import com.example.footballapp.ui.screens.clubs.ClubsScreen
import com.example.footballapp.ui.screens.competitions.CompetitionsScreen
import com.example.footballapp.ui.screens.fixtures.FixturesScreen
import com.example.footballapp.ui.screens.league.LeagueOverviewScreen
import com.example.footballapp.ui.screens.league.LeagueTableScreen

@Composable
fun FootballNavHost() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = FootballDestination.Competitions.route
    ) {

        // ---------------------------------------------------------------------
        // Competitions
        // ---------------------------------------------------------------------

        composable(FootballDestination.Competitions.route) {

            CompetitionsScreen(

                onCompetitionSelected = { _ ->

                    navController.navigate(
                        FootballDestination.LeagueOverview.route
                    )

                }

            )

        }

        // ---------------------------------------------------------------------
        // League
        // ---------------------------------------------------------------------

        composable(FootballDestination.LeagueOverview.route) {

            LeagueOverviewScreen(

                competition = DemoData.competition,

                onLeagueTableClick = {

                    navController.navigate(
                        FootballDestination.LeagueTable.route
                    )

                },

                onFixturesClick = {

                    navController.navigate(
                        FootballDestination.Fixtures.route
                    )

                },

                onClubsClick = {

                    navController.navigate(
                        FootballDestination.Clubs.route
                    )

                }

            )

        }

        composable(FootballDestination.LeagueTable.route) {

            LeagueTableScreen(

                competition = DemoData.competition,

                standings = PreviewData.ScottishPremiershipTable,

                onClubClick = { _ ->

                    navController.navigate(
                        FootballDestination.Clubs.route
                    )

                }

            )

        }

        // ---------------------------------------------------------------------
        // Fixtures
        // ---------------------------------------------------------------------

        composable(FootballDestination.Fixtures.route) {

            FixturesScreen(

                competitionName = DemoData.competition.name,

                season = DemoData.competition.season,

                fixtureDays = listOf(

                    PreviewData.TodayFixtures,
                    PreviewData.TomorrowFixtures

                ),

                onFixtureSelected = { _ ->

                    // Stage 4

                }

            )

        }

        // ---------------------------------------------------------------------
        // Clubs
        // ---------------------------------------------------------------------

        composable(FootballDestination.Clubs.route) {

            ClubsScreen(

                competitionName = DemoData.competition.name,

                season = DemoData.competition.season,

                clubs = DemoData.clubs,

                onClubClick = { _ ->

                    // Stage 3

                }

            )

        }

    }

}