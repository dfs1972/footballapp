package com.example.footballapp.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.footballapp.AppState
import com.example.footballapp.model.LeagueOverview
import com.example.footballapp.model.TableRow
import com.example.footballapp.repositories.LeagueApiRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun LeagueOverviewScreen(
    onLeagueTableClick: () -> Unit,
    onTeamsClick: () -> Unit,
    onFixturesClick: () -> Unit,
    onTeamClick: (Int) -> Unit
) {

    var overview by remember {
        mutableStateOf<LeagueOverview?>(null)
    }

    var tableRows by remember {
        mutableStateOf<List<TableRow>>(
            emptyList()
        )
    }

    LaunchedEffect(Unit) {

        withContext(
            Dispatchers.IO
        ) {

            val repository =
                LeagueApiRepository()

            overview =
                repository.getLeagueOverview(
                    AppState.selectedLeagueId,
                    AppState.selectedSeason
                )

            tableRows =
                repository.getLeagueTable(
                    AppState.selectedLeagueId,
                    AppState.selectedSeason
                )
        }
    }
    val champion =
        tableRows.getOrNull(0)?.teamName
            ?: "Unknown"

    val runnerUp =
        tableRows.getOrNull(1)?.teamName
            ?: "Unknown"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        /**
         *  Card Section
         */
        overview?.let { league ->

            Card(
                modifier =
                    Modifier.fillMaxWidth(),

                elevation =
                    CardDefaults.cardElevation(
                        defaultElevation = 4.dp
                    )
            ) {

                Column(
                    modifier =
                        Modifier.padding(16.dp)
                ) {

                    Text(
                        text = league.leagueName,

                        style =
                            MaterialTheme
                                .typography
                                .headlineMedium
                    )

                    Spacer(
                        modifier =
                            Modifier.height(12.dp)
                    )

                    Text(
                        text =
                            "Season: ${league.season}"
                    )

                    Text(
                        text = "Champion: $champion"
                    )

                    Text(
                        text = "Runner-up: $runnerUp"
                    )
                }
            }

            /**
             * Top 3 Section
             */
            Spacer(
                modifier =
                    Modifier.height(24.dp)
            )

            Text(
                text = "Top 3",
                style =
                    MaterialTheme.typography.titleMedium
            )

            Spacer(
                modifier =
                    Modifier.height(8.dp)
            )

            Row(
                modifier =
                    Modifier.fillMaxWidth()
            ) {

                Text(
                    text = "Pos",
                    modifier =
                        Modifier.width(40.dp),
                    style =
                        MaterialTheme.typography.labelMedium
                )

                Text(
                    text = "Team",
                    modifier =
                        Modifier.weight(1f),
                    style =
                        MaterialTheme.typography.labelMedium
                )

                Text(
                    text = "Pts",
                    style =
                        MaterialTheme.typography.labelMedium
                )
            }

            Spacer(
                modifier =
                    Modifier.height(4.dp)
            )

            tableRows
                .take(3)
                .forEach { row ->

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                onTeamClick(row.teamId)
                            }
                            .padding(vertical = 4.dp)
                    ) {

                        Text(
                            text =
                                row.position.toString(),
                            modifier =
                                Modifier.width(40.dp)
                        )

                        Text(
                            text =
                                row.teamName,
                            modifier =
                                Modifier.weight(1f),
                            fontWeight = FontWeight.SemiBold
                        )

                        Text(
                            text =
                                row.points.toString()
                        )
                    }

                    Spacer(
                        modifier =
                            Modifier.height(4.dp)
                    )
                }

            Spacer(
                modifier =
                    Modifier.height(24.dp)
            )

        } ?: run {

            Text(
                text = "Loading..."
            )
        }

        Spacer(
            modifier =
                Modifier.height(24.dp)
        )

        /**
         * Buttons for League Table, Teams and Fixtures
         */
        Button(
            onClick =
                onLeagueTableClick,

            modifier =
                Modifier.fillMaxWidth()
        ) {

            Text(
                "League Table"
            )
        }

        Spacer(
            modifier =
                Modifier.height(8.dp)
        )

        Button(
            onClick =
                onTeamsClick,

            modifier =
                Modifier.fillMaxWidth()
        ) {

            Text(
                "Teams"
            )
        }

        Spacer(
            modifier =
                Modifier.height(8.dp)
        )

        Button(
            onClick =
                onFixturesClick,

            modifier =
                Modifier.fillMaxWidth()
        ) {

            Text(
                "Fixtures"
            )
        }
    }
}