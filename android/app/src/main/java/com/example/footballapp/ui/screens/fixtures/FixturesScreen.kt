package com.example.footballapp.ui.screens.fixtures

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.MaterialTheme
import com.example.footballapp.ui.components.FixtureCard
import com.example.footballapp.ui.components.ScreenScaffold
import com.example.footballapp.ui.components.SectionHeading
import com.example.footballapp.ui.model.FixtureDayUiModel
import com.example.footballapp.ui.previews.PreviewData
import androidx.compose.foundation.lazy.items

@Composable
fun FixturesScreen(

    competitionName: String,

    season: String,

    fixtureDays: List<FixtureDayUiModel>,

    onFixtureSelected: (Long) -> Unit

) {

    ScreenScaffold(

        title = competitionName,

        subtitle = season

    ) {

        fixtureDays.forEach { day ->

            item {

                SectionHeading(

                    day.heading

                )

            }

            items(

                items = day.fixtures,

                key = { it.fixtureId }

            ) { fixture ->

                FixtureCard(

                    fixture = fixture,

                    onClick = {

                        onFixtureSelected(

                            fixture.fixtureId

                        )

                    }

                )

            }

        }

    }

}

@Preview(showBackground = true)
@Composable
private fun FixturesScreenPreview() {

    MaterialTheme {

        FixturesScreen(

            competitionName = "Scottish Premiership",

            season = "2025/26",

            fixtureDays = listOf(

                PreviewData.TodayFixtures,

                PreviewData.TomorrowFixtures

            ),

            onFixtureSelected = {}

        )

    }

}