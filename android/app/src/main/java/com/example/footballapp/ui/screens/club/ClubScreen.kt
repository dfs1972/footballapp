package com.example.footballapp.ui.screens.club

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.footballapp.ui.components.InfoRow
import com.example.footballapp.ui.components.NavigationCard
import com.example.footballapp.ui.components.ScreenScaffold
import com.example.footballapp.ui.components.SectionCard
import com.example.footballapp.ui.components.SectionHeading
import com.example.footballapp.ui.design.AppSpacing
import com.example.footballapp.ui.model.ClubDetailsUiModel

@Composable
fun ClubScreen(

    club: ClubDetailsUiModel,

    onSquadClick: (Int) -> Unit,

    onFixturesClick: (Int) -> Unit

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
         * Club Information
         */

        item {

            SectionHeading(

                text = "Club Information"

            )

        }

        item {

            SectionCard {

                InfoRow(

                    label = "Founded",

                    value = club.founded?.toString()

                )

                InfoRow(

                    label = "Stadium",

                    value = club.stadium

                )

                InfoRow(

                    label = "Capacity",

                    value = club.capacity?.toString()

                )

                InfoRow(

                    label = "Coach",

                    value = club.coach

                )

            }

        }

        /*
         * Navigation
         */

        item {

            NavigationCard(

                title = "Squad",

                subtitle = "View first-team squad",

                onClick = {

                    onSquadClick(

                        club.clubId

                    )

                }

            )

        }

        item {

            NavigationCard(

                title = "Fixtures",

                subtitle = "Current and upcoming matches",

                onClick = {

                    onFixturesClick(

                        club.clubId

                    )

                }

            )

        }

    }

}