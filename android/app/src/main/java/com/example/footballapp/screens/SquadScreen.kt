package com.example.footballapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.compose.AsyncImage
import com.example.footballapp.AppState
import com.example.footballapp.model.PlayerSummary
import com.example.footballapp.repositories.LeagueApiRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip

@Composable
fun SquadScreen(
    teamId: Int,
    onPlayerClick: (Int) -> Unit = {}
) {

    var players by remember {
        mutableStateOf<List<PlayerSummary>>(
            emptyList()
        )
    }

    LaunchedEffect(teamId) {

        players =
            withContext(Dispatchers.IO) {

                LeagueApiRepository()
                    .getTeamPlayers(
                        teamId,
                        AppState.selectedLeagueId,
                        AppState.selectedSeason
                    )
            }
    }

    val groupedPlayers =
        players.groupBy {
            it.position
        }

    LazyColumn(
        modifier =
            Modifier
                .fillMaxSize()
                .padding(16.dp),

        verticalArrangement =
            Arrangement.spacedBy(16.dp)
    ) {

        groupedPlayers.forEach {

                (position, squad) ->

            val heading = when (position) {
                "Goalkeeper" -> "Goalkeepers"
                "Defender" -> "Defenders"
                "Midfielder" -> "Midfielders"
                "Attacker" -> "Attackers"
                else -> position
            }

            item {

                Text(
                    text = heading,

                    style =
                        MaterialTheme.typography.headlineSmall
                )
            }

            items(squad) { player ->

                Card(

                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .clickable {

                                onPlayerClick(
                                    player.playerId
                                )
                            },

                    elevation =
                        CardDefaults.cardElevation(
                            defaultElevation = 4.dp
                        )
                ) {

                    Row(

                        modifier =
                            Modifier
                                .fillMaxWidth()
                                .padding(12.dp),

                        verticalAlignment =
                            Alignment.CenterVertically
                    ) {

                        AsyncImage(
                            model = player.photoUrl,
                            contentDescription = player.displayName,
                            modifier = Modifier.size(72.dp).clip(CircleShape)
                        )

                        Spacer(
                            modifier =
                                Modifier.width(16.dp)
                        )

                        Column {

                            Row(
                                verticalAlignment =
                                    Alignment.CenterVertically
                            ) {

                                Text(

                                    text =
                                        player.displayName,

                                    style =
                                        MaterialTheme
                                            .typography
                                            .titleMedium
                                )

                                if (player.captain) {

                                    Text(
                                        text = " (C)"
                                    )
                                }
                            }

                            Spacer(
                                modifier =
                                    Modifier.height(4.dp)
                            )

                            Text(
                                text =
                                    "${player.nationality} • Age ${
                                        player.age ?: "-"
                                    }"
                            )

                            Spacer(
                                modifier =
                                    Modifier.height(4.dp)
                            )

                            val stats =
                                buildString {

                                    append(
                                        "Apps ${
                                            player.appearances ?: 0
                                        }"
                                    )

                                    if ((player.goals ?: 0) > 0) {

                                        append(
                                            "   Goals ${player.goals}"
                                        )
                                    }

                                    if ((player.assists ?: 0) > 0) {

                                        append(
                                            "   Assists ${player.assists}"
                                        )
                                    }

                                    player.shirtNumber?.let {

                                        append(
                                            "   #$it"
                                        )
                                    }
                                }

                            Text(stats)
                        }
                    }
                }
            }
        }
    }
}