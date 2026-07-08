package com.example.footballapp.ui.screens.squad

import com.example.footballapp.ui.model.PlayerUiModel
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.footballapp.ui.components.ScreenScaffold
import com.example.footballapp.ui.components.playerList
import com.example.footballapp.ui.previews.PreviewData

@Composable
fun SquadScreen(

    clubName: String,

    season: String,

    players: List<PlayerUiModel>,

    onPlayerClick: (Int) -> Unit

) {

    ScreenScaffold(

        title = clubName,

        subtitle = season

    ) {

        playerList(

            players = players,

            onPlayerClick = { player ->

                onPlayerClick(

                    player.playerId

                )

            }

        )

    }

}

@Preview(showBackground = true)
@Composable
private fun SquadScreenPreview() {

    MaterialTheme {

        SquadScreen(

            clubName = "Rangers",

            season = "2025/26",

            players = PreviewData.RangersSquad,

            onPlayerClick = {}

        )

    }

}