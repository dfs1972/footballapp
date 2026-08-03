package com.example.footballapp.ui.screens.fixtures

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.footballapp.ui.components.AppHeader
import com.example.footballapp.ui.components.FixtureCard
import com.example.footballapp.ui.components.ScreenScaffold
import com.example.footballapp.ui.components.SectionHeading
import com.example.footballapp.ui.design.AppSpacing
import com.example.footballapp.ui.model.FixtureDayUiModel
import com.example.footballapp.ui.previews.PreviewData
import com.example.footballapp.ui.theme.HeaderBlue

@Composable
fun TeamFixturesScreen(

    clubName: String,

    season: String,

    fixtureDays: List<FixtureDayUiModel>,

    onFixtureSelected: (Long) -> Unit

) {

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