package com.example.footballapp.ui.screens.club

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.footballapp.ui.components.ClubBadge
import com.example.footballapp.ui.components.InfoRow
import com.example.footballapp.ui.components.NavigationCard
import com.example.footballapp.ui.components.ScreenScaffold
import com.example.footballapp.ui.components.SectionCard
import com.example.footballapp.ui.components.SectionHeading
import com.example.footballapp.ui.model.ClubDetailsUiModel
import com.example.footballapp.ui.previews.PreviewData
import com.example.footballapp.ui.theme.AppDimensions

@Composable
fun ClubScreen(

    club: ClubDetailsUiModel,

    onSquadClick: (Int) -> Unit,

    onFixturesClick: (Int) -> Unit

) {

    ScreenScaffold(

        title = club.name,

        subtitle = club.league,

        backgroundContent = {

            ClubBadge(

                logoUrl = club.badgeUrl,

                modifier = Modifier
                    .align(Alignment.Center)
                    .offset(x = (-24).dp, y = (-24).dp)
                    .size(AppDimensions.ImageLarge *8.5f)
                    .alpha(0.04f)

            )

        }

    ) {

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

                    label = "Manager",

                    value = club.manager

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

@Preview(showBackground = true)
@Composable
private fun ClubScreenPreview() {

    MaterialTheme {

        ClubScreen(

            club = PreviewData.RangersDetails,

            onSquadClick = {},

            onFixturesClick = {}

        )

    }

}