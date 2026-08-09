package com.example.footballapp.ui.screens.fixtures

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.footballapp.ui.components.FixtureCard
import com.example.footballapp.ui.components.ScreenScaffold
import com.example.footballapp.ui.components.SectionHeading
import com.example.footballapp.ui.design.AppSpacing
import com.example.footballapp.ui.model.FixtureDayUiModel

@Composable
fun FixturesScreen(

    competitionName: String,

    season: String,

    fixtureDays: List<FixtureDayUiModel>,

    onFixtureSelected: (Long) -> Unit

) {

    ScreenScaffold {

        item {

            Spacer(
                modifier = Modifier.height(
                    AppSpacing.ExtraLarge
                )
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