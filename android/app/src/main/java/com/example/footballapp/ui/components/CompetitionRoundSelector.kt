package com.example.footballapp.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CompetitionRoundSelector(

    rounds: List<String>,

    selectedRound: String?,

    onRoundSelected: (String) -> Unit

) {

    var expanded by
    remember {
        mutableStateOf(false)
    }

    ExposedDropdownMenuBox(

        expanded = expanded,

        onExpandedChange = {
            expanded = !expanded
        }

    ) {

        OutlinedTextField(

            value =
                selectedRound
                    ?: "Select round",

            onValueChange = {},

            readOnly = true,

            label = {
                androidx.compose.material3.Text(
                    "Round"
                )
            },

            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded
                )
            },

            modifier =
                Modifier
                    .fillMaxWidth()
                    .menuAnchor()

        )

        ExposedDropdownMenu(

            expanded = expanded,

            onDismissRequest = {
                expanded = false
            }

        ) {

            rounds.forEach { round ->

                DropdownMenuItem(

                    text = {
                        androidx.compose.material3.Text(
                            round
                        )
                    },

                    onClick = {

                        onRoundSelected(
                            round
                        )

                        expanded = false
                    }

                )
            }
        }
    }
}