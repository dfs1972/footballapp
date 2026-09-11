package com.example.footballapp.ui.screens.league

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.footballapp.ui.components.LeagueTableCard
import com.example.footballapp.ui.components.ScreenScaffold
import com.example.footballapp.ui.design.AppSpacing
import com.example.footballapp.ui.model.CountryUiModel
import com.example.footballapp.ui.model.LeagueOverviewUiModel
import com.example.footballapp.ui.model.LeagueTableGroupUiModel

@Composable
fun LeagueTableScreen(
    overview: LeagueOverviewUiModel,
    standings: List<LeagueTableGroupUiModel>,
    onClubClick: (Int) -> Unit,
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
        if (standings.isEmpty()) {
            item {
                Text(
                    text = "Standings are not yet available for this competition.",
                    modifier = Modifier.padding(AppSpacing.Medium)
                )
            }
        } else {
            item {
                LeagueTableCard(
                    leagueName = overview.leagueName,
                    season = overview.season,
                    table = standings,
                    onTeamClick = onClubClick
                )
            }
        }
    }
}
