package com.example.footballapp.ui.screens.competitions

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.footballapp.ui.components.CompetitionList
import com.example.footballapp.ui.components.ScreenHeader
import com.example.footballapp.ui.components.SectionCard
import com.example.footballapp.ui.components.SectionHeading
import com.example.footballapp.ui.previews.PreviewData
import com.example.footballapp.ui.theme.AppSpacing

@Composable
fun CompetitionsScreen(

    onCompetitionSelected: (Int) -> Unit = {}

) {

    val groups = listOf(

        PreviewData.Scotland

    )

    LazyColumn(

        modifier = Modifier.fillMaxSize(),

        contentPadding = PaddingValues(

            vertical = AppSpacing.Medium

        )

    ) {

        item {

            ScreenHeader(

                title = "Competitions",

                subtitle = "Choose a competition to explore."

            )

        }

        items(groups) { group ->

            SectionCard {

                Text(

                    text = "${group.headerIcon} ${group.title}",

                    style = MaterialTheme.typography.titleLarge

                )

                if (group.leagues.isNotEmpty()) {

                    SectionHeading(

                        text = "Leagues"

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

                        text = "Domestic Cups"

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