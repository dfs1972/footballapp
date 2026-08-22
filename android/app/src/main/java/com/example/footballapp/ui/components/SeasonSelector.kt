package com.example.footballapp.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import com.example.footballapp.ui.design.AppSpacing
import com.example.footballapp.ui.theme.AppElevation

@Composable
fun SeasonSelector(

    selectedSeason: Int,

    currentSeason: Int,

    expanded: Boolean,

    onClick: () -> Unit,

    onSeasonSelected: (Int) -> Unit,

    modifier: Modifier = Modifier

) {

    val rotation by animateFloatAsState(

        targetValue =
            if (expanded) 180f else 0f,

        label = "SeasonSelectorRotation"

    )

    Card(

        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),

        elevation =
            CardDefaults.cardElevation(
                defaultElevation =
                    AppElevation.Card
            )

    ) {

        Column {

            /*
             * Selector header
             */

            Row(

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        AppSpacing.Medium
                    ),

                verticalAlignment =
                    Alignment.CenterVertically

            ) {

                Column(
                    modifier =
                        Modifier.weight(1f)
                ) {

                    Text(

                        text = "Season",

                        style =
                            MaterialTheme
                                .typography
                                .labelMedium,

                        color =
                            MaterialTheme
                                .colorScheme
                                .onSurfaceVariant

                    )

                    Text(

                        text =
                            if (
                                selectedSeason ==
                                currentSeason
                            ) {
                                "$selectedSeason · Current"
                            } else {
                                selectedSeason.toString()
                            },

                        style =
                            MaterialTheme
                                .typography
                                .titleMedium,

                        color =
                            MaterialTheme
                                .colorScheme
                                .onSurface

                    )

                }

                Icon(

                    imageVector =
                        Icons.Default.ExpandMore,

                    contentDescription =
                        if (expanded) {
                            "Collapse season selector"
                        } else {
                            "Select season"
                        },

                    modifier =
                        Modifier.rotate(rotation),

                    tint =
                        MaterialTheme
                            .colorScheme
                            .primary

                )
            }

            /*
             * Season list
             */

            AnimatedVisibility(
                visible = expanded
            ) {

                Column {

                    /*
                     * Show current season first,
                     * followed by five previous
                     * seasons.
                     */

                    for (
                    year in
                    currentSeason downTo
                            (currentSeason - 5)
                    ) {

                        SeasonOption(

                            year = year,

                            currentSeason =
                                currentSeason,

                            selectedSeason =
                                selectedSeason,

                            onClick = {

                                onSeasonSelected(
                                    year
                                )

                            }

                        )
                    }

                    Spacer(
                        modifier =
                            Modifier.height(
                                AppSpacing.Small
                            )
                    )

                }
            }
        }
    }

}

/******************* HELPER ***************************/

@Composable
private fun SeasonOption(

    year: Int,

    currentSeason: Int,

    selectedSeason: Int,

    onClick: () -> Unit

) {

    Row(

        modifier = Modifier
            .fillMaxWidth()
            .clickable(
                onClick = onClick
            )
            .padding(
                horizontal =
                    AppSpacing.Medium,

                vertical =
                    AppSpacing.Small
            ),

        verticalAlignment =
            Alignment.CenterVertically

    ) {

        Text(

            text =
                if (year == currentSeason) {
                    "$year · Current"
                } else {
                    year.toString()
                },

            style =
                MaterialTheme
                    .typography
                    .bodyLarge,

            color =
                if (year == selectedSeason) {
                    MaterialTheme
                        .colorScheme
                        .primary
                } else {
                    MaterialTheme
                        .colorScheme
                        .onSurface
                }

        )
    }
}
