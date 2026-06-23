package com.example.footballapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

import com.example.footballapp.AppState
import com.example.footballapp.repositories.TeamsApiRepository
import com.example.footballapp.model.TeamRow


@Composable
fun TeamsScreen(
    onTeamClick: (Int) -> Unit
) {

    var teams by remember {
        mutableStateOf<List<TeamRow>>(
            emptyList()
        )
    }

    LaunchedEffect(Unit) {

        teams =
            withContext(
                Dispatchers.IO
            ) {

                TeamsApiRepository()
                    .getTeams(
                        AppState.selectedLeagueId,
                        AppState.selectedSeason
                    )
            }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text =
                "${AppState.selectedLeagueName} Teams",
            style =
                MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier =
                Modifier.height(16.dp)
        )

        LazyColumn {

            items(teams) { team ->

                Button(
                    onClick = {
                        println(
                            "Clicked teamId = ${team.id}"
                        )

                        onTeamClick(
                            team.id
                        )
                    },
                    modifier =
                        Modifier.padding(8.dp)
                ) {

                    Text(
                        team.name
                    )
                }
            }
        }
    }
}