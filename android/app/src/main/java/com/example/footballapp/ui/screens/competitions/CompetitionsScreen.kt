package com.example.footballapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.footballapp.ui.components.CountryCard
import com.example.footballapp.ui.components.ScreenScaffold
import com.example.footballapp.ui.design.AppSpacing
import com.example.footballapp.ui.model.CountryUiModel

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
        countries.sortedBy {
            it.name.lowercase()
        }
    val listState = rememberLazyListState()


    android.util.Log.d(
        "CompetitionsScreen",
        "countries.size = ${countries.size}, " +
                "countries = ${countries.take(5)}"
    )

    @Composable
    fun CompetitionsScreen(
        countries: List<CountryUiModel>,
        onCountrySelected: (CountryUiModel) -> Unit = {},
        onLeagueExplorerClick: () -> Unit = {}
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Red)
        ) {
            Text(
                text = "COMPETITIONS SCREEN TEST",
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }
    }
}


