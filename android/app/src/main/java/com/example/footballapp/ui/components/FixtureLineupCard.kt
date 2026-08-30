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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.footballapp.ui.design.AppSpacing
import com.example.footballapp.ui.model.FixtureLineupUiModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FixtureLineupCard(

    lineup: FixtureLineupUiModel,

    onPlayerClick: (Int) -> Unit

) {

    var expanded by remember { mutableStateOf(false) }
    
    var selectedTeam by remember(lineup) { 
        mutableStateOf(lineup.teams.firstOrNull()) 
    }

    SectionCard {

        if (lineup.teams.size > 1) {

            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = !expanded },
                modifier = Modifier.padding(AppSpacing.Medium)
            ) {
                OutlinedTextField(
                    value = selectedTeam?.teamName ?: "",
                    onValueChange = {},
                    readOnly = true,
                    label = { Text("Lineups") },
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .menuAnchor(),
                    colors = ExposedDropdownMenuDefaults.outlinedTextFieldColors()
                )

                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    lineup.teams.forEach { team ->
                        DropdownMenuItem(
                            text = { Text(team.teamName) },
                            onClick = {
                                selectedTeam = team
                                expanded = false
                            }
                        )
                    }
                }
            }
        }

        selectedTeam?.let { team ->

            Column(
                modifier = Modifier.padding(bottom = AppSpacing.Medium),
                verticalArrangement =
                    Arrangement.spacedBy(
                        AppSpacing.Small
                    )

            ) {

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

                Spacer(
                    modifier = Modifier.height(
                        AppSpacing.ExtraSmall
                    )
                )

                Text(
                    text = "Starting XI",
                    modifier = Modifier.padding(horizontal = AppSpacing.Medium),
                    style =
                        MaterialTheme
                            .typography
                            .titleSmall,
                    fontWeight =
                        FontWeight.SemiBold
                )

                val startingPlayers =
                    team.players
                        .filter { it.starting }
                        .sortedBy {
                            it.displayOrder
                        }

                startingPlayers.forEach { player ->

                    PlayerLineupRow(

                        player = player,

                        onClick = {
                            onPlayerClick(
                                player.playerId
                            )
                        }

                    )

                }

                Spacer(
                    modifier = Modifier.height(
                        AppSpacing.Small
                    )
                )

                Text(
                    text = "Substitutes",
                    modifier = Modifier.padding(horizontal = AppSpacing.Medium),
                    style =
                        MaterialTheme
                            .typography
                            .titleSmall,
                    fontWeight =
                        FontWeight.SemiBold
                )

                val substitutePlayers =
                    team.players
                        .filter { !it.starting }
                        .sortedBy {
                            it.displayOrder
                        }

                substitutePlayers.forEach { player ->

                    PlayerLineupRow(

                        player = player,

                        onClick = {
                            onPlayerClick(
                                player.playerId
                            )
                        }

                    )

                }

            }

        }

    }

}
