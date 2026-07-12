package com.example.footballapp.ui.screens

import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.footballapp.ui.components.CompetitionList
import com.example.footballapp.ui.components.ScreenScaffold
import com.example.footballapp.ui.components.SectionCard
import com.example.footballapp.ui.components.SectionHeading
import com.example.footballapp.ui.design.Strings
import com.example.footballapp.ui.model.CompetitionGroupUiModel
import com.example.footballapp.ui.model.CompetitionUiModel

@Composable
fun CompetitionsScreen(

    competitionGroups: List<CompetitionGroupUiModel>,

    onCompetitionSelected: (CompetitionUiModel) -> Unit = {}

) {

    ScreenScaffold(

        title = Strings.COMPETITIONS,

        subtitle = Strings.CHOOSE_COMPETITION

    ) {

        items(competitionGroups) { group ->

            SectionCard {

                Text(

                    text = "${group.headerIcon} ${group.title}",

                    style = MaterialTheme.typography.titleLarge

                )

                if (group.leagues.isNotEmpty()) {

                    SectionHeading(

                        text = Strings.LEAGUES

                    )

                    CompetitionList(

                        competitions = group.leagues,

                        onCompetitionSelected = { competition ->

                            onCompetitionSelected(
                                competition
                            )

                        }

                    )

                }

                if (group.domesticCups.isNotEmpty()) {

                    SectionHeading(

                        text = Strings.DOMESTIC_CUPS

                    )

                    CompetitionList(

                        competitions = group.domesticCups,

                        onCompetitionSelected = { competition ->

                            onCompetitionSelected(
                                competition
                            )

                        }

                    )

                }

            }

        }

    }

}