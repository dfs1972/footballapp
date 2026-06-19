package com.example.footballapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.footballapp.TeamRepository

@Composable
fun TeamScreen(
    teamName: String,
    onFixturesClick: (String) -> Unit
) {

    val repository =
        TeamRepository()

    val team =
        repository.getTeamDetails(
            teamName
        )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = team.teamName,
            style =
                MaterialTheme.typography.headlineMedium
        )
        Spacer(
            modifier =
                Modifier.height(16.dp)
        )

        Text(
            text =
                "Position: ${team.position}"
        )

        Text(
            text =
                "Points: ${team.points}"
        )

        Text(
            text =
                "Form: ${team.form}"
        )

        Button(
            onClick = {
                onFixturesClick(
                    team.teamName
                )
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Recent Fixtures")
        }
    }
}