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
import com.example.footballapp.ui.components.ClubHeaderCard
import com.example.footballapp.ui.components.NavigationCard
import com.example.footballapp.ui.components.ScreenScaffold
import com.example.footballapp.ui.design.AppSpacing
import com.example.footballapp.ui.model.ClubDetailsUiModel
import com.example.footballapp.ui.model.CountryUiModel

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

            ClubHeaderCard(
                club = club,
                leagueName = leagueName
            )

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