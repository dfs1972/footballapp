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

    lineup: FixtureLineupUiModel

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

                    text = team.teamId.toString(),

                    style =
                        MaterialTheme.typography.titleMedium,

                    fontWeight =
                        FontWeight.Bold

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

                team.players.forEach { player ->

                    Text(

                        text =
                            "${player.shirtNumber ?: "-"}  ${player.playerName}"

                    )

                }

            }

        }

    }

}