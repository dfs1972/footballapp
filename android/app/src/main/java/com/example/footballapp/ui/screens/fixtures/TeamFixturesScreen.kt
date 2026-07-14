package com.example.footballapp.ui.screens.fixtures

import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.footballapp.ui.components.FixtureCard
import com.example.footballapp.ui.components.ScreenScaffold
import com.example.footballapp.ui.components.SectionHeading
import com.example.footballapp.ui.model.FixtureDayUiModel
import com.example.footballapp.ui.previews.PreviewData

@Composable
fun TeamFixturesScreen(

    clubName: String,

    season: String,

    fixtureDays: List<FixtureDayUiModel>,

    onFixtureSelected: (Long) -> Unit

) {

    ScreenScaffold(

        title = clubName,

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
private fun TeamFixturesScreenPreview() {

    MaterialTheme {

        TeamFixturesScreen(

            clubName = "Rangers",

            season = "2024/25",

            fixtureDays = listOf(

                PreviewData.TodayFixtures,

                PreviewData.TomorrowFixtures

            ),

            onFixtureSelected = {}

        )

    }

}