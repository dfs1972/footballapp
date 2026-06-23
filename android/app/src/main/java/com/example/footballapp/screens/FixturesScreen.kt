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
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.footballapp.AppState
import com.example.footballapp.model.FixtureRow
import com.example.footballapp.repositories.FixturesApiRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun FixturesScreen(
    onFixtureClick: (
        FixtureRow
    ) -> Unit
)
{

    var fixtures by remember {
        mutableStateOf<List<FixtureRow>>(
            emptyList()
        )
    }

    LaunchedEffect(Unit) {

        fixtures =
            withContext(
                Dispatchers.IO
            ) {

                FixturesApiRepository()
                    .getFixtures(
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
                "${AppState.selectedLeagueName} Fixtures",
            style =
                MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier =
                Modifier.height(16.dp)
        )

        LazyColumn {

            items(fixtures) { fixture ->

                Text(
                    text =
                        "${fixture.fixtureDate} ${fixture.fixtureTime}",
                    style =
                        MaterialTheme.typography.titleMedium
                )

                Button(
                    onClick = {

                        onFixtureClick(
                            fixture
                        )
                    }
                )
                {
                    Text(
                        "${fixture.homeTeam} " +
                                "${fixture.homeGoals} - " +
                                "${fixture.awayGoals} " +
                                fixture.awayTeam
                    )
                }

//                Text(
//                    text =
//                        fixture.round
//                )

                Spacer(
                    modifier =
                        Modifier.height(16.dp)
                )
            }
        }
    }
}