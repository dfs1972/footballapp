package com.example.footballapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.footballapp.AppState

@Composable
fun LeagueOverviewScreen(
    onTableClick: () -> Unit,
    onTeamsClick: () -> Unit,
    onFixturesClick: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),

        verticalArrangement =
            Arrangement.Center,

        horizontalAlignment =
            Alignment.CenterHorizontally
    ) {

        Text(
            text = AppState.selectedLeagueName,
            style = MaterialTheme.typography.headlineMedium
        )

        Button(
            onClick = onTableClick,
            modifier = Modifier.padding(top = 24.dp)
        ) {
            Text("League Table")
        }

        Button(
            onClick = onTeamsClick,
            modifier = Modifier.padding(top = 12.dp)
        ) {
            Text("Teams")
        }

        Button(
            onClick = onFixturesClick,
            modifier = Modifier.padding(top = 12.dp)
        ) {
            Text("Fixtures")
        }
    }
}