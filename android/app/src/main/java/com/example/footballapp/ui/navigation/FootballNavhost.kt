package com.example.footballapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.compose.runtime.collectAsState

import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import java.util.Calendar

import com.example.footballapp.ui.screens.club.ClubScreen
import com.example.footballapp.ui.screens.clubs.ClubsScreen
import com.example.footballapp.ui.screens.competitions.CompetitionsScreen
import com.example.footballapp.ui.screens.fixtures.FixtureDetailsScreen
import com.example.footballapp.ui.screens.fixtures.FixturesScreen
import com.example.footballapp.ui.screens.league.LeagueOverviewScreen
import com.example.footballapp.ui.screens.league.LeagueTableScreen
import com.example.footballapp.ui.screens.player.PlayerDetailsScreen
import com.example.footballapp.ui.screens.squad.SquadScreen
import com.example.footballapp.ui.screens.fixtures.TeamFixturesScreen

import com.example.footballapp.ui.viewmodel.ClubViewModel
import com.example.footballapp.ui.viewmodel.ClubsViewModel
import com.example.footballapp.ui.viewmodel.CompetitionViewModel
import com.example.footballapp.ui.viewmodel.FixturesViewModel
import com.example.footballapp.ui.viewmodel.LeagueOverviewViewModel
import com.example.footballapp.ui.viewmodel.LeagueTableViewModel
import com.example.footballapp.ui.viewmodel.PlayerDetailsViewModel
import com.example.footballapp.ui.viewmodel.SquadViewModel
import com.example.footballapp.ui.viewmodel.TeamFixturesViewModel

import com.example.footballapp.ui.viewmodel.CountryViewModel
import com.example.footballapp.ui.viewmodel.FixtureDetailsViewModel

