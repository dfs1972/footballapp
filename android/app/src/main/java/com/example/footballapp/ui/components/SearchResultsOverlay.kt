package com.example.footballapp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.footballapp.ui.model.CountryUiModel

@Composable
fun SearchResultsOverlay(
    results: List<CountryUiModel>,
    onResultClick: (CountryUiModel) -> Unit
) {
    if (results.isEmpty()) {
        return
    }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 160.dp,
                start = 16.dp,
                end = 16.dp
            ),
        tonalElevation = 4.dp,
        shadowElevation = 4.dp
    ) {
        Column {

            results.forEach { country ->

                CountryCard(
                    countryName = country.name,
                    flagUrl = country.flag,
                    expanded = false,
                    onClick = {
                        onResultClick(country)
                    }
                )
            }
        }
    }
}