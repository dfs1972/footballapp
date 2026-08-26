package com.example.footballapp.ui.screens.competitions

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.footballapp.ui.viewmodel.CompetitionMetadataViewModel

@Composable
fun CompetitionMetadataDebugScreen(
    leagueId: Int,
    season: Int,
    viewModel: CompetitionMetadataViewModel =
        viewModel()
) {

    val metadata by
    viewModel.metadata.collectAsState()

    val isLoading by
    viewModel.isLoading.collectAsState()

    val error by
    viewModel.error.collectAsState()

    LaunchedEffect(
        leagueId,
        season
    ) {

        viewModel.loadMetadata(
            leagueId = leagueId,
            season = season
        )
    }

    Column {

        Text("Competition Metadata")

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        if (isLoading) {

            CircularProgressIndicator()

        } else if (error != null) {

            Text(
                text = "Error: $error"
            )

        } else if (metadata != null) {

            val data = metadata!!

            Text(
                text =
                    "Current round: " +
                            "${data.currentRound}"
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            Text(
                text =
                    "Standings groups: " +
                            "${data.standings.size}"
            )

            data.standings.forEach { group ->

                Text(
                    text =
                        "${group.group}: " +
                                "${group.standings.size} teams"
                )
            }

        } else {

            Text("No metadata loaded")

        }
    }
}