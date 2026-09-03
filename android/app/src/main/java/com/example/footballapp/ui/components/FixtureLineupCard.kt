package com.example.footballapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.footballapp.ui.design.AppSpacing
import com.example.footballapp.ui.model.FixtureLineupUiModel
import com.example.footballapp.ui.model.FixtureTeamLineupUiModel

@Composable
fun FixtureLineupCard(
    lineup: FixtureLineupUiModel,
    onPlayerClick: (Int) -> Unit,
    useCards: Boolean = true
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(AppSpacing.Medium)
    ) {
        lineup.teams.forEach { team ->
            if (useCards) {
                SectionCard {
                    TeamLineupContent(team, onPlayerClick)
                }
            } else {
                TeamLineupContent(team, onPlayerClick)
            }
        }
    }
}

@Composable
private fun TeamLineupContent(
    team: FixtureTeamLineupUiModel,
    onPlayerClick: (Int) -> Unit
) {
    Column(
        modifier = Modifier.padding(bottom = AppSpacing.Medium),
        verticalArrangement = Arrangement.spacedBy(AppSpacing.Small)
    ) {
        Text(
            text = team.teamName,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.padding(bottom = AppSpacing.Small)
        )

        InfoRow(
            label = "Coach",
            value = team.coachName
        )

        InfoRow(
            label = "Formation",
            value = team.formation
        )

        FormationPitch(
            team = team,
            onPlayerClick = onPlayerClick
        )

        Spacer(modifier = Modifier.height(AppSpacing.ExtraSmall))

        Text(
            text = "Starting XI",
            modifier = Modifier.padding(horizontal = AppSpacing.Medium),
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Bold
        )

        val startingPlayers = team.players
            .filter { it.starting }
            .sortedBy { it.displayOrder }

        startingPlayers.forEach { player ->
            PlayerLineupRow(
                player = player,
                onClick = { onPlayerClick(player.playerId) }
            )
        }

        Spacer(modifier = Modifier.height(AppSpacing.Small))

        Text(
            text = "Substitutes",
            modifier = Modifier.padding(horizontal = AppSpacing.Medium),
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Bold
        )

        val substitutePlayers = team.players
            .filter { !it.starting }
            .sortedBy { it.displayOrder }

        substitutePlayers.forEach { player ->
            PlayerLineupRow(
                player = player,
                onClick = { onPlayerClick(player.playerId) }
            )
        }
    }
}
