package com.example.footballapp.ui.screens.squad

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.footballapp.ui.components.CardHeader
import com.example.footballapp.ui.components.ClubHeaderCard
import com.example.footballapp.ui.components.PlayerList
import com.example.footballapp.ui.components.ScreenScaffold
import com.example.footballapp.ui.design.AppSpacing
import com.example.footballapp.ui.design.Strings
import com.example.footballapp.ui.model.ClubDetailsUiModel
import com.example.footballapp.ui.model.CountryUiModel
import com.example.footballapp.ui.model.PlayerUiModel

@Composable
fun SquadScreen(

    club: ClubDetailsUiModel?,

    season: String,

    players: List<PlayerUiModel>,

    onPlayerClick: (Int) -> Unit,

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

        if (club != null) {
            item {
                ClubHeaderCard(
                    club = club,
                    showDetails = false
                )
            }
            
            item {
                CardHeader(
                    title = "Squad",
                    subtitle = season
                )
            }
        }

        if (players.isEmpty()) {

            item {

                CardHeader(

                    title =
                        "Squad information is not currently available for this competition."

                )

            }

        } else {

            PlayerList(

                players = players,

                onPlayerClick = { player ->

                    onPlayerClick(

                        player.playerId

                    )

                }

            )

        }
    }

}