@Composable
fun FootballNavHost(
    navController: NavHostController,
    startDestination: String
) {

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {

        /***************** Competitions ***********************/

        composable(
            route = FootballDestination.Competitions.route
        ) {

            val countryViewModel: CountryViewModel =
                viewModel()

            val competitionViewModel: CompetitionViewModel =
                viewModel()

            val countries by
            countryViewModel.countries.collectAsState()

            val competitions by
            competitionViewModel.competitions.collectAsState()

            val currentSeason =
                Calendar
                    .getInstance()
                    .get(Calendar.YEAR)

            var selectedSeason by rememberSaveable {

                mutableIntStateOf(
                    currentSeason
                )

            }

            CompetitionsScreen(

                countries = countries,

                competitions = competitions,

                currentSeason = currentSeason,

                selectedSeason = selectedSeason,

                onSeasonSelected = { season ->

                    selectedSeason = season

                },

                onCountrySelected = { country, season ->

                    competitionViewModel.loadCompetitions(

                        country = country.name,

                        season = season

                    )

                },

                onCompetitionSelected = { leagueId, season ->

                    navController.navigate(

                        FootballDestination
                            .LeagueOverview
                            .createRoute(
                                leagueId,
                                season
                            )

                    )

                },

                onLeagueExplorerClick = {
                    // Existing navigation/action.
                }

            )
        }


        /********************* League Overview ****************************/

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

            val overviewViewModel:
                    LeagueOverviewViewModel =
                viewModel()

            LaunchedEffect(leagueId, season) {

                overviewViewModel.loadLeagueOverview(
                    leagueId,
                    season
                )
            }

            val uiState by
            overviewViewModel.uiState.collectAsState()

            uiState.overview?.let { overview ->

                LeagueOverviewScreen(

                    overview = overview,

                    currentRound =
                        uiState.currentRound,

                    topStandings =
                        uiState.topStandings,

                    onLeagueTableClick = {

                        navController.navigate(

                            FootballDestination
                                .LeagueTable
                                .createRoute(
                                    leagueId,
                                    season
                                )
                        )
                    },

                    onFixturesClick = {

                        navController.navigate(

                            FootballDestination
                                .Fixtures
                                .createRoute(
                                    leagueId,
                                    season
                                )

                        )
                    },

                    onClubsClick = {

                        navController.navigate(

                            FootballDestination
                                .Clubs
                                .createRoute(
                                    leagueId = leagueId,
                                    season = season,
                                    leagueName = overview.leagueName
                                )

                        )
                    },

                    onClubClick = { clubId ->

                        navController.navigate(

                            FootballDestination
                                .Club
                                .createRoute(
                                    leagueId = leagueId,
                                    clubId = clubId,
                                    season = season,
                                    leagueName = overview.leagueName
                                )

                        )
                    }
                )
            }
        }


        /*************** League Table *******************/

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

            val overviewViewModel:
                    LeagueOverviewViewModel =
                viewModel()

            val tableViewModel:
                    LeagueTableViewModel =
                viewModel()

            LaunchedEffect(leagueId, season) {

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

                    standings =
                        tableState.table,

                    onClubClick = { clubId ->

                        navController.navigate(

                            FootballDestination
                                .Club
                                .createRoute(
                                    leagueId = leagueId,
                                    clubId = clubId,
                                    season = season,
                                    leagueName = overview.leagueName
                                )

                        )
                    }
                )
            }
        }


        /************* FIXTURES ********************/

        composable(
            route = FootballDestination.Fixtures.route
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

            val overviewViewModel:
                    LeagueOverviewViewModel =
                viewModel()

            val fixturesViewModel:
                    FixturesViewModel =
                viewModel()

            LaunchedEffect(leagueId, season) {

                overviewViewModel.loadLeagueOverview(
                    leagueId,
                    season
                )

                fixturesViewModel.loadFixtures(
                    leagueId,
                    season
                )
            }

            val overviewState by
            overviewViewModel.uiState.collectAsState()

            val fixturesState by
            fixturesViewModel.uiState.collectAsState()

            overviewState.overview?.let { overview ->

                FixturesScreen(

                    competitionName =
                        overview.leagueName,

                    season =
                        overview.season,

                    fixtureDays =
                        fixturesState.fixtureDays,

                    onFixtureSelected = { fixtureId, season ->

                        navController.navigate(

                            FootballDestination
                                .FixtureDetails
                                .createRoute(
                                    leagueId,
                                    fixtureId,
                                    season
                                )

                        )
                    },
                )
            }
        }


        /****************** CLUBS ***********************/

        composable(
            route = FootballDestination.Clubs.route
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

            val leagueName =
                backStackEntry.arguments
                    ?.getString("leagueName")
                    ?: return@composable

            val clubsViewModel:
                    ClubsViewModel =
                viewModel()

            LaunchedEffect(
                leagueId,
                season
            ) {

                clubsViewModel.loadClubs(
                    leagueId,
                    season
                )

            }

            val clubsState by
            clubsViewModel.uiState.collectAsState()

            ClubsScreen(

                leagueName = leagueName,

                season = season,

                clubs = clubsState.clubs,

                onClubClick = { clubId ->

                    navController.navigate(

                        FootballDestination
                            .Club
                            .createRoute(
                                leagueId = leagueId,
                                clubId = clubId,
                                season = season,
                                leagueName = leagueName
                            )
                    )

                }

            )
        }

        /**************** CLUB **********************/

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

            val season =
                backStackEntry.arguments
                    ?.getString("season")
                    ?.toInt()
                    ?: return@composable

            val leagueName =
                backStackEntry.arguments
                    ?.getString("leagueName")
                    ?: return@composable

            /*
             * Club
             */

            val clubViewModel:
                    ClubViewModel =
                viewModel()

            val clubState by
            clubViewModel.uiState.collectAsState()

            LaunchedEffect(clubId) {

                clubViewModel.loadClub(
                    clubId
                )

            }

            /*
             * Display Club
             */

            clubState.club?.let { club ->

                ClubScreen(

                    leagueName =
                        leagueName,

                    season =
                        season,

                    club =
                        club,

                    onFixturesClick = { selectedClubId ->

                        navController.navigate(

                            FootballDestination
                                .TeamFixtures
                                .createRoute(
                                    leagueId,
                                    selectedClubId,
                                    season
                                )

                        )

                    },

                    onSquadClick = { selectedClubId ->

                        navController.navigate(

                            FootballDestination
                                .Squad
                                .createRoute(
                                    leagueId,
                                    selectedClubId,
                                    season
                                )

                        )

                    }

                )

            }
        }

        /*************** SQUAD ********************/

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

            val season =
                backStackEntry.arguments
                    ?.getString("season")
                    ?.toInt()
                    ?: return@composable

            val clubViewModel:
                    ClubViewModel =
                viewModel()

            val squadViewModel:
                    SquadViewModel =
                viewModel()

            LaunchedEffect(clubId) {

                clubViewModel.loadClub(
                    clubId
                )

            }

            LaunchedEffect(
                clubId,
                leagueId,
                season
            ) {

                squadViewModel.loadPlayers(

                    teamId = clubId,

                    leagueId = leagueId,

                    season = season

                )
            }

            val clubState by
            clubViewModel.uiState.collectAsState()

            val squadState by
            squadViewModel.uiState.collectAsState()

            clubState.club?.let { club ->

                SquadScreen(

                    clubName =
                        club.name,

                    season =
                        season.toString(),

                    players =
                        squadState.players,

                    onPlayerClick = { playerId ->

                        navController.navigate(

                            FootballDestination
                                .PlayerDetails
                                .createRoute(
                                    leagueId,
                                    playerId,
                                    season
                                )

                        )
                    }
                )
            }
        }


        /****************** TEAM FIXTURES ************************/

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

            val season =
                backStackEntry.arguments
                    ?.getString("season")
                    ?.toInt()
                    ?: return@composable

            val clubViewModel:
                    ClubViewModel =
                viewModel()

            val teamFixturesViewModel:
                    TeamFixturesViewModel =
                viewModel()

            LaunchedEffect(teamId) {

                clubViewModel.loadClub(
                    teamId
                )
            }

            val clubUiState by
            clubViewModel.uiState.collectAsState()

            val fixturesUiState by
            teamFixturesViewModel
                .uiState
                .collectAsState()

            LaunchedEffect(
                teamId,
                leagueId,
                season
            ) {

                teamFixturesViewModel.loadFixtures(

                    teamId = teamId,

                    leagueId = leagueId,

                    season = season

                )
            }

            clubUiState.club?.let { club ->

                TeamFixturesScreen(

                    clubName =
                        club.name,

                    season =
                        season.toString(),

                    fixtureDays =
                        fixturesUiState.fixtureDays,

                    onFixtureSelected = { fixtureId, selectedSeason ->

                        navController.navigate(

                            FootballDestination
                                .FixtureDetails
                                .createRoute(
                                    leagueId,
                                    fixtureId,
                                    selectedSeason
                                )

                        )
                    },
                )
            }
        }

        /*
         * Fixture Details
         *
         * Fixture details are loaded using fixtureId.
         * No season is required by the current ViewModel.
         */

        composable(
            route = FootballDestination
                .FixtureDetails
                .route
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

            val season =
                backStackEntry.arguments
                    ?.getString("season")
                    ?.toInt()
                    ?: return@composable

            val fixtureDetailsViewModel:
                    FixtureDetailsViewModel =
                viewModel()

            LaunchedEffect(fixtureId) {

                fixtureDetailsViewModel
                    .loadFixture(
                        fixtureId
                    )
            }

            val uiState by
            fixtureDetailsViewModel
                .uiState
                .collectAsState()

            uiState.fixture?.let { fixture ->

                FixtureDetailsScreen(

                    fixture = fixture,

                    lineup = uiState.lineup,

                    onPlayerClick = { playerId ->

                        navController.navigate(

                            FootballDestination
                                .PlayerDetails
                                .createRoute(
                                    leagueId = leagueId,
                                    playerId = playerId,
                                    season = season
                                )
                        )
                    }
                )
            }
        }


        /*************** PLAYER DETAILS ***********************/

        composable(
            route = FootballDestination
                .PlayerDetails
                .route
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

            val season =
                backStackEntry.arguments
                    ?.getString("season")
                    ?.toInt()
                    ?: return@composable

            val playerDetailsViewModel:
                    PlayerDetailsViewModel =
                viewModel()

            LaunchedEffect(
                playerId,
                leagueId,
                season
            ) {

                playerDetailsViewModel
                    .loadPlayerDetails(

                        playerId =
                            playerId,

                        leagueId =
                            leagueId,

                        season =
                            season

                    )
            }

            val uiState by
            playerDetailsViewModel
                .uiState
                .collectAsState()

            uiState.player?.let { player ->

                PlayerDetailsScreen(

                    player = player

                )
            }
        }
    }
}