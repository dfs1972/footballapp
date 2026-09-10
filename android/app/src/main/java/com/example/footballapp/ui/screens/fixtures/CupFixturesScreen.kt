package com.example.footballapp.ui.screens.fixtures

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.footballapp.ui.components.CardHeader
import com.example.footballapp.ui.components.FixtureListRow
import com.example.footballapp.ui.components.ScreenScaffold
import com.example.footballapp.ui.design.AppSpacing
import com.example.footballapp.ui.design.Strings
import com.example.footballapp.ui.model.CountryUiModel
import com.example.footballapp.ui.model.FixtureUiModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CupFixturesScreen(
    competitionName: String,
    season: String,
    rounds: List<String>,
    selectedRound: String?,
    onRoundSelected: (String) -> Unit,
    fixtures: List<FixtureUiModel>,
    onFixtureSelected: (Long, Int) -> Unit,
    isLoading: Boolean,
    error: String?,
    searchQuery: String = "",
    onSearchQueryChange: (String) -> Unit = {},
    searchResults: List<CountryUiModel> = emptyList(),
    onSearchResultClick: (CountryUiModel) -> Unit = {}
) {
    var expanded by remember { mutableStateOf(false) }

    ScreenScaffold(
        searchQuery = searchQuery,
        onSearchQueryChange = onSearchQueryChange,
        searchResults = searchResults,
        onSearchResultClick = onSearchResultClick
    ) {
        item {
            Spacer(modifier = Modifier.height(AppSpacing.ExtraLarge))
        }

        item {
            CardHeader(
                title = competitionName,
                subtitle = "${Strings.FIXTURES} · $season"
            )
        }

        item {
            Spacer(modifier = Modifier.height(AppSpacing.Medium))
        }

        if (rounds.isNotEmpty()) {
            item {
                ExposedDropdownMenuBox(
                    expanded = expanded,
                    onExpandedChange = { expanded = !expanded }
                ) {
                    OutlinedTextField(
                        value = selectedRound ?: "Select Round",
                        onValueChange = {},
                        readOnly = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .menuAnchor(),
                        label = { Text("Round") },
                        trailingIcon = {
                            ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                        },
                        colors = ExposedDropdownMenuDefaults.outlinedTextFieldColors()
                    )

                    ExposedDropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        rounds.forEach { round ->
                            DropdownMenuItem(
                                text = { Text(text = round) },
                                onClick = {
                                    onRoundSelected(round)
                                    expanded = false
                                }
                            )
                        }
                    }
                }
            }
        }

        if (isLoading) {
            item {
                Text(
                    text = "Loading fixtures...",
                    modifier = Modifier.padding(AppSpacing.Medium)
                )
            }
        } else if (error != null) {
            item {
                Text(
                    text = "Error: $error",
                    color = MaterialTheme.colorScheme.error,
                    modifier = Modifier.padding(AppSpacing.Medium)
                )
            }
        } else if (fixtures.isEmpty()) {
            item {
                Text(
                    text = "No fixtures found for this round.",
                    modifier = Modifier.padding(AppSpacing.Medium)
                )
            }
        } else {
            items(
                items = fixtures,
                key = { it.fixtureId }
            ) { fixture ->
                FixtureListRow(
                    fixture = fixture,
                    onClick = {
                        onFixtureSelected(fixture.fixtureId, season.take(4).toInt())
                    }
                )
            }
        }
    }
}
