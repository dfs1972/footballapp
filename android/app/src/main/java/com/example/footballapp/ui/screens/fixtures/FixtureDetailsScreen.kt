package com.example.footballapp.ui.screens.fixtures

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.example.footballapp.ui.components.FixtureLineupCard
import com.example.footballapp.ui.components.InfoRow
import com.example.footballapp.ui.components.ScreenScaffold
import com.example.footballapp.ui.components.SectionCard
import com.example.footballapp.ui.components.SectionHeading
import com.example.footballapp.ui.design.AppSpacing
import com.example.footballapp.ui.model.CountryUiModel
import com.example.footballapp.ui.model.FixtureDetailsUiModel
import com.example.footballapp.ui.model.FixtureLineupUiModel
import com.example.footballapp.util.DateFormatter

@Composable
fun FixtureDetailsScreen(

    fixture: FixtureDetailsUiModel,

    lineup: FixtureLineupUiModel? = null,

    onPlayerClick: (Int) -> Unit,

    searchQuery: String = "",

    onSearchQueryChange: (String) -> Unit = {},

    searchResults: List<CountryUiModel> = emptyList(),

    onSearchResultClick: (CountryUiModel) -> Unit = {}

) {

    ScreenScaffold(
        searchQuery = searchQuery,
        onSearchQueryChange = onSearchQueryChange,
        searchResults = searchResults,
        onSearchResultClick = onSearchResultClick
    ) {

        item {

            Spacer(
                modifier = Modifier.height(
                    AppSpacing.ExtraLarge
                )
            )

        }

        /*
         * Match
         */

        item {

            SectionCard {

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
                            MaterialTheme
                                .typography
                                .titleLarge

                    )

                    Text(

                        text =
                            "${fixture.homeGoals ?: "-"} – " +
                                    "${fixture.awayGoals ?: "-"}",

                        style =
                            MaterialTheme
                                .typography
                                .headlineLarge,

                        fontWeight =
                            FontWeight.Bold

                    )

                    Text(

                        text = fixture.awayTeam,

                        style =
                            MaterialTheme
                                .typography
                                .titleLarge

                    )

                }

            }

        }

        item {

            SectionCard {

                InfoRow(

                    label = "Competition",

                    value = fixture.leagueName

                )

                InfoRow(

                    label = "Round",

                    value = fixture.round

                )

                InfoRow(

                    label = "Date",

                    value =
                        DateFormatter
                            .formatFixtureDateOnly(
                                fixture.fixtureDate
                            )

                )

                InfoRow(

                    label = "Kick-off",

                    value =
                        DateFormatter
                            .formatFixtureTime(
                                fixture.fixtureDate
                            )

                )

                InfoRow(

                    label = "Venue",

                    value =
                        fixture.venueName ?: "N/A"

                )

            }

        }

        /*
         * Fixture Lineup
         */

        item {

            lineup?.let {

                FixtureLineupCard(

                    lineup = it,

                    onPlayerClick = onPlayerClick

                )
            }
        }

    }

}