package com.example.footballapp.ui.screens.squad

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import com.example.footballapp.ui.model.PlayerUiModel
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.footballapp.ui.components.AppHeader
import com.example.footballapp.ui.components.CardHeader
import com.example.footballapp.ui.components.ScreenScaffold
import com.example.footballapp.ui.components.PlayerList
import com.example.footballapp.ui.components.SectionCard
import com.example.footballapp.ui.design.AppSpacing
import com.example.footballapp.ui.design.Strings
import com.example.footballapp.ui.theme.HeaderBlue

@Composable
fun SquadScreen(

    clubName: String,

    season: String,

    players: List<PlayerUiModel>,

    onPlayerClick: (Int) -> Unit

) {

    ScreenScaffold {

        item {

            AppHeader(

                backgroundColor = HeaderBlue

            )

        }

        item {

            Spacer(
                modifier = Modifier.height(AppSpacing.ExtraLarge)
            )

        }

        item {

            CardHeader(

                title = clubName + Strings.Football_Club,

                subtitle = Strings.SQUAD

            )

        }

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