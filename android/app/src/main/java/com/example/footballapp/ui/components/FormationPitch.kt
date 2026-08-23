package com.example.footballapp.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.example.footballapp.ui.model.FixtureTeamLineupUiModel
import com.example.footballapp.ui.model.PlayerLineupUiModel
import kotlin.math.roundToInt


@Composable
fun FormationPitch(

    team: FixtureTeamLineupUiModel,

    onPlayerClick: (Int) -> Unit

) {

    val startingPlayers =
        team.players.filter {

            it.starting &&
                    it.grid != null

        }

    /*
     * Theme colours are obtained outside
     * the Canvas drawing scope.
     */

    val pitchColor =
        MaterialTheme
            .colorScheme
            .surfaceVariant

    val lineColor =
        MaterialTheme
            .colorScheme
            .onSurfaceVariant
            .copy(alpha = 0.65f)

    val playerColor =
        MaterialTheme
            .colorScheme
            .primary

    val playerTextColor =
        MaterialTheme
            .colorScheme
            .onPrimary

    BoxWithConstraints(

        modifier =
            Modifier
                .fillMaxWidth()
                .aspectRatio(0.68f)

    ) {

        val pitchWidth =
            constraints.maxWidth.toFloat()

        val pitchHeight =
            constraints.maxHeight.toFloat()

        /*
         * Pitch.
         */

        Canvas(

            modifier =
                Modifier.fillMaxSize()

        ) {

            val stroke =
                2.dp.toPx()

            val width =
                size.width

            val height =
                size.height

            /*
             * Pitch background.
             */

            drawRoundRect(

                color =
                    pitchColor,

                cornerRadius =
                    CornerRadius(
                        20f,
                        20f
                    )

            )

            /*
             * Outer boundary.
             */

            drawRoundRect(

                color =
                    lineColor,

                style =
                    Stroke(stroke),

                cornerRadius =
                    CornerRadius(
                        20f,
                        20f
                    )

            )

            /*
             * Halfway line.
             */

            drawLine(

                color =
                    lineColor,

                start =
                    Offset(
                        0f,
                        height / 2f
                    ),

                end =
                    Offset(
                        width,
                        height / 2f
                    ),

                strokeWidth =
                    stroke

            )

            /*
             * Centre circle.
             */

            val centre =
                Offset(
                    width / 2f,
                    height / 2f
                )

            val centreCircleRadius =
                width * 0.12f

            drawCircle(

                color =
                    lineColor,

                radius =
                    centreCircleRadius,

                center =
                    centre,

                style =
                    Stroke(stroke)

            )

            /*
             * Centre spot.
             */

            drawCircle(

                color =
                    lineColor,

                radius =
                    stroke * 1.5f,

                center =
                    centre

            )

            /*
             * Penalty area dimensions.
             */

            val penaltyWidth =
                width * 0.55f

            val penaltyHeight =
                height * 0.16f

            val penaltyLeft =
                (width - penaltyWidth) / 2f

            /*
             * Goal / 6-yard box dimensions.
             */

            val goalAreaWidth =
                width * 0.24f

            val goalAreaHeight =
                height * 0.065f

            val goalAreaLeft =
                (width - goalAreaWidth) / 2f

            /*
             * Penalty spot position.
             */

            val penaltySpotDistance =
                height * 0.105f

            /*
             * -------------------------------------------------
             * TOP HALF
             * -------------------------------------------------
             */

            /*
             * 18-yard penalty area.
             */

            drawRect(

                color =
                    lineColor,

                topLeft =
                    Offset(
                        penaltyLeft,
                        0f
                    ),

                size =
                    Size(
                        penaltyWidth,
                        penaltyHeight
                    ),

                style =
                    Stroke(stroke)

            )

            /*
             * 6-yard / goal area.
             */

            drawRect(

                color =
                    lineColor,

                topLeft =
                    Offset(
                        goalAreaLeft,
                        0f
                    ),

                size =
                    Size(
                        goalAreaWidth,
                        goalAreaHeight
                    ),

                style =
                    Stroke(stroke)

            )

            /*
             * Top penalty spot.
             */

            val topPenaltySpot =
                Offset(
                    width / 2f,
                    penaltySpotDistance
                )

            drawCircle(

                color =
                    lineColor,

                radius =
                    stroke * 1.5f,

                center =
                    topPenaltySpot

            )

            /*
             * Top penalty "D".
             *
             * The arc is drawn outside the
             * penalty area.
             */

            val penaltyArcRadius =
                width * 0.16f

            drawArc(

                color =
                    lineColor,

                startAngle =
                    25f,

                sweepAngle =
                    130f,

                useCenter =
                    false,

                topLeft =
                    Rect(

                        center =
                            Offset(
                                width / 2f,
                                penaltySpotDistance
                            ),

                        radius =
                            penaltyArcRadius

                    ).topLeft,

                size =
                    Size(
                        penaltyArcRadius * 2f,
                        penaltyArcRadius * 2f
                    ),

                style =
                    Stroke(stroke)

            )

            /*
             * -------------------------------------------------
             * BOTTOM HALF
             * -------------------------------------------------
             */

            /*
             * 18-yard penalty area.
             */

            drawRect(

                color =
                    lineColor,

                topLeft =
                    Offset(
                        penaltyLeft,
                        height -
                                penaltyHeight
                    ),

                size =
                    Size(
                        penaltyWidth,
                        penaltyHeight
                    ),

                style =
                    Stroke(stroke)

            )

            /*
             * 6-yard / goal area.
             */

            drawRect(

                color =
                    lineColor,

                topLeft =
                    Offset(
                        goalAreaLeft,
                        height -
                                goalAreaHeight
                    ),

                size =
                    Size(
                        goalAreaWidth,
                        goalAreaHeight
                    ),

                style =
                    Stroke(stroke)

            )

            /*
             * Bottom penalty spot.
             */

            val bottomPenaltySpot =
                Offset(

                    width / 2f,

                    height -
                            penaltySpotDistance

                )

            drawCircle(

                color =
                    lineColor,

                radius =
                    stroke * 1.5f,

                center =
                    bottomPenaltySpot

            )

            /*
             * Bottom penalty "D".
             */

            drawArc(

                color =
                    lineColor,

                startAngle =
                    205f,

                sweepAngle =
                    130f,

                useCenter =
                    false,

                topLeft =
                    Rect(

                        center =
                            bottomPenaltySpot,

                        radius =
                            penaltyArcRadius

                    ).topLeft,

                size =
                    Size(
                        penaltyArcRadius * 2f,
                        penaltyArcRadius * 2f
                    ),

                style =
                    Stroke(stroke)

            )

        }

        /*
         * Players.
         */

        startingPlayers.forEach { player ->

            val grid =
                parseGrid(
                    player.grid
                )
                    ?: return@forEach

            val position =
                calculatePlayerPosition(

                    row =
                        grid.first,

                    column =
                        grid.second,

                    width =
                        pitchWidth,

                    height =
                        pitchHeight

                )

            PitchPlayerMarker(

                player =
                    player,

                x =
                    position.first,

                y =
                    position.second,

                markerColor =
                    playerColor,

                textColor =
                    playerTextColor,

                onClick = {

                    onPlayerClick(
                        player.playerId
                    )

                }

            )

        }

    }

}


