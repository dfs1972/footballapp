package com.example.footballapp.ui.screens.league

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.footballapp.ui.components.CompetitionRoundSelector
import com.example.footballapp.ui.components.NavigationCard
import com.example.footballapp.ui.components.ScreenScaffold
import com.example.footballapp.ui.components.TopStandingsCard
import com.example.footballapp.ui.design.AppSpacing
import com.example.footballapp.ui.design.Strings
import com.example.footballapp.ui.model.CountryUiModel
import com.example.footballapp.ui.model.LeagueOverviewUiModel
import com.example.footballapp.ui.model.LeagueTableGroupUiModel

@Composable
fun LeagueOverviewScreen(

    overview: LeagueOverviewUiModel,

    currentRound: String?,

    onLeagueTableClick: () -> Unit = {},

    topStandings:
    List<LeagueTableGroupUiModel>,

    onClubClick:
        (Int) -> Unit = {},

    searchQuery: String = "",

    onSearchQueryChange:
        (String) -> Unit = {},

    searchResults:
    List<CountryUiModel> = emptyList(),

    onSearchResultClick:
        (CountryUiModel) -> Unit = {}

) {

    ScreenScaffold(

        searchQuery = searchQuery,

        onSearchQueryChange =
            onSearchQueryChange,

        searchResults =
            searchResults,

        onSearchResultClick =
            onSearchResultClick

    ) {

        item {

            Spacer(
                modifier = Modifier.height(
                    AppSpacing.ExtraLarge
                )
            )

        }

        item {

            Text(
                text = "Current round: ${
                    currentRound ?: "Unknown"
                }"
            )

        }

        item {

            TopStandingsCard(

                leagueName = overview.leagueName,

                season = overview.season,

                standings = topStandings,

                onTeamClick = {

                    onClubClick(
                        it.teamId
                    )

                },

                onViewFullTable =
                    onLeagueTableClick

            )

        }

        item {

            NavigationCard(

                title =
                    Strings.LEAGUE_TABLE,

                subtitle =
                    Strings.VIEW_COMPLETE_STANDINGS,

                onClick =
                    onLeagueTableClick

            )

        }

    }

}