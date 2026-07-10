package com.example.footballapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.footballapp.ui.design.AppConstants
import com.example.footballapp.ui.previews.PreviewData
import com.example.footballapp.ui.screens.CompetitionsScreen
import com.example.footballapp.ui.screens.club.ClubScreen
import com.example.footballapp.ui.screens.clubs.ClubsScreen
import com.example.footballapp.ui.screens.fixtures.FixturesScreen
import com.example.footballapp.ui.screens.league.LeagueOverviewScreen
import com.example.footballapp.ui.screens.league.LeagueTableScreen
import com.example.footballapp.ui.screens.player.PlayerDetailsScreen
import com.example.footballapp.ui.screens.squad.SquadScreen

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

                },

                onClubClick = { _ ->

                    navController.navigate(
                        FootballDestination.Club.route
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
                        FootballDestination.Club.route
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

                season = AppConstants.CURRENT_SEASON,

                fixtureDays = listOf(

                    PreviewData.TodayFixtures,
                    PreviewData.TomorrowFixtures

                ),

                onFixtureSelected = { _ ->

                    navController.navigate(
                        FootballDestination.Fixtures.route
                    )

                }

            )

        }

        // ---------------------------------------------------------------------
        // Clubs
        // ---------------------------------------------------------------------

        composable(
            FootballDestination.Clubs.route
        ) {

            ClubsScreen(

                competitionName = DemoData.competition.name,

                season = AppConstants.CURRENT_SEASON,

                clubs = DemoData.clubs,

                onClubClick = { _ ->

                    navController.navigate(
                        FootballDestination.Club.route
                    )

                }

            )

        }

        //---------------------------------------------------------------------
        //Club
        //---------------------------------------------------------------------

        composable(
            FootballDestination.Club.route
        ) {

            ClubScreen(

                club = DemoData.club,

                onFixturesClick = {

                    navController.navigate(
                        FootballDestination.Fixtures.route
                    )

                },

                onSquadClick = {

                    navController.navigate(
                        FootballDestination.Squad.route
                    )

                }

            )

        }

        // ---------------------------------------------------------------------
// Squad
// ---------------------------------------------------------------------

        composable(
            FootballDestination.Squad.route
        ) {

            SquadScreen(

                clubName = DemoData.club.name,

                season = AppConstants.CURRENT_SEASON,

                players = DemoData.squad,

                onPlayerClick = { _ ->

                    navController.navigate(
                        FootballDestination.PlayerDetails.route
                    )

                }

            )

        }

        // ---------------------------------------------------------------------
// Player Details
// ---------------------------------------------------------------------

        composable(
            FootballDestination.PlayerDetails.route
        ) {

            PlayerDetailsScreen(

                player = DemoData.player

            )

        }
    }
}