package com.example.footballapp.ui.screens.fixtures

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.footballapp.ui.components.CardHeader
import com.example.footballapp.ui.components.FixtureListRow
import com.example.footballapp.ui.components.ScreenScaffold
import com.example.footballapp.ui.design.AppSpacing
import com.example.footballapp.ui.design.Strings
import com.example.footballapp.ui.model.CountryUiModel
import com.example.footballapp.ui.model.FixtureDayUiModel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FixturesScreen(

    competitionName: String,

    season: String,

    fixtureDays: List<FixtureDayUiModel>,

    onFixtureSelected: (Long, Int) -> Unit,

    searchQuery: String = "",

    onSearchQueryChange: (String) -> Unit = {},

    searchResults: List<CountryUiModel> = emptyList(),

    onSearchResultClick: (CountryUiModel) -> Unit = {}

) {

    val listState = androidx.compose.foundation.lazy.rememberLazyListState()

    var expanded by remember {
        mutableStateOf(false)
    }

    var selectedDay by remember(
        fixtureDays
    ) {
        mutableStateOf(
            fixtureDays.firstOrNull()
        )
    }

    val coroutineScope =
        rememberCoroutineScope()

    ScreenScaffold(

        listState = listState,

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

        item {

            CardHeader(

                title = competitionName,

                subtitle =
                    "${Strings.FIXTURES} · $season"

            )

        }

        item {

            Spacer(
                modifier = Modifier.height(
                    AppSpacing.Medium
                )
            )

        }

        item {

            ExposedDropdownMenuBox(

                expanded = expanded,

                onExpandedChange = {
                    expanded = !expanded
                }

            ) {

                OutlinedTextField(

                    value =
                        selectedDay?.heading ?: "",

                    onValueChange = {},

                    readOnly = true,

                    modifier = Modifier
                        .fillMaxWidth()
                        .menuAnchor(),

                    label = {
                        Text("Fixture Date")
                    },

                    trailingIcon = {

                        ExposedDropdownMenuDefaults.TrailingIcon(
                            expanded = expanded
                        )

                    },

                    colors =
                        ExposedDropdownMenuDefaults
                            .outlinedTextFieldColors()

                )

                ExposedDropdownMenu(

                    expanded = expanded,

                    onDismissRequest = {
                        expanded = false
                    }

                ) {

                    fixtureDays.forEach { day ->

                        DropdownMenuItem(

                            text = {

                                Text(
                                    text = day.heading
                                )

                            },

                            onClick = {

                                selectedDay = day

                                expanded = false

                                val dayIndex =
                                    fixtureDays.indexOf(day)

                                if (dayIndex >= 0) {

                                    var targetIndex = 3

                                    for (index in 0 until dayIndex) {

                                        targetIndex +=
                                            1 +
                                                    fixtureDays[index]
                                                        .fixtures
                                                        .size

                                    }

                                    coroutineScope.launch {

                                        listState.animateScrollToItem(
                                            targetIndex
                                        )

                                    }

                                }

                            }

                        )

                    }

                }

            }

        }

        /*
         * Every fixture date remains in the list.
         */

        fixtureDays.forEach { day ->

            item {

                FixtureDateHeading(
                    day.heading
                )

            }

            items(

                items = day.fixtures,

                key = { it.fixtureId }

            ) { fixture ->

                FixtureListRow(

                    fixture = fixture,

                    onClick = {

                        onFixtureSelected(
                            fixture.fixtureId,
                            season.toInt()
                        )

                    }

                )

            }

        }

    }

}

@Composable
private fun FixtureDateHeading(
    text: String
) {

    com.example.footballapp.ui.components.SectionHeading(
        text = text
    )

}




