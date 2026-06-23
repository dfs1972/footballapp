package com.example.footballapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.footballapp.model.FixtureRow
import com.example.footballapp.repositories.FixtureDetailsApiRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun FixtureDetailsScreen(
    fixtureId: Long
) {

    var fixture by remember {

        mutableStateOf<FixtureRow?>(
            null
        )
    }

    LaunchedEffect(
        fixtureId
    ) {

        fixture =
            withContext(
                Dispatchers.IO
            ) {

                FixtureDetailsApiRepository()
                    .getFixture(
                        fixtureId
                    )
            }
    }

    fixture?.let {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            Text(
                text =
                    "Fixture Details",
                style =
                    MaterialTheme.typography.headlineMedium
            )

            Text(
                text =
                    it.fixtureDate
            )

//            Text(
//                text =
//                    it.round ?: ""
//            )

            Text(
                text =
                    it.homeTeam
            )

            Text(
                text =
                    "${it.homeGoals} - ${it.awayGoals}"
            )

            Text(
                text =
                    it.awayTeam
            )
        }
    }
}