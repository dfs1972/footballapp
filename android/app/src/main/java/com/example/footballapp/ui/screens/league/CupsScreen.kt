package com.example.footballapp.ui.screens.league

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.footballapp.ui.components.NavigationCard
import com.example.footballapp.ui.components.ScreenScaffold
import com.example.footballapp.ui.components.SectionHeading
import com.example.footballapp.ui.design.AppSpacing
import com.example.footballapp.ui.model.CompetitionUiModel
import com.example.footballapp.ui.model.CountryUiModel
import com.example.footballapp.ui.model.LeagueOverviewUiModel
import com.example.footballapp.ui.theme.AppElevation
import com.example.footballapp.ui.theme.AppShapes
import com.example.footballapp.util.ColorUtils

@Composable
fun CupsScreen(
    overview: LeagueOverviewUiModel,
    competitions: List<CompetitionUiModel>,
    onCompetitionSelected: (Int, Int, String) -> Unit,
    searchQuery: String = "",
    onSearchQueryChange: (String) -> Unit = {},
    searchResults: List<CountryUiModel> = emptyList(),
    onSearchResultClick: (CountryUiModel) -> Unit = {},
    onAccountClick: () -> Unit = {}
) {
    ScreenScaffold(
        searchQuery = searchQuery,
        onSearchQueryChange = onSearchQueryChange,
        searchResults = searchResults,
        onSearchResultClick = onSearchResultClick,
        onAccountClick = onAccountClick
    ) {
        item {
            Spacer(modifier = Modifier.height(AppSpacing.ExtraLarge))
        }

        item {
            val headerColor = MaterialTheme.colorScheme.primary
            val contentColor = ColorUtils.getContrastColor(headerColor)

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
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(headerColor)
                            .padding(vertical = AppSpacing.Twenty, horizontal = AppSpacing.Medium),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = overview.leagueName,
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = contentColor,
                            textAlign = TextAlign.Center
                        )
                    }

                    Column(
                        modifier = Modifier.padding(AppSpacing.Twenty)
                    ) {
                        SectionHeading(
                            text = "${overview.countryName} Cups",
                            centered = true
                        )
                        Spacer(modifier = Modifier.height(AppSpacing.Small))
                        Text(
                            text = "Select a cup competition to view knockout fixtures and results.",
                            style = MaterialTheme.typography.bodyMedium,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
        }

        val cupCompetitions = competitions.filter {
            it.type.equals("CUP", ignoreCase = true)
        }

        if (cupCompetitions.isEmpty()) {
            item {
                Text(
                    text = "No cup competitions available.",
                    modifier = Modifier.padding(AppSpacing.Medium)
                )
            }
        } else {
            val currentSeason = overview.season.take(4).toIntOrNull() ?: 2024
            
            cupCompetitions.forEach { competition ->
                item {
                    NavigationCard(
                        title = competition.name,
                        subtitle = competition.type,
                        onClick = {
                            onCompetitionSelected(competition.id, currentSeason, competition.type)
                        }
                    )
                }
            }
        }
    }
}
