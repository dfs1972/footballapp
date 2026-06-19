package com.example.footballapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.footballapp.AppState
import com.example.footballapp.FixturesScreen
import com.example.footballapp.LeagueSelectionScreen
import com.example.footballapp.MainScreen
import com.example.footballapp.TeamFixturesScreen
import com.example.footballapp.TeamsScreen
import com.example.footballapp.screens.LeagueOverviewScreen
import com.example.footballapp.screens.LeagueTableScreen
import com.example.footballapp.screens.TeamScreen

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
                    onTeamClick = { teamName ->

                        navController.navigate(
                            "team/$teamName"
                        )
                    }
                )
            }

            /** TeamScreen */
            composable(
                Screen.Team.route
            ) { backStackEntry ->

                val teamName =
                    backStackEntry.arguments
                        ?.getString("teamName")
                        ?: ""

                TeamScreen(
                    teamName = teamName,

                    onFixturesClick = {

                        navController.navigate(
                            "team_fixtures/$it"
                        )
                    }
                )
            }

            /** FixturesScreen */
            composable(
                Screen.Fixtures.route
            ) {

                FixturesScreen()
            }

            /** TeamsScreen */
            composable(
                Screen.Teams.route
            )   {

                TeamsScreen(
                    onTeamClick = { teamName ->

                        navController.navigate(
                        "team/$teamName"
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
