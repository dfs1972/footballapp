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
import com.example.footballapp.model.LeagueUk
import com.example.footballapp.repositories.LeagueApiRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun LeagueSelectionScreen(
    onLeagueClick: (Int, String) -> Unit
) {

//    val repository =
//        LeagueSelectionRepository()
//
//    val leagues =
//        repository.getLeagues()
    var leagues by remember {
        mutableStateOf<List<LeagueUk>>(
            emptyList()
        )
    }

    LaunchedEffect(Unit) {

        leagues =
            withContext(
                Dispatchers.IO
            ) {

                LeagueApiRepository()
                    .getLeagues()
            }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Choose your League",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(
            modifier =
                Modifier.height(16.dp)
        )

        LazyColumn {

            items(leagues) { league ->

                Button(
                    onClick = {
                        onLeagueClick(
                            league.leagueId,
                            league.name
                        )
                    },
                    modifier = Modifier.padding(8.dp)
                ) {

                    Text(
                        league.name
                    )
                }
            }
        }
    }
}