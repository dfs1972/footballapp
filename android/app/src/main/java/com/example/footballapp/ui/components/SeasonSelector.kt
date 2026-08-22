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
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import com.example.footballapp.ui.design.AppSpacing
import com.example.footballapp.ui.theme.AppElevation

private const val FIRST_AVAILABLE_SEASON = 2010

@Composable
fun SeasonSelector(

    selectedSeason: Int,

    currentSeason: Int,

    expanded: Boolean,

    onClick: () -> Unit,

    onSeasonSelected: (Int) -> Unit,

    modifier: Modifier = Modifier

) {

    var searchMode by remember {

        mutableStateOf(false)

    }

    var searchText by remember {

        mutableStateOf("")

    }

    val rotation by animateFloatAsState(

        targetValue =
            if (expanded) 180f else 0f,

        label = "SeasonSelectorRotation"

    )

    Card(

        modifier = modifier
            .fillMaxWidth()
            .clickable {

                onClick()

                if (expanded) {

                    searchMode = false
                    searchText = ""

                }

            },

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
             * Season selection area
             */

            AnimatedVisibility(

                visible = expanded

            ) {

                Column {

                    if (searchMode) {

                        /*
                         * Historic season search
                         */

                        OutlinedTextField(

                            value = searchText,

                            onValueChange = { value ->

                                /*
                                 * Only allow digits and
                                 * limit input to four
                                 * characters.
                                 */

                                searchText =
                                    value
                                        .filter {
                                            it.isDigit()
                                        }
                                        .take(4)

                            },

                            modifier =
                                Modifier
                                    .fillMaxWidth()
                                    .padding(
                                        horizontal =
                                            AppSpacing.Medium
                                    ),

                            label = {

                                Text(
                                    text =
                                        "Historic season"
                                )

                            },

                            placeholder = {

                                Text(
                                    text =
                                        "e.g. 2018"
                                )

                            },

                            leadingIcon = {

                                Icon(

                                    imageVector =
                                        Icons.Default.Search,

                                    contentDescription =
                                        "Search historic season"

                                )

                            },

                            singleLine = true,

                            supportingText = {

                                Text(

                                    text =
                                        "Enter a season from " +
                                                "$FIRST_AVAILABLE_SEASON " +
                                                "to $currentSeason"

                                )

                            }

                        )

                        Spacer(

                            modifier =
                                Modifier.height(
                                    AppSpacing.Small
                                )

                        )

                        val searchedSeason =
                            searchText.toIntOrNull()

                        val isValidSeason =
                            searchedSeason != null &&
                                    searchedSeason in
                                    FIRST_AVAILABLE_SEASON..currentSeason

                        Row(

                            modifier =
                                Modifier
                                    .fillMaxWidth()
                                    .clickable(
                                        enabled =
                                            isValidSeason
                                    ) {

                                        onSeasonSelected(
                                            searchedSeason!!
                                        )

                                        searchMode = false
                                        searchText = ""

                                    }
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
                                    if (isValidSeason) {

                                        "Use season $searchedSeason"

                                    } else {

                                        "Enter a valid season"

                                    },

                                style =
                                    MaterialTheme
                                        .typography
                                        .bodyLarge,

                                color =
                                    if (isValidSeason) {

                                        MaterialTheme
                                            .colorScheme
                                            .primary

                                    } else {

                                        MaterialTheme
                                            .colorScheme
                                            .onSurfaceVariant

                                    }

                            )

                        }

                    } else {

                        /*
                         * Recent seasons
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

                        /*
                         * Historic season search
                         */

                        Row(

                            modifier =
                                Modifier
                                    .fillMaxWidth()
                                    .clickable {

                                        searchMode = true

                                    }
                                    .padding(
                                        horizontal =
                                            AppSpacing.Medium,

                                        vertical =
                                            AppSpacing.Small
                                    ),

                            verticalAlignment =
                                Alignment.CenterVertically

                        ) {

                            Icon(

                                imageVector =
                                    Icons.Default.Search,

                                contentDescription =
                                    "Search historic season",

                                tint =
                                    MaterialTheme
                                        .colorScheme
                                        .primary

                            )

                            Spacer(

                                modifier =
                                    Modifier.height(
                                        AppSpacing.Small
                                    )

                            )

                            Text(

                                text =
                                    "Search historic season",

                                style =
                                    MaterialTheme
                                        .typography
                                        .bodyLarge,

                                color =
                                    MaterialTheme
                                        .colorScheme
                                        .primary

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