package com.example.footballapp.ui.navigation

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.footballapp.ui.design.AppConstants
import com.example.footballapp.ui.screens.CompetitionsScreen
import com.example.footballapp.ui.screens.club.ClubScreen
import com.example.footballapp.ui.screens.clubs.ClubsScreen
import com.example.footballapp.ui.screens.fixtures.FixturesScreen
import com.example.footballapp.ui.screens.league.LeagueOverviewScreen
import com.example.footballapp.ui.screens.league.LeagueTableScreen
import com.example.footballapp.ui.screens.player.PlayerDetailsScreen
import com.example.footballapp.ui.screens.squad.SquadScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.footballapp.ui.screens.competitions.CompetitionMetadataDebugScreen
import com.example.footballapp.ui.screens.fixtures.FixtureDetailsScreen
import com.example.footballapp.ui.screens.fixtures.TeamFixturesScreen
import com.example.footballapp.ui.screens.league.LeagueExplorerScreen
import com.example.footballapp.ui.viewmodel.ClubViewModel
import com.example.footballapp.ui.viewmodel.ClubsViewModel
import com.example.footballapp.ui.viewmodel.CompetitionViewModel
import com.example.footballapp.ui.viewmodel.CountryViewModel
import com.example.footballapp.ui.viewmodel.FixtureDetailsViewModel
import com.example.footballapp.ui.viewmodel.FixturesViewModel
import com.example.footballapp.ui.viewmodel.LeagueOverviewViewModel
import com.example.footballapp.ui.viewmodel.LeagueTableViewModel
import com.example.footballapp.ui.viewmodel.PlayerDetailsViewModel
import com.example.footballapp.ui.viewmodel.SquadViewModel
import com.example.footballapp.ui.viewmodel.TeamFixturesViewModel


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

            val viewModel: CountryViewModel = viewModel()

            val countries by
            viewModel.countries.collectAsState()

            CompetitionsScreen(

                countries = countries,

                onCountrySelected = { country ->

                    // We will load this country's
                    // competitions in the next step.

                },

                onLeagueExplorerClick = {

                    navController.navigate(

                        FootballDestination
                            .LeagueExplorer
                            .route

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

                    currentRound = uiState.currentRound,

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
                                .createRoute(
                                    leagueId,
                                    clubId
                                )
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
                                .createRoute(
                                    leagueId,
                                    clubId
                                )

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

                        navController.navigate(

                            FootballDestination
                                .FixtureDetails
                                .createRoute(
                                    leagueId,
                                    fixtureId)

                        )

                    }

                )

            }

        }

        /**
         * Team Fixtures
         */

        composable(
            route = FootballDestination.TeamFixtures.route
        ) { backStackEntry ->

            val leagueId =
                backStackEntry.arguments
                    ?.getString("leagueId")
                    ?.toInt()
                    ?: return@composable

            val teamId =
                backStackEntry.arguments
                    ?.getString("teamId")
                    ?.toInt()
                    ?: return@composable

            /*
             * Club
             */
            val clubViewModel: ClubViewModel = viewModel()

            LaunchedEffect(teamId) {

                clubViewModel.loadClub(teamId)

            }

            val clubUiState by
            clubViewModel.uiState.collectAsState()

            /*
             * Fixtures
             */
            val teamFixturesViewModel: TeamFixturesViewModel = viewModel()

            val fixturesUiState by
            teamFixturesViewModel.uiState.collectAsState()

            LaunchedEffect(teamId) {

                teamFixturesViewModel.loadFixtures(

                    teamId = teamId,

                    leagueId = leagueId,

                    season = AppConstants.DEVELOPMENT_SEASON

                )

            }

            clubUiState.club?.let { club ->

                TeamFixturesScreen(

                    clubName = club.name,

                    season = AppConstants.DEVELOPMENT_SEASON_TEXT,

                    fixtureDays = fixturesUiState.fixtureDays,

                    onFixtureSelected = { fixtureId ->

                        navController.navigate(

                            FootballDestination
                                .FixtureDetails
                                .createRoute(
                                    leagueId,
                                    fixtureId)

                        )

                    }

                )
            }
        }


        /**
         * Fixture Details
         */

        composable(
            route = FootballDestination.FixtureDetails.route
        ) { backStackEntry ->

            val leagueId =
                backStackEntry.arguments
                    ?.getString("leagueId")
                    ?.toInt()
                    ?: return@composable

            val fixtureId =
                backStackEntry.arguments
                    ?.getString("fixtureId")
                    ?.toLong()
                    ?: return@composable

            val fixtureDetailsViewModel:
                    FixtureDetailsViewModel = viewModel()

            val uiState by fixtureDetailsViewModel
                .uiState
                .collectAsState()

            LaunchedEffect(fixtureId) {

                fixtureDetailsViewModel.loadFixture(
                    fixtureId
                )

            }

            uiState.fixture?.let { fixture ->

                FixtureDetailsScreen(

                    fixture = fixture,

                    lineup = uiState.lineup,

                    onPlayerClick = { playerId ->

                        navController.navigate(
                            FootballDestination.PlayerDetails.createRoute(
                                leagueId,
                                playerId)
                        )

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

                    overview = overview,

                    clubs = clubsState.clubs,

                    onClubClick = { clubId ->

                        navController.navigate(

                            FootballDestination
                                .Club
                                .createRoute(
                                    leagueId,
                                    clubId
                                )

                        )

                    }

                )

            }

        }

        /**
         * Club Screen
         */

        composable(
            route = FootballDestination.Club.route
        ) { backStackEntry ->

            val leagueId =
                backStackEntry.arguments
                    ?.getString("leagueId")
                    ?.toInt()
                    ?: return@composable

            val clubId =
                backStackEntry.arguments
                    ?.getString("clubId")
                    ?.toInt()
                    ?: return@composable

            val overviewViewModel: LeagueOverviewViewModel =
                viewModel()

            val clubViewModel: ClubViewModel =
                viewModel()

            LaunchedEffect(leagueId, clubId) {

                overviewViewModel.loadLeagueOverview(
                    leagueId,
                    AppConstants.DEVELOPMENT_SEASON
                )

                clubViewModel.loadClub(
                    clubId
                )

            }

            val overviewState by
            overviewViewModel.uiState.collectAsState()

            val clubState by
            clubViewModel.uiState.collectAsState()

            if (
                overviewState.overview != null &&
                clubState.club != null
            ) {

                ClubScreen(

                    overview =
                        overviewState.overview!!,

                    club =
                        clubState.club!!,

                    onFixturesClick = { selectedClubId ->

                        navController.navigate(

                            FootballDestination.TeamFixtures
                                .createRoute(
                                    leagueId,
                                    selectedClubId
                                )

                        )

                    },

                    onSquadClick = { selectedClubId ->

                        navController.navigate(

                            FootballDestination.Squad
                                .createRoute(
                                    leagueId,
                                    selectedClubId
                                )

                        )

                    }

                )

            }

        }

        /**
         * Squad
         */
        composable(
            route = FootballDestination.Squad.route
        ) { backStackEntry ->

            val leagueId =
                backStackEntry.arguments
                    ?.getString("leagueId")
                    ?.toInt()
                    ?: return@composable

            val clubId =
                backStackEntry.arguments
                    ?.getString("clubId")
                    ?.toInt()
                    ?: return@composable

            val clubViewModel: ClubViewModel = viewModel()
            val squadViewModel: SquadViewModel = viewModel()

            LaunchedEffect(clubId) {

                clubViewModel.loadClub(clubId)

                squadViewModel.loadPlayers(

                    teamId = clubId,

                    leagueId = leagueId,

                    season = AppConstants.DEVELOPMENT_SEASON

                )

            }

            val clubState by
            clubViewModel.uiState.collectAsState()

            val squadState by
            squadViewModel.uiState.collectAsState()

            clubState.club?.let { club ->

                SquadScreen(

                    clubName = club.name,

                    season = AppConstants.DEVELOPMENT_SEASON_TEXT,

                    players = squadState.players,

                    onPlayerClick = { playerId ->

                        navController.navigate(

                            FootballDestination
                                .PlayerDetails
                                .createRoute(
                                    leagueId,
                                    playerId)

                        )

                    }

                )

            }

        }

        /**
         * Player Details
         */
        composable(
            route = FootballDestination.PlayerDetails.route
        ) { backStackEntry ->

            val leagueId =
                backStackEntry.arguments
                    ?.getString("leagueId")
                    ?.toInt()
                    ?: return@composable

            val playerId =
                backStackEntry.arguments
                    ?.getString("playerId")
                    ?.toInt()
                    ?: return@composable


            val playerDetailsViewModel:
                    PlayerDetailsViewModel =
                viewModel()

            LaunchedEffect(
                leagueId,
                playerId
            ) {

                playerDetailsViewModel.loadPlayerDetails(

                    playerId = playerId,

                    leagueId = leagueId,

                    season = AppConstants.DEVELOPMENT_SEASON

                )

            }

            val playerState by
            playerDetailsViewModel
                .uiState
                .collectAsState()

            playerState.player?.let { player ->

                PlayerDetailsScreen(

                    player = player

                )

            }

        }

        /******************** LEAGUE EXPLORER ************************/
        composable(
            route = FootballDestination.LeagueExplorer.route
        ) {

            LeagueExplorerScreen(

                onViewLeagueTable = { leagueId ->

                    navController.navigate(

                        FootballDestination
                            .LeagueTable
                            .createRoute(
                                leagueId
                            )
                    )
                },

                onDebugCompetitionMetadata = {
                        leagueId,
                        season ->

                    navController.navigate(

                        FootballDestination
                            .CompetitionMetadataDebug
                            .createRoute(
                                leagueId,
                                season
                            )
                    )
                }
            )
        }

        /********************* Competition Metadata Debug *************************/

        composable(
            route =
                FootballDestination
                    .CompetitionMetadataDebug
                    .route
        ) { backStackEntry ->

            val leagueId =
                backStackEntry
                    .arguments
                    ?.getString("leagueId")
                    ?.toIntOrNull()

            val season =
                backStackEntry
                    .arguments
                    ?.getString("season")
                    ?.toIntOrNull()

            if (leagueId != null
                && season != null
            ) {

                CompetitionMetadataDebugScreen(
                    leagueId = leagueId,
                    season = season
                )
            }
        }
    }
}










