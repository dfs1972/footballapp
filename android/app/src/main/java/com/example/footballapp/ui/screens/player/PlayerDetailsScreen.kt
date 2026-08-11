package com.example.footballapp.ui.screens.player

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.footballapp.ui.components.CardHeader
import com.example.footballapp.ui.components.InfoRow
import com.example.footballapp.ui.components.ScreenScaffold
import com.example.footballapp.ui.components.SectionCard
import com.example.footballapp.ui.design.AppSpacing
import com.example.footballapp.ui.model.LeagueOverviewUiModel
import com.example.footballapp.ui.model.PlayerDetailsUiModel
import com.example.footballapp.util.DateFormatter

@Composable
fun PlayerDetailsScreen(

    player: PlayerDetailsUiModel

) {

    ScreenScaffold {

        item {

            Spacer(
                modifier = Modifier.height(
                    AppSpacing.ExtraLarge
                )
            )

        }

        /*
         * Player
         */

        item {

            SectionCard {

                CardHeader(

                    title = player.teamName?.let { "$it Football Club" } ?: "Club",

                    subtitle =
                        "${player.name} Details"

                )

                InfoRow(

                    label = "Shirt Number",

                    value =
                        player.shirtNumber?.toString()

                )

                InfoRow(

                    label = "Position",

                    value = player.position

                )

                InfoRow(

                    label = "Captain",

                    value =
                        if (player.captain)
                            "Yes"
                        else
                            "No"

                )

            }

        }

        /*
         * Personal
         */

        item {

            SectionCard {

                CardHeader(

                    title = "Personal"

                )

                InfoRow(

                    label = "Nationality",

                    value = player.nationality

                )

                InfoRow(

                    label = "Date of Birth",

                    value =
                        DateFormatter.formatDate(
                            player.dateOfBirth
                        )

                )

                InfoRow(

                    label = "Age",

                    value =
                        player.age?.toString()

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

        /*
         * Season Statistics
         */

        item {

            SectionCard {

                CardHeader(

                    title = "Season Statistics"

                )

                InfoRow(

                    label = "Appearances",

                    value =
                        player.appearances?.toString()

                )

                InfoRow(

                    label = "Starts",

                    value =
                        player.starts?.toString()

                )

                InfoRow(

                    label = "Goals",

                    value =
                        player.goals?.toString()

                )

                InfoRow(

                    label = "Assists",

                    value =
                        player.assists?.toString()

                )

                InfoRow(

                    label = "Yellow Cards",

                    value =
                        player.yellowCards?.toString()

                )

                InfoRow(

                    label = "Red Cards",

                    value =
                        player.redCards?.toString()

                )

                InfoRow(

                    label = "Minutes Played",

                    value =
                        player.minutesPlayed?.toString()

                )

            }

        }

    }

}