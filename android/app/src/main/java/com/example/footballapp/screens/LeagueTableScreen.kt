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
import com.example.footballapp.AppState
import com.example.footballapp.repositories.LeagueApiRepository

import com.example.footballapp.model.TableRow
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun LeagueTableScreen(
    onTeamClick: (String) -> Unit
) {

    var table by remember {
        mutableStateOf<List<TableRow>>(
            emptyList()
        )
    }

    LaunchedEffect(Unit) {

        table =
            withContext(
                Dispatchers.IO
            ) {
                LeagueApiRepository()
                    .getLeagueTable(AppState.selectedLeagueId,
                        AppState.selectedSeason)
            }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = AppState.selectedLeagueName,
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(16.dp)
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
                        text =
                            "${row.position}. " +
                                    "${row.teamName} - " +
                                    "${row.points} pts"
                    )
                }
            }
        }
    }
}