package com.example.footballapp.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.footballapp.ui.components.CompetitionRow
import com.example.footballapp.ui.components.CountryCard
import com.example.footballapp.ui.components.ScreenScaffold
import com.example.footballapp.ui.design.AppSpacing
import com.example.footballapp.ui.model.CompetitionUiModel
import com.example.footballapp.ui.model.CountryUiModel

@Composable
fun CompetitionsScreen(

    countries: List<CountryUiModel>,

    competitions: List<CompetitionUiModel>,

    onCountrySelected: (CountryUiModel) -> Unit = {},

    onLeagueExplorerClick: () -> Unit = {}

) {

    var expandedCountry by rememberSaveable {

        mutableStateOf<String?>(null)

    }

    val sortedCountries =
        countries
            .filter {
                !it.code.isNullOrBlank()
            }
            .sortedBy {
                it.name.lowercase()
            }

    ScreenScaffold {

        item {

            Spacer(
                modifier = Modifier.height(
                    AppSpacing.ExtraLarge
                )
            )
        }

        items(
            items = sortedCountries,
            key = { country ->
                country.code ?: country.name
            }
        ) { country ->

            CountryCard(

                countryName =
                    country.name,

                flagUrl =
                    country.flag,

                expanded =
                    expandedCountry == country.name,

                onClick = {

                    val isExpanding =
                        expandedCountry != country.name

                    expandedCountry =
                        if (isExpanding) {
                            country.name
                        } else {
                            null
                        }

                    if (isExpanding) {

                        onCountrySelected(country)

                    }
                }
            )

            AnimatedVisibility(

                visible =
                    expandedCountry ==
                            country.name

            ) {

                Column {

                    competitions.forEach { competition ->

                        CompetitionRow(

                            competition =
                                competition,

                            onClick = {
                                // Competition selection
                                // will be implemented later.
                            }
                        )
                    }
                }
            }
        }
    }
}