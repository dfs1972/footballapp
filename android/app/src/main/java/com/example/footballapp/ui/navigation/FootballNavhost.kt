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
import com.example.footballapp.ui.viewmodel.ClubsViewModel
import com.example.footballapp.ui.viewmodel.CompetitionViewModel
import com.example.footballapp.ui.viewmodel.FixturesViewModel
import com.example.footballapp.ui.viewmodel.LeagueOverviewViewModel
import com.example.footballapp.ui.viewmodel.LeagueTableViewModel


@Composable
fun FootballNavHost() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = FootballDestination.Competitions.route
    ) {

        /**
         * Competitions
         */
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

        /**
         * League Overview
         */

        composable(
            route = FootballDestination.LeagueOverview.route
        ) { backStackEntry ->

            val leagueId =
                backStackEntry.arguments
                    ?.getString("leagueId")
                    ?.toInt()
                    ?: return@composable

            val overviewViewModel: LeagueOverviewViewModel = viewModel()

            LaunchedEffect(leagueId) {

                overviewViewModel.loadLeagueOverview(
                    leagueId,
                    AppConstants.DEVELOPMENT_SEASON
                )

            }

            val uiState by
            overviewViewModel.uiState.collectAsState()

            uiState.overview?.let { overview ->

                LeagueOverviewScreen(

                    overview = overview,

                    topStandings = uiState.topStandings,

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

        /**
         * League Table
         */

        composable(
            route = FootballDestination.LeagueTable.route
        ) { backStackEntry ->

            val leagueId =
                backStackEntry.arguments
                    ?.getString("leagueId")
                    ?.toInt()
                    ?: return@composable

            val overviewViewModel: LeagueOverviewViewModel = viewModel()
            val tableViewModel: LeagueTableViewModel = viewModel()

            LaunchedEffect(leagueId) {

                overviewViewModel.loadLeagueOverview(
                    leagueId,
                    AppConstants.DEVELOPMENT_SEASON
                )

                tableViewModel.loadLeagueTable(
                    leagueId,
                    AppConstants.DEVELOPMENT_SEASON
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

        /**
         * Fixtures
         */

        composable(
            route = FootballDestination.Fixtures.route
        ) { backStackEntry ->

            val leagueId =
                backStackEntry.arguments
                    ?.getString("leagueId")
                    ?.toInt()
                    ?: return@composable

            val overviewViewModel: LeagueOverviewViewModel = viewModel()
            val fixturesViewModel: FixturesViewModel = viewModel()

            LaunchedEffect(leagueId) {

                overviewViewModel.loadLeagueOverview(
                    leagueId,
                    AppConstants.DEVELOPMENT_SEASON
                )

                fixturesViewModel.loadFixtures(
                    leagueId,
                    AppConstants.DEVELOPMENT_SEASON
                )

            }

            val overviewState by
            overviewViewModel.uiState.collectAsState()

            val fixturesState by
            fixturesViewModel.uiState.collectAsState()

            overviewState.overview?.let { overview ->

                FixturesScreen(

                    competitionName = overview.leagueName,

                    season = overview.season,

                    fixtureDays = fixturesState.fixtureDays,

                    onFixtureSelected = { fixtureId ->

                        // We'll wire this up later
                    }

                )

            }

        }

        /**
         * Clubs
         */

        composable(
            route = FootballDestination.Clubs.route
        ) { backStackEntry ->

            val leagueId =
                backStackEntry.arguments
                    ?.getString("leagueId")
                    ?.toInt()
                    ?: return@composable

            val overviewViewModel: LeagueOverviewViewModel = viewModel()
            val clubsViewModel: ClubsViewModel = viewModel()

            LaunchedEffect(leagueId) {

                overviewViewModel.loadLeagueOverview(
                    leagueId,
                    AppConstants.DEVELOPMENT_SEASON
                )

                clubsViewModel.loadClubs(
                    leagueId,
                    AppConstants.DEVELOPMENT_SEASON
                )

            }

            val overviewState by
            overviewViewModel.uiState.collectAsState()

            val clubsState by
            clubsViewModel.uiState.collectAsState()

            overviewState.overview?.let { overview ->

                ClubsScreen(

                    competitionName = overview.leagueName,

                    season = overview.season,

                    clubs = clubsState.clubs,

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

        /**
         * Club
         */

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

       /**
        * Squad
        */
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

        /**
         * Player Details
         */

        composable(
            FootballDestination.PlayerDetails.route
        ) {

            PlayerDetailsScreen(

                player = DemoData.player

            )

        }
    }
}