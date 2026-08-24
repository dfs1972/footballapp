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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.example.footballapp.ui.model.FixtureTeamColorsUiModel
import com.example.footballapp.ui.model.FixtureTeamLineupUiModel
import com.example.footballapp.ui.model.PlayerLineupUiModel
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
     */
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
         * Position players using a strict 5x5 tactical grid.
         *
         * This divides the pitch into 25 equal cells. Players
         * are assigned to the center of these cells to ensure
         * perfect spacing and prevent sideline overlap.
         */
        rowsOfPlayers.forEach { (apiRow, playersInRow) ->

            val sortedPlayers =
                playersInRow.sortedBy {
                    it.second.second
                }

            val playerCount =
                sortedPlayers.size

            /*
             * Map the number of players in this line to specific
             * horizontal cells (1-5) to maintain tactical symmetry.
             */
            val horizontalCells = when (playerCount) {
                1 -> listOf(3)           // Center cell
                2 -> listOf(2, 4)        // Adjacent to center (Inside channels)
                3 -> listOf(2, 3, 4)     // Adjoining cells centered
                4 -> listOf(1, 2, 4, 5)  // Wingers and inside channels
                5 -> listOf(1, 2, 3, 4, 5) // Full width
                else -> List(playerCount) { i -> (i * 4 / (playerCount - 1)) + 1 }
            }

            sortedPlayers.forEachIndexed { index, (player, _) ->

                val cellX = horizontalCells.getOrElse(index) { 3 }

                /*
                 * 5 Equal Horizontal Columns.
                 *
                 * Centers: 0.1, 0.3, 0.5, 0.7, 0.9
                 *
                 * We pull the wings (1 & 5) in slightly (to 0.12 and 0.88)
                 * to ensure markers don't clip the pitch border.
                 */
                val xFraction = when (cellX) {
                    1 -> 0.12f
                    2 -> 0.31f
                    3 -> 0.50f
                    4 -> 0.69f
                    5 -> 0.88f
                    else -> 0.50f
                }

                /*
                 * 5 Equal Vertical Rows.
                 *
                 * Mapped from API row IDs 1-5.
                 * GK is always at the bottom.
                 */
                val yFraction = when (apiRow) {
                    1 -> 0.90f // Goalkeeper
                    2 -> 0.72f // Defense
                    3 -> 0.54f // Midfield
                    4 -> 0.36f // Attacking Midfield
                    5 -> 0.18f // Forwards
                    else -> 0.50f
                }

                val x = pitchWidth * xFraction
                val y = pitchHeight * yFraction

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

    /*
     * Goalkeepers use goalkeeper colours.
     *
     * If goalkeeper colours aren't available,
     * fall back to normal player colours.
     */
    val playerColors =
        if (player.position == "G") {

            colors?.goalkeeper
                ?: colors?.player

        } else {

            colors?.player
        }


    /*
     * Marker background.
     */
    val markerColor =
        parseHexColor(
            playerColors?.primary
        )
            ?: MaterialTheme
                .colorScheme
                .primary


    /*
     * Shirt number colour.
     */
    val numberColor =
        parseHexColor(
            playerColors?.number
        )
            ?: MaterialTheme
                .colorScheme
                .onPrimary


    /*
     * Marker border.
     */
    val borderColor =
        parseHexColor(
            playerColors?.border
        )
            ?: markerColor


    Column(

        modifier =
            Modifier
                .offset {

                    /*
                     * The coordinate represents the
                     * CENTRE of the marker.
                     *
                     * Marker size is 30dp, therefore:
                     *
                     *     30 / 2 = 15dp
                     *
                     * We deliberately calculate this
                     * from PLAYER_MARKER_SIZE rather
                     * than hard-coding 15dp.
                     */
                    val markerHalfSize =
                        PLAYER_MARKER_SIZE
                            .dp
                            .toPx() /
                                2f

                    IntOffset(

                        x =
                            (
                                    x -
                                            markerHalfSize
                                    )
                                .roundToInt(),

                        y =
                            (
                                    y -
                                            markerHalfSize
                                    )
                                .roundToInt()
                    )
                },

        horizontalAlignment =
            Alignment.CenterHorizontally,

        verticalArrangement =
            Arrangement.spacedBy(
                2.dp
            )
    ) {

        /*
         * Shirt-number circle.
         */
        Surface(

            onClick =
                onClick,

            modifier =
                Modifier.size(
                    PLAYER_MARKER_SIZE.dp
                ),

            shape =
                CircleShape,

            color =
                markerColor,

            border =
                BorderStroke(

                    width =
                        2.dp,

                    color =
                        borderColor
                ),

            shadowElevation =
                4.dp

        ) {

            Box(

                modifier =
                    Modifier.fillMaxSize(),

                contentAlignment =
                    Alignment.Center

            ) {

                Text(

                    text =
                        player.shirtNumber
                            ?.toString()
                            ?: "-",

                    color =
                        numberColor,

                    style =
                        MaterialTheme
                            .typography
                            .labelLarge
                )
            }
        }


        /*
         * Player name.
         *
         * Show only the last name to prevent overlapping.
         */
        Text(

            text =
                player.playerName.substringAfterLast(" "),

            color =
                MaterialTheme
                    .colorScheme
                    .onSurface,

            style =
                MaterialTheme
                    .typography
                    .labelSmall,

            maxLines =
                1
        )
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
 *
 *     ffbb00
 *     ff0000
 *     ffffff
 *
 * Android/Compose requires:
 *
 *     #ffbb00
 */
private fun parseHexColor(
    value: String?
): Color? {

    if (value.isNullOrBlank()) {
        return null
    }

    return try {

        val hex =
            value
                .trim()
                .removePrefix("#")

        if (hex.length != 6) {
            return null
        }

        Color(
            android.graphics.Color.parseColor(
                "#$hex"
            )
        )

    } catch (
        _: IllegalArgumentException
    ) {

        null
    }
}