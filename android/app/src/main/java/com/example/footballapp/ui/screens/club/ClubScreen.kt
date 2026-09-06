package com.example.footballapp.ui.screens.club

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.footballapp.ui.components.InfoRow
import com.example.footballapp.ui.components.NavigationCard
import com.example.footballapp.ui.components.ScreenScaffold
import com.example.footballapp.ui.components.SectionCard
import com.example.footballapp.ui.components.SectionHeading
import com.example.footballapp.ui.design.AppSpacing
import com.example.footballapp.ui.model.ClubDetailsUiModel
import com.example.footballapp.ui.model.CountryUiModel
import com.example.footballapp.ui.theme.AppElevation
import com.example.footballapp.ui.theme.AppShapes
import com.example.footballapp.util.ColorUtils

@Composable
fun ClubScreen(

    leagueName: String,

    season: Int,

    club: ClubDetailsUiModel,

    onSquadClick: (Int) -> Unit,

    onFixturesClick: (Int) -> Unit,

    searchQuery: String = "",

    onSearchQueryChange: (String) -> Unit = {},

    searchResults: List<CountryUiModel> = emptyList(),

    onSearchResultClick: (CountryUiModel) -> Unit = {}

) {

    ScreenScaffold(
        searchQuery = searchQuery,
        onSearchQueryChange = onSearchQueryChange,
        searchResults = searchResults,
        onSearchResultClick = onSearchResultClick
    ) {

        item {

            Spacer(
                modifier = Modifier.height(
                    AppSpacing.ExtraLarge
                )
            )

        }

        item {

            val teamColor = ColorUtils.parseHexColor(club.colors?.player?.primary)
                ?: MaterialTheme.colorScheme.primary
            val contentColor = ColorUtils.getContrastColor(teamColor)

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = AppSpacing.Screen,
                        vertical = AppSpacing.Twelve
                    ),
                shape = AppShapes.Card,
                elevation = CardDefaults.cardElevation(
                    defaultElevation = AppElevation.Card
                ),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            ) {
                Column {
                    // Team Name with background
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(teamColor)
                            .padding(vertical = AppSpacing.Twenty, horizontal = AppSpacing.Medium),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "${club.name} Football Club",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = contentColor,
                            textAlign = TextAlign.Center
                        )
                    }

                    // Content with padding
                    Column(
                        modifier = Modifier.padding(AppSpacing.Twenty)
                    ) {
                        SectionHeading(
                            text = leagueName,
                            centered = true
                        )

                        Spacer(modifier = Modifier.height(AppSpacing.Small))

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