package com.example.footballapp.ui.screens.league

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.footballapp.ui.viewmodel.LeagueExplorerViewModel

@Composable
fun LeagueExplorerScreen(

    viewModel: LeagueExplorerViewModel =
        viewModel(),

    onViewLeagueTable: (Int) -> Unit = {},

    onDebugCompetitionMetadata: (
        Int,
        Int
    ) -> Unit = { _, _ -> }

) {

    var leagueId by remember {
        mutableStateOf("")
    }

    var season by remember {
        mutableStateOf("2026")
    }

    val uiState by viewModel.uiState.collectAsState()

    Column(

        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),

        verticalArrangement =
            Arrangement.spacedBy(12.dp)

    ) {

        Text(
            text = "League Explorer"
        )

        OutlinedTextField(

            value = leagueId,

            onValueChange = {
                leagueId = it
            },

            label = {
                Text("League ID")
            },

            keyboardOptions =
                KeyboardOptions(
                    keyboardType =
                        KeyboardType.Number
                ),

            singleLine = true,

            modifier =
                Modifier.fillMaxWidth()

        )

        OutlinedTextField(

            value = season,

            onValueChange = {
                season = it
            },

            label = {
                Text("Season")
            },

            keyboardOptions =
                KeyboardOptions(
                    keyboardType =
                        KeyboardType.Number
                ),

            singleLine = true,

            modifier =
                Modifier.fillMaxWidth()

        )

        Button(

            onClick = {

                val id =
                    leagueId.toIntOrNull()

                val year =
                    season.toIntOrNull()

                if (id != null
                    && year != null
                ) {

                    viewModel.loadLeague(
                        id,
                        year
                    )
                }
            },

            enabled =
                leagueId.isNotBlank()
                        && season.isNotBlank(),

            modifier =
                Modifier.fillMaxWidth()

        ) {

            Text("Load League")

        }

        if (uiState.isLoading) {

            CircularProgressIndicator()

        }

        uiState.error?.let { error ->

            Text(
                text = "Error: $error"
            )

        }

        uiState.league?.let { league ->

            Column(

                verticalArrangement =
                    Arrangement.spacedBy(6.dp)

            ) {

                Text(
                    text =
                        "League ID: ${league.leagueId}"
                )

                Text(
                    text =
                        "League: ${league.leagueName}"
                )

                Text(
                    text =
                        "Season: ${league.season}"
                )

                Spacer(
                    modifier =
                        Modifier.height(6.dp)
                )

                Button(

                    onClick = {
                        onViewLeagueTable(
                            league.leagueId
                        )
                    },

                    modifier =
                        Modifier.fillMaxWidth()

                ) {

                    Text(
                        "View League Table"
                    )

                }

                Button(
                    onClick = {

                        val id =
                            leagueId.toIntOrNull()

                        val year =
                            season.toIntOrNull()

                        if (id != null && year != null) {

                            onDebugCompetitionMetadata(
                                id,
                                year
                            )
                        }
                    },

                    enabled =
                        leagueId.isNotBlank()
                                && season.isNotBlank(),

                    modifier =
                        Modifier.fillMaxWidth()

                ) {

                    Text(
                        "DEBUG: Competition Metadata"
                    )

                }
            }
        }
    }
}