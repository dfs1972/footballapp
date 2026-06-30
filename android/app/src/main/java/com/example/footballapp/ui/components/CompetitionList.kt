package com.example.footballapp.ui.components

import androidx.compose.runtime.Composable
import com.example.footballapp.ui.model.CompetitionUiModel

@Composable
fun CompetitionList(
    competitions: List<CompetitionUiModel>,
    onCompetitionSelected: (CompetitionUiModel) -> Unit
) {

    competitions.forEach { competition ->

        CompetitionRow(
            competition = competition,
            onClick = {
                onCompetitionSelected(competition)
            }
        )

    }

}