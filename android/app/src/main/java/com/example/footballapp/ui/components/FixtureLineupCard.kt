package com.example.footballapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.example.footballapp.ui.design.AppSpacing
import com.example.footballapp.ui.model.FixtureLineupUiModel

@Composable
fun FixtureLineupCard(

    lineup: FixtureLineupUiModel,

    onPlayerClick: (Int) -> Unit

) {

    SectionCard {

        lineup.teams.forEach { team ->

            Column(

                verticalArrangement =
                    Arrangement.spacedBy(
                        AppSpacing.Small
                    )

            ) {

                Spacer(
                    modifier = Modifier.height(
                        AppSpacing.ExtraLarge
                    )
                )

                Text(
                    text = team.teamName,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
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

                Spacer(
                    modifier = Modifier.height(
                        AppSpacing.ExtraSmall
                    )
                )

                Text(
                    text = "Starting XI",
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