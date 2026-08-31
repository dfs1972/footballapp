package com.example.footballapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyListScope
import com.example.footballapp.ui.model.PlayerUiModel
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

fun LazyListScope.PlayerList(

    players: List<PlayerUiModel>,

    onPlayerClick: (PlayerUiModel) -> Unit

) {

    val groupedPlayers =
        players.groupBy { player ->

            when (player.position) {

                "Forward" ->
                    "Attacker"

                null ->
                    "Unknown"

                else ->
                    player.position
            }
        }

    val displayPositions = PositionOrder.toMutableList()
    
    // Add any positions found in the data that aren't in the standard order
    groupedPlayers.keys.forEach { pos ->
        if (pos != null && !displayPositions.contains(pos)) {
            displayPositions.add(pos)
        }
    }

    displayPositions.forEach { position ->

        val squad =
            groupedPlayers[position]

        if (!squad.isNullOrEmpty()) {

            item {

                SectionCard {

                    Column(

                        verticalArrangement =
                            Arrangement.spacedBy(
                                AppSpacing.Small
                            )

                    ) {

                        SectionHeading(

                            text =
                                positionHeading(
                                    position
                                ),

                            centered = true

                        )

                        squad.forEach { player ->

                            PlayerRow(

                                player = player,

                                onClick =
                                    onPlayerClick

                            )

                        }

                    }

                }

            }

        }

    }

}