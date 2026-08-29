package com.example.footballapp.ui.screens.competitions

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.footballapp.data.repository.FavouriteCompetition
import com.example.footballapp.ui.components.CompetitionRow
import com.example.footballapp.ui.components.CountryCard
import com.example.footballapp.ui.components.ScreenScaffold
import com.example.footballapp.ui.design.AppSpacing
import com.example.footballapp.ui.model.CompetitionUiModel
import com.example.footballapp.ui.model.CountryUiModel
import com.example.footballapp.ui.viewmodel.FavouriteViewModel

@Composable
fun CompetitionsScreen(

    countries: List<CountryUiModel>,

    competitions: List<CompetitionUiModel>,

    currentSeason: Int,

    isLoading: Boolean,

    error: String?,

    searchQuery: String,

    onSearchQueryChange: (String) -> Unit,

    initialCountry: CountryUiModel? = null,

    onInitialCountryConsumed: () -> Unit = {},

    onCountrySelected: (
        CountryUiModel,
        Int
    ) -> Unit,

    onCompetitionSelected: (
        Int,
        Int
    ) -> Unit

) {

    val favouriteViewModel: FavouriteViewModel = viewModel()

    var expandedCountry by remember {
        mutableStateOf<String?>(null)
    }

    var initialSearchCountry by remember {
        mutableStateOf(initialCountry)
    }

    LaunchedEffect(initialCountry) {

        if (initialCountry != null) {

            expandedCountry = initialCountry.name

            onCountrySelected(
                initialCountry,
                currentSeason
            )

            onInitialCountryConsumed()
        }
    }

    val sortedCountries =
        countries
            .filter {
                !it.code.isNullOrBlank()
            }
            .sortedBy {
                it.name.lowercase()
            }

    val filteredCountries =
        when {
            initialSearchCountry != null -> {
                listOfNotNull(initialSearchCountry)
            }

            searchQuery.isBlank() -> {
                sortedCountries
            }

            else -> {
                sortedCountries.filter { country ->
                    country.name.contains(
                        searchQuery,
                        ignoreCase = true
                    )
                }
            }
        }
    ScreenScaffold(

        searchQuery = searchQuery,

        onSearchQueryChange =
            onSearchQueryChange

    ) {

        item {

            Spacer(
                modifier = Modifier.height(
                    AppSpacing.Medium
                )
            )
        }

        if (
            searchQuery.isNotBlank()
            && filteredCountries.isEmpty()
        ) {

            item {

                Text(
                    text = "No countries found.",
                    color =
                        MaterialTheme
                            .colorScheme
                            .onSurface
                )

            }

        }

        items(
            items = filteredCountries,
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

                        onCountrySelected(
                            country,
                            currentSeason
                        )

                    }
                }
            )

            AnimatedVisibility(
                visible =
                    expandedCountry ==
                            country.name
            ) {

                Column {

                    when {

                        isLoading -> {

                            Text(
                                text = "Loading competitions...",
                                color =
                                    MaterialTheme.colorScheme.onSurface
                            )

                        }

                        error != null -> {

                            Text(
                                text = "Unable to load competitions.",
                                color =
                                    MaterialTheme.colorScheme.onSurface
                            )

                        }

                        competitions.isEmpty() -> {

                            Text(
                                text =
                                    "No competitions available " +
                                            "for the " +
                                            "$currentSeason season.",

                                color =
                                    MaterialTheme.colorScheme.onSurface
                            )

                        }

                        else -> {

                            competitions.forEach { competition ->

                                CompetitionRow(
                                    competition = competition,

                                    isFavourite = favouriteViewModel.isFavourite(
                                        competition.id,
                                        currentSeason
                                    ),

                                    onFavouriteClick = {

                                        if (favouriteViewModel.isFavourite(
                                                competition.id,
                                                currentSeason
                                            )
                                        ) {

                                            favouriteViewModel.clearFavourite()

                                        } else {

                                            favouriteViewModel.saveFavourite(
                                                FavouriteCompetition(
                                                    leagueId = competition.id,
                                                    season = currentSeason,
                                                    leagueName = competition.name,
                                                    countryName = country.name,
                                                    type = competition.type
                                                )
                                            )
                                        }
                                    },

                                    onClick = {
                                        onCompetitionSelected(
                                            competition.id,
                                            currentSeason
                                        )
                                    }
                                )

                            }
                        }
                    }
                }
            }
        }
    }
}
