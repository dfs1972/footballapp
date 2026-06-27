package com.example.footballapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.footballapp.AppState
import com.example.footballapp.model.PlayerDetails
import com.example.footballapp.repositories.LeagueApiRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun PlayerDetailsScreen(
    playerId: Int
) {

    var player by remember {
        mutableStateOf<PlayerDetails?>(null)
    }

    LaunchedEffect(playerId) {

        player =
            withContext(Dispatchers.IO) {

                LeagueApiRepository()
                    .getPlayerDetails(
                        playerId,
                        AppState.selectedLeagueId,
                        AppState.selectedSeason
                    )
            }
    }

    player?.let {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),

            verticalArrangement =
                Arrangement.spacedBy(16.dp)
        ) {

            PlayerCard(it)

            StatisticsCard(it)

            DisciplineCard(it)
        }

    } ?: Text(
        text = "Loading player..."
    )
}

@Composable
private fun PlayerCard(
    player: PlayerDetails
) {

    Card(
        modifier =
            Modifier.fillMaxWidth(),

        elevation =
            CardDefaults.cardElevation(
                defaultElevation = 4.dp
            )
    ) {

        Column(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp),

            horizontalAlignment =
                Alignment.CenterHorizontally
        ) {

            Text(
                text = "Player",

                style =
                    MaterialTheme.typography.titleLarge,

                fontWeight =
                    FontWeight.Bold
            )

            Spacer(
                modifier =
                    Modifier.height(16.dp)
            )

            AsyncImage(
                model = player.photoUrl,
                contentDescription = player.displayName,

                modifier =
                    Modifier
                        .size(140.dp)
                        .clip(CircleShape)
            )

            Spacer(
                modifier =
                    Modifier.height(16.dp)
            )

            Text(
                text = player.firstName + " " + player.lastName,

                style =
                    MaterialTheme.typography.headlineSmall,

                fontWeight =
                    FontWeight.Bold
            )

            Text(
                text = player.displayName,

                style =
                    MaterialTheme.typography.bodyMedium,

                color =
                    MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(
                modifier =
                    Modifier.height(16.dp)
            )

            DetailRow(
                "Nationality",
                player.nationality
            )

            DetailRow(
                "Age",
                player.age?.toString() ?: "-"
            )

            DetailRow(
                "Position",
                player.position
            )

            player.shirtNumber?.let {

                DetailRow(
                    "Shirt Number",
                    "#$it"
                )
            }
        }
    }
}

@Composable
private fun StatisticsCard(
    player: PlayerDetails
) {

    Card(
        modifier =
            Modifier.fillMaxWidth(),

        elevation =
            CardDefaults.cardElevation(
                defaultElevation = 4.dp
            )
    ) {

        Column(
            modifier =
                Modifier.padding(16.dp)
        ) {

            Text(
                text = "Season Statistics",
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            DetailRow(
                "Team",
                player.teamName ?: "-"
            )

            DetailRow(
                "Competition",
                player.leagueName ?: "-"
            )

            DetailRow(
                "Season",
                player.season?.toString() ?: "-"
            )

            HorizontalDivider(
                modifier = Modifier.padding(vertical = 8.dp)
            )

            DetailRow(
                "Appearances",
                "${player.appearances ?: 0}"
            )
        }
    }
}

@Composable
private fun DisciplineCard(
    player: PlayerDetails
) {

    Card(
        modifier =
            Modifier.fillMaxWidth(),

        elevation =
            CardDefaults.cardElevation(
                defaultElevation = 4.dp
            )
    ) {

        Column(
            modifier =
                Modifier.padding(16.dp)
        ) {

            Text(
                text = "Cards",

                style =
                    MaterialTheme.typography.titleLarge
            )

            Spacer(
                modifier =
                    Modifier.height(12.dp)
            )

            DetailRow(
                "Yellow Cards",
                "${player.yellowCards ?: 0}"
            )

            DetailRow(
                "Red Cards",
                "${player.redCards ?: 0}"
            )
        }
    }
}

@Composable
private fun DetailRow(
    label: String,
    value: String
) {

    Column {

        androidx.compose.foundation.layout.Row(
            modifier =
                Modifier.fillMaxWidth()
        ) {

            Text(
                text = label,

                modifier =
                    Modifier.weight(1f)
            )

            Text(
                text = value,

                fontWeight =
                    FontWeight.Bold
            )
        }

        HorizontalDivider(
            modifier =
                Modifier.padding(vertical = 6.dp)
        )
    }
}