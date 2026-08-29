package com.example.footballapp.ui.screens.league

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.footballapp.data.repository.FavouriteCompetition
import com.example.footballapp.ui.components.CompetitionRow
import com.example.footballapp.ui.components.CompetitionRoundSelector
import com.example.footballapp.ui.components.CountryCard
import com.example.footballapp.ui.components.NavigationCard
import com.example.footballapp.ui.components.ScreenScaffold
import com.example.footballapp.ui.components.TopStandingsCard
import com.example.footballapp.ui.design.AppSpacing
import com.example.footballapp.ui.design.Strings
import com.example.footballapp.ui.model.CompetitionUiModel
import com.example.footballapp.ui.model.CountryUiModel
import com.example.footballapp.ui.model.LeagueOverviewUiModel
import com.example.footballapp.ui.model.LeagueTableGroupUiModel
import com.example.footballapp.ui.viewmodel.FavouriteViewModel

@Composable
fun LeagueOverviewScreen(

    overview: LeagueOverviewUiModel,

    currentRound: String?,

    onLeagueTableClick: () -> Unit = {},

    topStandings:
    List<LeagueTableGroupUiModel>,

    competitions: List<CompetitionUiModel> = emptyList(),

    onCompetitionSelected: (Int, Int) -> Unit = { _, _ -> },

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

    val favouriteViewModel: FavouriteViewModel = viewModel()

    var isCountryLeaguesExpanded by remember {
        mutableStateOf(false)
    }

    /*
     * We determine the current season year (Int) from the
     * formatted season string (e.g. "2024/25").
     */
    val currentSeason =
        overview.season
            .take(4)
            .toIntOrNull()
            ?: 2024

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

            CountryCard(
                countryName = "Other Leagues in ${overview.countryName}",
                flagUrl = overview.countryFlag,
                expanded = isCountryLeaguesExpanded,
                onClick = {
                    isCountryLeaguesExpanded = !isCountryLeaguesExpanded
                }
            )

            AnimatedVisibility(visible = isCountryLeaguesExpanded) {

                Column {

                    val otherCompetitions =
                        competitions.filter {
                            it.id != overview.leagueId
                        }

                    if (otherCompetitions.isEmpty()) {

                        Text(
                            text = "No other featured leagues found.",
                            modifier = Modifier.padding(AppSpacing.Medium)
                        )

                    } else {

                        otherCompetitions.forEach { competition ->

                            CompetitionRow(
                                competition = competition,

                                isFavourite = favouriteViewModel.isFavourite(
                                    competition.id,
                                    currentSeason
                                ),

                                onFavouriteClick = {

                                    if (favouriteViewModel.isFavourite(
                                            competition.id,
                                            currentSeason
                                        )
                                    ) {
                                        favouriteViewModel.clearFavourite()
                                    } else {
                                        favouriteViewModel.saveFavourite(
                                            FavouriteCompetition(
                                                leagueId = competition.id,
                                                season = currentSeason,
                                                leagueName = competition.name,
                                                countryName = overview.countryName,
                                                type = competition.type
                                            )
                                        )
                                    }
                                },

                                onClick = {
                                    onCompetitionSelected(
                                        competition.id,
                                        currentSeason
                                    )
                                }
                            )
                        }
                    }
                }
            }
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