package com.example.footballapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.LaunchedEffect
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.footballapp.ui.viewmodel.CompetitionViewModel
import com.example.footballapp.ui.viewmodel.LeagueOverviewViewModel
import com.example.footballapp.ui.viewmodel.LeagueTableViewModel


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

        composable(
            FootballDestination.Competitions.route
        ) {

            val viewModel: CompetitionViewModel = viewModel()

            val uiState by
            viewModel.uiState.collectAsState()

            CompetitionsScreen(

                competitionGroups =
                    uiState.competitionGroups,

                onCompetitionSelected = { competition ->

                    navController.navigate(

                        FootballDestination
                            .LeagueOverview
                            .createRoute(
                                competition.id)

                    )

                }

            )

        }

        // ---------------------------------------------------------------------
        // League
        // ---------------------------------------------------------------------

        composable(
            route = FootballDestination.LeagueOverview.route
        ) { backStackEntry ->

            val leagueId =
                backStackEntry.arguments
                    ?.getString("leagueId")
                    ?.toInt()
                    ?: return@composable

            val season =
                backStackEntry.arguments
                    ?.getString("season")
                    ?.toInt()
                    ?: return@composable

            val viewModel: LeagueOverviewViewModel = viewModel()

            LaunchedEffect(leagueId) {

                viewModel.loadLeagueOverview(
                    leagueId,
                    season
                )

            }

            val uiState by
            viewModel.uiState.collectAsState()

            uiState.overview?.let { overview ->

                LeagueOverviewScreen(

                    overview = overview,

                    onLeagueTableClick = {

                        navController.navigate(

                            FootballDestination
                                .LeagueTable
                                .createRoute(leagueId)

                        )

                    },

                    onFixturesClick = {

                        navController.navigate(

                            FootballDestination
                                .Fixtures
                                .createRoute(leagueId)

                        )

                    },

                    onClubsClick = {

                        navController.navigate(

                            FootballDestination
                                .Clubs
                                .createRoute(leagueId)

                        )

                    },

                    onClubClick = { clubId ->

                        navController.navigate(

                            FootballDestination
                                .Club
                                .createRoute(clubId)

                        )

                    }

                )

            }

        }

        composable(
            route = FootballDestination.LeagueTable.route
        ) { backStackEntry ->

            val leagueId =
                backStackEntry.arguments
                    ?.getString("leagueId")
                    ?.toInt()
                    ?: return@composable

            val season =
                backStackEntry.arguments
                    ?.getString("season")
                    ?.toInt()
                    ?: return@composable

            val overviewViewModel: LeagueOverviewViewModel = viewModel()
            val tableViewModel: LeagueTableViewModel = viewModel()

            LaunchedEffect(leagueId) {

                overviewViewModel.loadLeagueOverview(
                    leagueId,
                    season
                )

                tableViewModel.loadLeagueTable(
                    leagueId,
                    season
                )

            }

            val overviewState by
            overviewViewModel.uiState.collectAsState()

            val tableState by
            tableViewModel.uiState.collectAsState()

            overviewState.overview?.let { overview ->

                LeagueTableScreen(

                    overview = overview,

                    standings = tableState.table,

                    onClubClick = { clubId ->

                        navController.navigate(

                            FootballDestination
                                .Club
                                .createRoute(clubId)

                        )

                    }

                )

            }

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