package com.example.footballapp.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.example.footballapp.ui.model.FixtureTeamColorsUiModel
import com.example.footballapp.ui.model.FixtureTeamLineupUiModel
import com.example.footballapp.ui.model.PlayerLineupUiModel
import com.example.footballapp.util.ColorUtils
import kotlin.math.roundToInt


/*
 * ---------------------------------------------------------
 * PLAYER MARKER SIZE
 * ---------------------------------------------------------
 *
 * Keep this as the single source of truth for the
 * player-number circle size.
 */
private const val PLAYER_MARKER_SIZE = 30

private const val PLAYER_LABEL_SLOT_WIDTH = 72


@Composable
fun FormationPitch(
    team: FixtureTeamLineupUiModel,
    onPlayerClick: (Int) -> Unit
) {

    /*
     * -------------------------------------------------
     * STARTING PLAYERS
     * -------------------------------------------------
     *
     * Only starting players with a valid
     * API-Football grid are displayed.
     */
    val startingPlayers =
        team.players.filter {
            it.starting &&
                    it.grid != null
        }

    /*
     * -------------------------------------------------
     * PARSE PLAYER GRID
     * -------------------------------------------------
     *
     * API-Football grid:
     *
     *     "row:column"
     *
     * Example:
     *
     *     "2:1"
     *     "2:2"
     *     "2:3"
     *     "2:4"
     *
     * We keep both values because:
     *
     *     row    = vertical position
     *     column = horizontal position
     */
    val parsedPlayers =
        startingPlayers.mapNotNull { player ->

            val grid =
                parseGrid(
                    player.grid
                )
                    ?: return@mapNotNull null

            player to grid
        }

    /*
     * -------------------------------------------------
     * GROUP PLAYERS BY ROW
     * -------------------------------------------------
     *
     * Identify unique horizontal "lines" to ensure
     * even vertical distribution.
     */
    val sortedRows =
        parsedPlayers
            .map { it.second.first }
            .distinct()
            .sorted()

    val rowCount =
        sortedRows.size

    val rowsOfPlayers =
        parsedPlayers.groupBy {
            it.second.first
        }

    /*
     * MaterialTheme colours must be obtained
     * outside the Canvas DrawScope.
     */
    val lineColor =
        MaterialTheme
            .colorScheme
            .onSurfaceVariant
            .copy(alpha = 0.70f)

    val pitchColor =
        MaterialTheme
            .colorScheme
            .surfaceVariant

    /*
     * -------------------------------------------------
     * PITCH CONTAINER
     * -------------------------------------------------
     */
    BoxWithConstraints(

        modifier =
            Modifier
                .fillMaxWidth()
                .aspectRatio(0.68f)
    ) {

        /*
         * Actual rendered pitch dimensions.
         *
         * These are used for player coordinates.
         */
        val pitchWidth =
            constraints.maxWidth.toFloat()

        val pitchHeight =
            constraints.maxHeight.toFloat()


        /*
         * -------------------------------------------------
         * PITCH
         * -------------------------------------------------
         */
        Canvas(
            modifier =
                Modifier.fillMaxSize()
        ) {

            /*
             * Pitch background stripes.
             */
            val stripeCount =
                10

            val stripeHeight =
                size.height /
                        stripeCount

            for (i in 0 until stripeCount) {

                drawRect(

                    color =
                        if (i % 2 == 0) {

                            pitchColor

                        } else {

                            pitchColor.copy(
                                alpha = 0.82f
                            )
                        },

                    topLeft =
                        Offset(
                            0f,
                            i * stripeHeight
                        ),

                    size =
                        Size(
                            size.width,
                            stripeHeight
                        )
                )
            }

            /*
             * Pitch line width.
             */
            val stroke =
                2.dp.toPx()


            /*
             * -------------------------------------------------
             * PITCH BORDER
             * -------------------------------------------------
             */
            drawRoundRect(

                color =
                    lineColor,

                style =
                    Stroke(
                        width = stroke
                    ),

                cornerRadius =
                    CornerRadius(
                        20f,
                        20f
                    )
            )


            /*
             * -------------------------------------------------
             * HALF WAY LINE
             * -------------------------------------------------
             */
            drawLine(

                color =
                    lineColor,

                start =
                    Offset(
                        0f,
                        size.height / 2f
                    ),

                end =
                    Offset(
                        size.width,
                        size.height / 2f
                    ),

                strokeWidth =
                    stroke
            )


            /*
             * -------------------------------------------------
             * CENTRE CIRCLE
             * -------------------------------------------------
             */
            val centre =
                Offset(

                    size.width / 2f,

                    size.height / 2f
                )

            val centreRadius =
                size.minDimension * 0.12f

            drawCircle(

                color =
                    lineColor,

                radius =
                    centreRadius,

                center =
                    centre,

                style =
                    Stroke(
                        width = stroke
                    )
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
             * -------------------------------------------------
             * PENALTY AREAS
             * -------------------------------------------------
             */
            val penaltyWidth =
                size.width * 0.55f

            val penaltyHeight =
                size.height * 0.16f

            val penaltyLeft =
                (size.width -
                        penaltyWidth) /
                        2f


            /*
             * Top penalty area.
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
                    Stroke(
                        width = stroke
                    )
            )


            /*
             * Bottom penalty area.
             */
            drawRect(

                color =
                    lineColor,

                topLeft =
                    Offset(

                        penaltyLeft,

                        size.height -
                                penaltyHeight
                    ),

                size =
                    Size(
                        penaltyWidth,
                        penaltyHeight
                    ),

                style =
                    Stroke(
                        width = stroke
                    )
            )


            /*
             * -------------------------------------------------
             * SIX-YARD BOXES
             * -------------------------------------------------
             */
            val goalBoxWidth =
                size.width * 0.25f

            val goalBoxHeight =
                size.height * 0.055f

            val goalBoxLeft =
                (size.width -
                        goalBoxWidth) /
                        2f


            /*
             * Top six-yard box.
             */
            drawRect(

                color =
                    lineColor,

                topLeft =
                    Offset(
                        goalBoxLeft,
                        0f
                    ),

                size =
                    Size(
                        goalBoxWidth,
                        goalBoxHeight
                    ),

                style =
                    Stroke(
                        width = stroke
                    )
            )


            /*
             * Bottom six-yard box.
             */
            drawRect(

                color =
                    lineColor,

                topLeft =
                    Offset(

                        goalBoxLeft,

                        size.height -
                                goalBoxHeight
                    ),

                size =
                    Size(
                        goalBoxWidth,
                        goalBoxHeight
                    ),

                style =
                    Stroke(
                        width = stroke
                    )
            )


            /*
             * -------------------------------------------------
             * PENALTY SPOTS
             * -------------------------------------------------
             */
            val penaltySpotDistance =
                size.height * 0.105f


            /*
             * Top penalty spot.
             */
            drawCircle(

                color =
                    lineColor,

                radius =
                    stroke * 1.5f,

                center =
                    Offset(

                        size.width / 2f,

                        penaltySpotDistance
                    )
            )


            /*
             * Bottom penalty spot.
             */
            drawCircle(

                color =
                    lineColor,

                radius =
                    stroke * 1.5f,

                center =
                    Offset(

                        size.width / 2f,

                        size.height -
                                penaltySpotDistance
                    )
            )


            /*
             * -------------------------------------------------
             * PENALTY ARCS / "D"
             * -------------------------------------------------
             */
            val arcRadius =
                size.width * 0.12f


            /*
             * Top D.
             */
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
                    Offset(

                        size.width / 2f -
                                arcRadius,

                        penaltySpotDistance -
                                arcRadius
                    ),

                size =
                    Size(

                        arcRadius * 2f,

                        arcRadius * 2f
                    ),

                style =
                    Stroke(
                        width = stroke
                    )
            )


            /*
             * Bottom D.
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
                    Offset(

                        size.width / 2f -
                                arcRadius,

                        size.height -
                                penaltySpotDistance -
                                arcRadius
                    ),

                size =
                    Size(

                        arcRadius * 2f,

                        arcRadius * 2f
                    ),

                style =
                    Stroke(
                        width = stroke
                    )
            )
        }


        /*
         * -------------------------------------------------
         * PLAYERS
         * -------------------------------------------------
         *
         * Position players from the API grid.
         *
         * API rows define the vertical line. API columns define the
         * left-to-right order inside that line.
         */

        /*
         * Vertical bounds (Penalty Spot to Penalty Spot).
         */
        val bottomY = pitchHeight * 0.895f
        val topY = pitchHeight * 0.105f
        val availableHeight = bottomY - topY

        sortedRows.forEachIndexed { lineIndex, apiRow ->

            val playersInLine =
                rowsOfPlayers[apiRow]
                    ?.sortedBy { it.second.second }
                    ?: return@forEachIndexed

            val playerCount =
                playersInLine.size

            /*
             * Scale Y based on the ordinal line index.
             */
            val yProgress =
                if (rowCount <= 1) 0.5f
                else lineIndex.toFloat() / (rowCount - 1).toFloat()

            // Invert so line 0 (GK) is at bottom
            val y = bottomY - (yProgress * availableHeight)

            playersInLine.forEachIndexed { index, (player, _) ->

                val x =
                    xForPlayerInLine(
                        pitchWidth = pitchWidth,
                        index = index,
                        playerCount = playerCount
                    )

                PitchPlayerMarker(
                    player = player,
                    x = x,
                    y = y,
                    colors = team.colors,
                    onClick = {
                        onPlayerClick(
                            player.playerId
                        )
                    }
                )
            }
        }
    }
}


/*
 * ---------------------------------------------------------
 * HORIZONTAL LINE POSITIONING
 * ---------------------------------------------------------
 *
 * The API column is used for ordering before this function is called.
 * The rendered row is then centered on the pitch.
 */
private fun xForPlayerInLine(
    pitchWidth: Float,
    index: Int,
    playerCount: Int
): Float {

    val xFraction =
        when (playerCount) {
            1 -> listOf(0.50f)
            2 -> listOf(0.35f, 0.65f)
            3 -> listOf(0.25f, 0.50f, 0.75f)
            4 -> listOf(0.15f, 0.38f, 0.62f, 0.85f)
            5 -> listOf(0.10f, 0.30f, 0.50f, 0.70f, 0.90f)
            else -> {
                val safeCount =
                    playerCount.coerceAtLeast(1)

                val horizontalPadding =
                    0.10f

                val availableWidth =
                    1f - (horizontalPadding * 2f)

                List(safeCount) { i ->
                    if (safeCount == 1) {
                        0.50f
                    } else {
                        horizontalPadding + ((i.toFloat() / (safeCount - 1)) * availableWidth)
                    }
                }
            }
        }
            .getOrElse(index) {
                0.50f
            }

    return pitchWidth * xFraction
}


/*
 * ---------------------------------------------------------
 * PLAYER MARKER
 * ---------------------------------------------------------
 */
@Composable
private fun PitchPlayerMarker(

    player: PlayerLineupUiModel,

    x: Float,

    y: Float,

    colors: FixtureTeamColorsUiModel?,

    onClick: () -> Unit

) {

    // ... (colours logic remains same)
    val playerColors = if (player.position == "G") colors?.goalkeeper ?: colors?.player else colors?.player
    val markerColor = ColorUtils.parseHexColor(playerColors?.primary) ?: MaterialTheme.colorScheme.primary
    val numberColor = ColorUtils.parseHexColor(playerColors?.number) ?: MaterialTheme.colorScheme.onPrimary
    val borderColor = ColorUtils.parseHexColor(playerColors?.border) ?: markerColor

    /*
     * To ensure perfect centering regardless of name length,
     * we position the center of the marker at (x, y).
     */
    Box(
        modifier = Modifier
            .offset {

                val halfSlotWidth =
                    (PLAYER_LABEL_SLOT_WIDTH.dp.toPx() / 2f).roundToInt()

                val halfMarkerHeight =
                    (PLAYER_MARKER_SIZE.dp.toPx() / 2f).roundToInt()

                IntOffset(
                    x = x.roundToInt() - halfSlotWidth,
                    y = y.roundToInt() - halfMarkerHeight
                )
            }
            .width(PLAYER_LABEL_SLOT_WIDTH.dp),
        contentAlignment = Alignment.TopCenter
    ) {

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {

            /*
             * Shirt-number circle.
             */
            Surface(
                onClick = onClick,
                modifier = Modifier.size(PLAYER_MARKER_SIZE.dp),
                shape = CircleShape,
                color = markerColor,
                border = BorderStroke(width = 2.dp, color = borderColor),
                shadowElevation = 4.dp
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = player.shirtNumber?.toString() ?: "-",
                        color = numberColor,
                        style = MaterialTheme.typography.labelLarge
                    )
                }
            }

            /*
             * Player name.
             *
             * Positioned directly below the circle.
             */
            Text(
                text = player.playerName.substringAfterLast(" "),
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.labelSmall,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center
            )
        }
    }
}


/*
 * ---------------------------------------------------------
 * GRID PARSER
 * ---------------------------------------------------------
 *
 * Converts:
 *
 *     "2:4"
 *
 * into:
 *
 *     Pair(2, 4)
 *
 * where:
 *
 *     first  = row
 *     second = column
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
 * ---------------------------------------------------------
 * HEX COLOUR PARSER
 * ---------------------------------------------------------
 *
 * API-Football returns colours such as:
 */
