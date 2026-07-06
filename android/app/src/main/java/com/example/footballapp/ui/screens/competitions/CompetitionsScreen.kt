package com.example.footballapp.ui.screens.competitions

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.footballapp.ui.components.CompetitionList
import com.example.footballapp.ui.components.ScreenScaffold
import com.example.footballapp.ui.components.SectionCard
import com.example.footballapp.ui.components.SectionHeading
import com.example.footballapp.ui.design.Strings
import androidx.compose.foundation.lazy.items
import com.example.footballapp.ui.previews.PreviewData

@Composable
fun CompetitionsScreen(

    onCompetitionSelected: (Int) -> Unit = {}

) {

    val groups = listOf(

        PreviewData.Scotland

    )

    ScreenScaffold(

        title = Strings.COMPETITIONS,

        subtitle = Strings.CHOOSE_COMPETITION

    ) {

        items(groups) { group ->

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

                        onCompetitionSelected = {

                            onCompetitionSelected(it.id)

                        }

                    )

                }

                if (group.domesticCups.isNotEmpty()) {

                    SectionHeading(

                        text = Strings.DOMESTIC_CUPS

                    )

                    CompetitionList(

                        competitions = group.domesticCups,

                        onCompetitionSelected = {

                            onCompetitionSelected(it.id)

                        }

                    )

                }

            }

        }

    }

}

@Preview(showBackground = true)
@Composable
private fun CompetitionsScreenPreview() {

    MaterialTheme {

        CompetitionsScreen()

    }

}