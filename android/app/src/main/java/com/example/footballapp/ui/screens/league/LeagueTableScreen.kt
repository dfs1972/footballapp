package com.example.footballapp.ui.screens.league

import androidx.compose.runtime.Composable
import com.example.footballapp.ui.components.LeagueTableCard
import com.example.footballapp.ui.components.ScreenScaffold
import com.example.footballapp.ui.design.AppConstants
import com.example.footballapp.ui.model.LeagueOverviewUiModel
import com.example.footballapp.ui.model.LeagueTableRowUiModel

@Composable
fun LeagueTableScreen(

    overview: LeagueOverviewUiModel,

    standings: List<LeagueTableRowUiModel>,

    onClubClick: (Int) -> Unit

) {

    ScreenScaffold(

        title = overview.leagueName,

        subtitle = AppConstants.DEVELOPMENT_SEASON_TEXT

    ) {

        item {

            LeagueTableCard(

                table = standings,

                onTeamClick = onClubClick

            )

        }

    }

}

//@Preview(showBackground = true)
//@Composable
//private fun LeagueTableScreenPreview() {
//
//    FootballAppTheme {
//
//        LeagueTableScreen(
//
//            competition = PreviewData.ScottishPremiership,
//
//            standings = PreviewData.ScottishPremiershipTable,
//
//            onClubClick = {}
//
//        )
//
//    }
//
//}