package com.example.footballapp.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Modifier
import com.example.footballapp.ui.components.CompetitionList
import com.example.footballapp.ui.components.CountryCard
import com.example.footballapp.ui.components.ScreenScaffold
import com.example.footballapp.ui.design.AppSpacing
import com.example.footballapp.ui.model.CompetitionGroupUiModel
import com.example.footballapp.ui.model.CompetitionUiModel
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text

@Composable
fun CompetitionsScreen(

    competitionGroups: List<CompetitionGroupUiModel>,

    onCompetitionSelected: (CompetitionUiModel) -> Unit = {},

    onLeagueExplorerClick: () -> Unit = {}

) {

    var expandedCountry by rememberSaveable {

        mutableStateOf(
            competitionGroups
                .firstOrNull()
                ?.title
        )

    }

    ScreenScaffold {

        item {

            Spacer(
                modifier = Modifier.height(
                    AppSpacing.ExtraLarge
                )
            )

            /**************** TEMP LEAGUE TESTER ***********************/
            Button(
                onClick = onLeagueExplorerClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "League Explorer",
                    color = MaterialTheme.colorScheme.onSurface
                )
            }// END OF LEAGUE TESTER

            Spacer(
                modifier = Modifier.height(
                    AppSpacing.Medium
                )
            )
        }

        items(competitionGroups) { group ->

            CountryCard(

                countryName = group.title,

                competitionCount =
                    group.leagues.size
                            + group.domesticCups.size,

                expanded =
                    expandedCountry == group.title,

                onClick = {

                    expandedCountry =
                        if (
                            expandedCountry ==
                            group.title
                        ) {
                            null
                        } else {
                            group.title
                        }

                }

            )

            AnimatedVisibility(

                visible =
                    expandedCountry ==
                            group.title

            ) {

                Column {

                    if (group.leagues.isNotEmpty()) {

                        CompetitionList(

                            competitions =
                                group.leagues,

                            onCompetitionSelected =
                                onCompetitionSelected

                        )

                    }

                    if (group.domesticCups.isNotEmpty()) {

                        CompetitionList(

                            competitions =
                                group.domesticCups,

                            onCompetitionSelected =
                                onCompetitionSelected

                        )

                    }

                }

            }

        }

    }

}