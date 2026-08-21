package com.example.footballapp.ui.screens

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
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
import com.example.footballapp.data.remote.FlagUrlResolver
import com.example.footballapp.ui.components.CountryCard
import com.example.footballapp.ui.components.ScreenScaffold
import com.example.footballapp.ui.design.AppSpacing
import com.example.footballapp.ui.model.CountryUiModel

import androidx.compose.foundation.layout.size
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest

@Composable
fun CompetitionsScreen(

    countries: List<CountryUiModel>,

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

                countryName = country.name,

                // Competitions have not been loaded for the
                // country yet.
                competitionCount = 0,

                flagUrl =
                    FlagUrlResolver.resolve(
                        country.flag
                    ),

                expanded =
                    expandedCountry == country.name,

                onClick = {

                    expandedCountry =
                        if (
                            expandedCountry ==
                            country.name
                        ) {
                            null
                        } else {
                            country.name
                        }

                    onCountrySelected(country)
                }
            )

            Spacer(
                modifier = Modifier.height(
                    //AppSpacing.Small
                    AppSpacing.ExtraSmall
                )
            )
        }

    }
}