/*
 * Circular player marker.
 *
 * The marker is positioned by its centre
 * rather than its top-left corner.
 */

@Composable
private fun PitchPlayerMarker(

    player: PlayerLineupUiModel,

    x: Float,

    y: Float,

    markerColor: androidx.compose.ui.graphics.Color,

    textColor: androidx.compose.ui.graphics.Color,

    onClick: () -> Unit

) {

    val markerSize =
        38.dp

    Box(

        modifier =
            Modifier
                .offset {

                    IntOffset(

                        x =
                            x.roundToInt() -
                                    (markerSize.toPx() / 2f)
                                        .roundToInt(),

                        y =
                            y.roundToInt() -
                                    (markerSize.toPx() / 2f)
                                        .roundToInt()

                    )

                }

    ) {

        Surface(

            modifier =
                Modifier
                    .clickable(
                        onClick = onClick
                    ),

            shape =
                CircleShape,

            color =
                markerColor,

            shadowElevation =
                4.dp

        ) {

            Box(

                modifier =
                    Modifier
                        .then(
                            Modifier
                        ),

                contentAlignment =
                    Alignment.Center

            ) {

                Text(

                    text =
                        player.shirtNumber
                            ?.toString()
                            ?: "-",

                    color =
                        textColor,

                    style =
                        MaterialTheme
                            .typography
                            .labelLarge

                )

            }

        }

    }

}


/*
 * Convert API-Football grid values such as:
 *
 *     "1:1"
 *     "2:4"
 *     "3:2"
 *
 * into row / column coordinates.
 */

private fun parseGrid(

    grid: String?

): Pair<Int, Int>? {

    if (grid.isNullOrBlank()) {
        return null
    }

    val parts =
        grid.split(":")

    if (parts.size != 2) {
        return null
    }

    val row =
        parts[0]
            .toIntOrNull()
            ?: return null

    val column =
        parts[1]
            .toIntOrNull()
            ?: return null

    return row to column

}


/*
 * Convert formation grid coordinates
 * into screen coordinates.
 *
 * API-Football:
 *
 * Row 1 = Goalkeeper
 * Row 5 = Forward
 *
 * Our pitch is displayed with the
 * goalkeeper at the bottom.
 */

private fun calculatePlayerPosition(

    row: Int,

    column: Int,

    width: Float,

    height: Float

): Pair<Float, Float> {

    val yFraction =
        when (row) {

            1 -> 0.84f

            2 -> 0.67f

            3 -> 0.50f

            4 -> 0.32f

            5 -> 0.16f

            else -> 0.50f

        }

    val xFraction =
        when (column) {

            1 -> 0.12f

            2 -> 0.37f

            3 -> 0.63f

            4 -> 0.88f

            else -> 0.50f

        }

    return Pair(

        width * xFraction,

        height * yFraction

    )

}