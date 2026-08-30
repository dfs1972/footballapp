package com.example.footballapp.ui.screens.league

import androidx.compose.runtime.Composable
import com.example.footballapp.ui.components.LeagueTableCard
import com.example.footballapp.ui.components.ScreenScaffold
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

    onSearchResultClick: (CountryUiModel) -> Unit = {}

) {

    ScreenScaffold(
        searchQuery = searchQuery,
        onSearchQueryChange = onSearchQueryChange,
        searchResults = searchResults,
        onSearchResultClick = onSearchResultClick
    ) {

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