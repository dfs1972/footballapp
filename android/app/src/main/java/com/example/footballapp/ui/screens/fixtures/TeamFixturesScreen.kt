package com.example.footballapp.ui.screens.fixtures

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import com.example.footballapp.ui.model.FixtureDayUiModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TeamFixturesScreen(

    clubName: String,

    season: String,

    fixtureDays: List<FixtureDayUiModel>,

    onFixtureSelected: (Long) -> Unit

) {

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

    ScreenScaffold {

        item {

            Spacer(
                modifier = Modifier.height(
                    AppSpacing.ExtraLarge
                )
            )

        }

        item {

            CardHeader(

                title =
                    clubName,

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
                        ExposedDropdownMenuDefaults.outlinedTextFieldColors()

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

                            }

                        )

                    }

                }

            }

        }

        selectedDay?.let { day ->

            items(

                items = day.fixtures,

                key = { it.fixtureId }

            ) { fixture ->

                FixtureListRow(

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