package com.example.footballapp.ui.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.footballapp.ui.components.AppHeader
import com.example.footballapp.ui.components.CompetitionList
import com.example.footballapp.ui.components.ScreenScaffold
import com.example.footballapp.ui.design.AppSpacing
import com.example.footballapp.ui.model.CompetitionGroupUiModel
import com.example.footballapp.ui.model.CompetitionUiModel
import com.example.footballapp.ui.theme.HeaderBlue
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.example.footballapp.ui.components.CountryCard

@Composable
fun CompetitionsScreen(

    competitionGroups: List<CompetitionGroupUiModel>,

    onCompetitionSelected: (CompetitionUiModel) -> Unit = {}

) {

    var expandedCountry by rememberSaveable {
        mutableStateOf<String?>(competitionGroups.firstOrNull()?.title)
    }

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

        items(competitionGroups) { group ->


            CountryCard(
                countryName = group.title,
                competitionCount = group.leagues.size + group.domesticCups.size,
                expanded = expandedCountry == group.title,
                onClick = {
                    expandedCountry =
                        if (expandedCountry == group.title)
                            null
                        else
                            group.title
                }
            )

            AnimatedVisibility(

                visible = expandedCountry == group.title

            ) {

                androidx.compose.foundation.layout.Column {

                    if (group.leagues.isNotEmpty()) {

                        CompetitionList(

                            competitions = group.leagues,

                            onCompetitionSelected = onCompetitionSelected

                        )

                    }

                    if (group.domesticCups.isNotEmpty()) {

                        CompetitionList(

                            competitions = group.domesticCups,

                            onCompetitionSelected = onCompetitionSelected

                        )

                    }

                }

            }

        }

    }

}