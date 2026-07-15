package com.example.footballapp.ui.screens.fixtures

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.footballapp.ui.components.InfoRow
import com.example.footballapp.ui.components.ScreenScaffold
import com.example.footballapp.ui.components.SectionCard
import com.example.footballapp.ui.model.FixtureDetailsUiModel
import com.example.footballapp.ui.design.AppSpacing
import com.example.footballapp.util.DateFormatter

@Composable
fun FixtureDetailsScreen(

    fixture: FixtureDetailsUiModel

) {

    ScreenScaffold(

        title = fixture.leagueName,

        subtitle = fixture.season

    ) {

        /*
         * Match
         */

        item {

            Column(

                modifier = Modifier.fillMaxWidth(),

                horizontalAlignment =
                    Alignment.CenterHorizontally,

                verticalArrangement =
                    Arrangement.spacedBy(
                        AppSpacing.Medium
                    )

            ) {

                Text(

                    text = fixture.homeTeam,

                    style =
                        MaterialTheme.typography.titleLarge

                )

                Text(

                    text =
                        "${fixture.homeGoals ?: "-"} - ${fixture.awayGoals ?: "-"}",

                    style =
                        MaterialTheme.typography.headlineMedium,

                    fontWeight =
                        FontWeight.Bold

                )

                Text(

                    text = fixture.awayTeam,

                    style =
                        MaterialTheme.typography.titleLarge

                )

            }

        }

        /*
         * Fixture Information
         */

        item {

            SectionCard {

                InfoRow(

                    label = "Competition",

                    value = fixture.leagueName

                )

                InfoRow(

                    label = "Date",

                    value = DateFormatter
                        .formatFixtureDateOnly(

                            fixture.fixtureDate

                        )

                )

                InfoRow(

                    label = "Kick-off",

                    value = DateFormatter
                        .formatFixtureTime(

                            fixture.fixtureDate

                        )

                )

                InfoRow(

                    label = "Venue",

                    value = fixture.venueName ?: "N/A"

                )

            }

        }

    }

}

@Preview(showBackground = true)
@Composable
private fun FixtureDetailsScreenPreview() {

    MaterialTheme {

        FixtureDetailsScreen(

            fixture = FixtureDetailsUiModel(

                fixtureId = 1220110L,

                fixtureDate = "2024-08-03T11:30:00+00:00",

                homeTeam = "Heart Of Midlothian",

                awayTeam = "Rangers",

                homeGoals = 0,

                awayGoals = 0,

                venueName = "Tynecastle Park",

                leagueName = "Scottish Premiership",

                season = "2024/25",

                round = ""

            )

        )

    }

}