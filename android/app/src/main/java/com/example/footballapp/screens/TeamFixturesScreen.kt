package com.example.footballapp

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TeamFixturesScreen(
    teamName: String
) {

    val repository =
        TeamFixturesRepository()

    val fixtures =
        repository.getFixtures(
            teamName
        )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "$teamName Fixtures",
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
                        "${fixture.homeTeam} " +
                                "${fixture.homeGoals} - " +
                                "${fixture.awayGoals} " +
                                fixture.awayTeam,

                    modifier =
                        Modifier.padding(8.dp)
                )
            }
        }
    }
}