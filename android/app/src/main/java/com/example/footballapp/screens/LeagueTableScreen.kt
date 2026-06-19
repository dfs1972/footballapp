package com.example.footballapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.footballapp.AppState
import com.example.footballapp.repositories.LeagueRepository

@Composable
fun LeagueTableScreen(
    onTeamClick: (String) -> Unit
) {

    val repository =
        LeagueRepository()

    val table =
        repository.getLeagueTable()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            AppState.selectedLeagueName,
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(
            modifier =
                Modifier.height(16.dp)
        )

        LazyColumn {

            items(table) { row ->

                Button(
                    onClick = {
                        onTeamClick(
                            row.teamName
                        )
                    },
                    modifier = Modifier.padding(8.dp)
                ) {

                    Text(
                        "${row.position}. " +
                                "${row.teamName} - " +
                                "${row.points} pts"
                    )
                }
            }
        }
    }
}