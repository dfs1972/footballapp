package com.example.footballapp.ui.screens

import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.footballapp.ui.components.CompetitionList
import com.example.footballapp.ui.components.ScreenScaffold
import com.example.footballapp.ui.design.Strings
import com.example.footballapp.ui.viewmodel.CompetitionViewModel

@Composable
fun CompetitionsScreen(

    onCompetitionSelected: (Int) -> Unit = {}

) {

    val viewModel: CompetitionViewModel = viewModel()

    val uiState by viewModel.uiState.collectAsState()

    ScreenScaffold(

        title = Strings.COMPETITIONS,

        subtitle = Strings.CHOOSE_COMPETITION

    ) {

        when {

            uiState.isLoading -> {

                item {

                    CircularProgressIndicator()

                }

            }

            uiState.error != null -> {

                item {

                    Text(

                        text = uiState.error!!,

                        color = MaterialTheme.colorScheme.error

                    )

                }

            }

            else -> {

                item {

                    CompetitionList(

                        competitions = uiState.competitions,

                        onCompetitionSelected = {

                            onCompetitionSelected(it.id)

                        }

                    )

                }

            }

        }

    }

}