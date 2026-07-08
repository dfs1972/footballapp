package com.example.footballapp.ui.screens.clubs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.footballapp.ui.components.ClubBadge
import com.example.footballapp.ui.components.InfoRow
import com.example.footballapp.ui.components.NavigationCard
import com.example.footballapp.ui.components.ScreenScaffold
import com.example.footballapp.ui.components.SectionCard
import com.example.footballapp.ui.model.ClubDetailsUiModel
import com.example.footballapp.ui.components.ClubBadge
import com.example.footballapp.ui.previews.PreviewData
import com.example.footballapp.ui.theme.AppDimensions
import com.example.footballapp.ui.theme.AppSpacing

@Composable
fun ClubScreen(

    club: ClubDetailsUiModel,

    onSquadClick: (Int) -> Unit,

    onFixturesClick: (Int) -> Unit

) {

    ScreenScaffold(

        title = club.name,

        subtitle = club.league

    ) {

        item {

            Column(

                modifier = Modifier.fillMaxWidth(),

                horizontalAlignment = Alignment.CenterHorizontally,

                verticalArrangement = Arrangement.spacedBy(
                    AppSpacing.Medium
                )

            ) {

                ClubBadge(

                    logoUrl = club.badgeUrl,

                    modifier = Modifier.size(
                        AppDimensions.ImageLarge
                    )

                )

            }

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

        item {

            NavigationCard(

                title = "Squad",

                subtitle = "Browse players",

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

                subtitle = "View club fixtures",

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