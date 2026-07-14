package com.example.footballapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyListScope
//import androidx.compose.foundation.lazy.item
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.footballapp.ui.model.PlayerUiModel
import com.example.footballapp.ui.previews.PreviewData
import com.example.footballapp.ui.design.AppSpacing

private val PositionOrder = listOf(
    "Goalkeeper",
    "Defender",
    "Midfielder",
    "Attacker"
)

private fun positionHeading(position: String): String =
    when (position) {
        "Goalkeeper" -> "Goalkeepers"
        "Defender" -> "Defenders"
        "Midfielder" -> "Midfielders"
        "Attacker" -> "Attackers"
        else -> position
    }

fun LazyListScope.playerList(

    players: List<PlayerUiModel>,

    onPlayerClick: (PlayerUiModel) -> Unit

) {

    val groupedPlayers = players.groupBy { it.position }

    PositionOrder.forEach { position ->

        val squad = groupedPlayers[position]

        if (!squad.isNullOrEmpty()) {

            item {

                Column(

                    verticalArrangement = Arrangement.spacedBy(
                        AppSpacing.Small
                    )

                ) {

                    SectionHeading(
                        text = positionHeading(position)
                    )

                    SectionCard {

                        Column(

                            verticalArrangement = Arrangement.spacedBy(
                                AppSpacing.Small
                            )

                        ) {

                            squad.forEach { player ->

                                PlayerRow(
                                    player = player,
                                    onClick = onPlayerClick
                                )

                            }

                        }

                    }

                }

            }

        }

    }

}

@Preview(showBackground = true)
@Composable
private fun PlayerListPreview() {

    ScreenScaffold(

        title = "Rangers",

        subtitle = "Squad"

    ) {

        playerList(

            players = PreviewData.RangersSquad,

            onPlayerClick = {}

        )

    }

}