package com.example.footballapp.ui.screens.league

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.footballapp.ui.components.LeagueTableCard
import com.example.footballapp.ui.components.ScreenScaffold
import com.example.footballapp.ui.model.CompetitionUiModel
import com.example.footballapp.ui.model.LeagueTableRowUiModel
import com.example.footballapp.ui.previews.PreviewData
import com.example.footballapp.ui.theme.FootballAppTheme

@Composable
fun LeagueTableScreen(

    competition: CompetitionUiModel,

    table: List<LeagueTableRowUiModel>,

    onTeamClick: (Int) -> Unit

) {

    ScreenScaffold(

        title = competition.name,

        subtitle = competition.season

    ) {

        item {

            LeagueTableCard(

                table = PreviewData.ScottishPremiershipTable,

                onTeamClick = onTeamClick

            )

        }

    }

}

@Preview(showBackground = true)
@Composable
private fun LeagueTableScreenPreview() {

    FootballAppTheme {

        LeagueTableScreen(

            competition = PreviewData.ScottishPremiership,

            table = PreviewData.ScottishPremiershipTable,

            onTeamClick = {}

        )

    }

}