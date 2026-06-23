package com.example.footballapp.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
    onTeamClick: (Int) -> Unit
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

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {

            Text("Pos", Modifier.width(40.dp))
            Text("Team", Modifier.width(120.dp))
            Text("P", Modifier.width(30.dp))
            Text("W", Modifier.width(30.dp))
            Text("D", Modifier.width(30.dp))
            Text("L", Modifier.width(30.dp))
            Text("GD", Modifier.width(40.dp))
            Text("Pts", Modifier.width(40.dp))
        }
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(vertical = 8.dp)
//        ) {
//
//            Text(
//                text = "Pos",
//                modifier = Modifier.width(40.dp),
//                style = MaterialTheme.typography.titleMedium
//            )
//
//            Text(
//                text = "Team",
//                modifier = Modifier.weight(1f),
//                style = MaterialTheme.typography.titleMedium
//            )
//
//            Text(
//                text = "Pts",
//                modifier = Modifier.width(50.dp),
//                style = MaterialTheme.typography.titleMedium
//            )
//        }

        LazyColumn {

            items(table) { row ->

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {

                            onTeamClick(
                                row.teamId
                            )
                        }
                        .padding(vertical = 8.dp)
                ) {

                    Text(
                        text = row.position.toString(),
                        modifier = Modifier.width(40.dp)
                    )

                    Text(
                        text = row.teamName,
                        modifier = Modifier.width(120.dp)
                    )

                    Text(
                        text = row.played.toString(),
                        modifier = Modifier.width(30.dp)
                    )

                    Text(
                        text = row.wins.toString(),
                        modifier = Modifier.width(30.dp)
                    )

                    Text(
                        text = row.draws.toString(),
                        modifier = Modifier.width(30.dp)
                    )

                    Text(
                        text = row.losses.toString(),
                        modifier = Modifier.width(30.dp)
                    )

                    Text(
                        text = row.goalDifference.toString(),
                        modifier = Modifier.width(40.dp)
                    )

                    Text(
                        text = row.points.toString(),
                        modifier = Modifier.width(40.dp)
                    )
                }
            }
        }
    }
}