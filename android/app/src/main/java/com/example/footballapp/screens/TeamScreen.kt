package com.example.footballapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.footballapp.model.TeamDetails
import com.example.footballapp.repositories.TeamDetailsApiRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun TeamScreen(
    teamId: Int,
    onFixturesClick: (String) -> Unit
) {

    var teamDetails by remember {
        mutableStateOf<TeamDetails?>(
            null
        )
    }

    LaunchedEffect(
        teamId
    ) {

        teamDetails =
            withContext(
                Dispatchers.IO
            ) {

                TeamDetailsApiRepository()
                    .getTeamDetails(
                        teamId
                    )
            }
    }

    teamDetails?.let { team ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            Text(
                text =
                    team.team.name,
                style =
                    MaterialTheme.typography.headlineMedium
            )

            Spacer(
                modifier =
                    Modifier.height(16.dp)
            )

            Text(
                text =
                    "Position: ${team.leaguePosition}"
            )

            Text(
                text =
                    "Points: ${team.points}"
            )

            Text(
                text =
                    "Form: ${team.form}"
            )

            Spacer(
                modifier =
                    Modifier.height(16.dp)
            )

            Text(
                text =
                    "Founded: ${team.team.founded}"
            )

            Text(
                text =
                    "Country: ${team.team.country}"
            )

            Button(
                onClick = {

                    onFixturesClick(
                        team.team.name
                    )
                },
                modifier =
                    Modifier.padding(top = 16.dp)
            ) {

                Text(
                    "Recent Fixtures"
                )
            }
        }
    }
}