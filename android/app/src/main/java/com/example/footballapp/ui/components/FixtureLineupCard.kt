package com.example.footballapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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

                Text(

                    text = "Players",

                    style =
                        MaterialTheme.typography.titleSmall,

                    fontWeight =
                        FontWeight.Bold

                )

                val groupedPlayers = team.players.groupBy { player ->
                    when (player.position) {
                        "G" -> "Goalkeeper"
                        "D" -> "Defenders"
                        "M" -> "Midfielders"
                        "F" -> "Forwards"
                        else -> "Other"
                    }
                }

                groupedPlayers.forEach { (position, players) ->

                    Text(
                        text = position,
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.SemiBold
                    )

                    players.forEach { player ->

                        PlayerLineupRow(

                            player = player,

                            onClick = {

                                onPlayerClick(player.playerId)

                            }

                        )

                    }

                }

            }

        }

    }

}