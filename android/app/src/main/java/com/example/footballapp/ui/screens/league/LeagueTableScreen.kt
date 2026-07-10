package com.example.footballapp.ui.screens.league

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.footballapp.ui.components.LeagueTableCard
import com.example.footballapp.ui.components.ScreenScaffold
import com.example.footballapp.ui.design.AppConstants
import com.example.footballapp.ui.model.CompetitionUiModel
import com.example.footballapp.ui.model.LeagueTableRowUiModel
import com.example.footballapp.ui.previews.PreviewData
import com.example.footballapp.ui.theme.FootballAppTheme

@Composable
fun LeagueTableScreen(

    competition: CompetitionUiModel,

    standings: List<LeagueTableRowUiModel>,

    onClubClick: (Int) -> Unit

) {

    ScreenScaffold(

        title = competition.name,

        subtitle = AppConstants.CURRENT_SEASON

    ) {

        item {

            LeagueTableCard(

                table = PreviewData.ScottishPremiershipTable,

                onTeamClick = onClubClick

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

            standings = PreviewData.ScottishPremiershipTable,

            onClubClick = {}

        )

    }

}