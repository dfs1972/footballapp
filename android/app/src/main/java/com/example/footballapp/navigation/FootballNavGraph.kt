package com.example.footballapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.footballapp.AppState

import com.example.footballapp.screens.FixturesScreen
import com.example.footballapp.screens.LeagueSelectionScreen
import com.example.footballapp.MainScreen
import com.example.footballapp.screens.FixtureDetailsScreen
import com.example.footballapp.screens.TeamFixturesScreen
import com.example.footballapp.screens.LeagueOverviewScreen
import com.example.footballapp.screens.LeagueTableScreen
import com.example.footballapp.screens.TeamScreen
import com.example.footballapp.screens.TeamsScreen

@Composable
fun FootballNavGraph() {

    val navController =
        rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {

        /** MainScreen */
        composable(
            Screen.Home.route
        ) {

            MainScreen(

                onLeagueSelectionClick = {
                    navController.navigate(
                        Screen.LeagueSelection.route
                    )
                },

                onLeagueTableClick = {
                    navController.navigate(
                        Screen.LeagueTable.route
                    )
                },

                onFixturesClick = {
                    navController.navigate(
                        Screen.Fixtures.route
                    )
                },
                onTeamsClick = {
                    navController.navigate(
                        Screen.Teams.route
                    )
                }
            )
        } // End of MainScreen

        /** LeagueSelectionScreen */
        composable(
            Screen.LeagueSelection.route
        ) {

            LeagueSelectionScreen(
                onLeagueClick = {
                        leagueId,
                        leagueName ->

                    AppState.selectedLeagueId =
                        leagueId

                    AppState.selectedLeagueName =
                        leagueName

                    navController.navigate(
                        Screen.LeagueOverview.route
                    )
                }
            )
        }

            /** LeagueTableScreen */
            composable(
                Screen.LeagueTable.route
            ) {

                LeagueTableScreen(
                    onTeamClick = { teamId ->

                        navController.navigate(
                            "team/$teamId"
                        )
                    }
                )
            }

            /** TeamScreen */
        composable(
            Screen.Team.route
        ) { backStackEntry ->

            val teamId =
                backStackEntry.arguments
                    ?.getString("teamId")
                    ?.toIntOrNull()
                    ?: 0
            println(
                "Team route teamId = $teamId"
            )

            TeamScreen(
                teamId = teamId,

                onFixturesClick = { teamName ->

                    navController.navigate(
                        "team_fixtures/$teamName"
                    )
                }
            )
        }

            /** FixturesScreen */
            composable(
                Screen.Fixtures.route
            ) {

                FixturesScreen(

                    onFixtureClick = { fixture ->

                        navController.navigate(
                            "fixture_details/${fixture.fixtureId}"
                        )
                    }
                )
            }

            /** FixtureDetailsScreen */
            composable(
                Screen.FixtureDetails.route
            ) { backStackEntry ->

                val fixtureId =
                    backStackEntry.arguments
                        ?.getString("fixtureId")
                        ?.toLongOrNull()
                        ?: 0L

                FixtureDetailsScreen(
                    fixtureId = fixtureId
                )
            }

            /** TeamsScreen */
            composable(
                Screen.Teams.route)
            {
                TeamsScreen(
                    onTeamClick = { teamId ->
                        println(
                            "NavGraph received teamId = $teamId"
                        )
                        navController.navigate(
                        "team/$teamId"
                    )
                }
            )
        }

        /** TeamFixturesScreen */
        composable(
            Screen.TeamFixtures.route
        ) { backStackEntry ->

            val teamName =
                backStackEntry.arguments
                    ?.getString("teamName")
                    ?: ""

            TeamFixturesScreen(
                teamName = teamName
            )
        }

        /** LeagueOverviewScreen */
        composable(
            Screen.LeagueOverview.route
        ) {

            LeagueOverviewScreen(

                onTableClick = {
                    navController.navigate(
                        Screen.LeagueTable.route
                    )
                },

                onTeamsClick = {
                    navController.navigate(
                        Screen.Teams.route
                    )
                },

                onFixturesClick = {
                    navController.navigate(
                        Screen.Fixtures.route
                    )
                }
            )
        }

    } // End of NavHost

} // End of FootballNavGraph
