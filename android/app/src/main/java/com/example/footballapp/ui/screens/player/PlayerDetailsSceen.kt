package com.example.footballapp.ui.screens.player

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.footballapp.ui.components.InfoRow
import com.example.footballapp.ui.components.PlayerPhoto
import com.example.footballapp.ui.components.ScreenScaffold
import com.example.footballapp.ui.components.SectionCard
import com.example.footballapp.ui.components.SectionHeading
import com.example.footballapp.ui.model.PlayerDetailsUiModel
import com.example.footballapp.ui.previews.PreviewData
import com.example.footballapp.ui.theme.AppDimensions
import com.example.footballapp.ui.design.AppSpacing

@Composable
fun PlayerDetailsScreen(

    player: PlayerDetailsUiModel

) {

    ScreenScaffold(

        title = player.name,

        subtitle = player.position

    ) {

        item {

            Column(

                modifier = Modifier.fillMaxWidth(),

                horizontalAlignment = Alignment.CenterHorizontally

            ) {

                PlayerPhoto(

                    photoUrl = player.photoUrl,

                    modifier = Modifier.size(
                        AppDimensions.ImageLarge
                    )

                )

            }

        }

        item {

            Column(

                verticalArrangement = Arrangement.spacedBy(
                    AppSpacing.Small
                )

            ) {

                SectionHeading(
                    text = "Player"
                )

                SectionCard {

                    InfoRow(
                        label = "Shirt Number",
                        value = player.shirtNumber?.toString()
                    )

                    InfoRow(
                        label = "Position",
                        value = player.position
                    )

                    InfoRow(
                        label = "Preferred Foot",
                        value = player.preferredFoot
                    )

                    InfoRow(
                        label = "Captain",
                        value = if (player.captain) "Yes" else "No"
                    )

                }

            }

        }

        item {

            Column(

                verticalArrangement = Arrangement.spacedBy(
                    AppSpacing.Small
                )

            ) {

                SectionHeading(
                    text = "Personal"
                )

                SectionCard {

                    InfoRow(
                        label = "Nationality",
                        value = player.nationality
                    )

                    InfoRow(
                        label = "Date of Birth",
                        value = player.dateOfBirth
                    )

                    InfoRow(
                        label = "Age",
                        value = player.age?.toString()
                    )

                    InfoRow(
                        label = "Height",
                        value = player.height
                    )

                    InfoRow(
                        label = "Weight",
                        value = player.weight
                    )

                }

            }

        }

        item {

            Column(

                verticalArrangement = Arrangement.spacedBy(
                    AppSpacing.Small
                )

            ) {

                SectionHeading(
                    text = "Season Statistics"
                )

                SectionCard {

                    InfoRow(
                        label = "Appearances",
                        value = player.appearances?.toString()
                    )

                    InfoRow(
                        label = "Goals",
                        value = player.goals?.toString()
                    )

                    InfoRow(
                        label = "Assists",
                        value = player.assists?.toString()
                    )

                    InfoRow(
                        label = "Yellow Cards",
                        value = player.yellowCards?.toString()
                    )

                    InfoRow(
                        label = "Red Cards",
                        value = player.redCards?.toString()
                    )

                    InfoRow(
                        label = "Minutes Played",
                        value = player.minutesPlayed?.toString()
                    )

                }

            }

        }

    }

}

@Preview(showBackground = true)
@Composable
private fun PlayerDetailsScreenPreview() {

    MaterialTheme {

        PlayerDetailsScreen(

            player = PreviewData.JamesTavernierDetails

        )

    }

}