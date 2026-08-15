package com.example.footballapp.ui.screens.league

import androidx.compose.runtime.Composable
import com.example.footballapp.ui.components.LeagueTableCard
import com.example.footballapp.ui.components.ScreenScaffold
import com.example.footballapp.ui.model.LeagueOverviewUiModel
import com.example.footballapp.ui.model.LeagueTableGroupUiModel

@Composable
fun LeagueTableScreen(

    overview: LeagueOverviewUiModel,

    standings: List<LeagueTableGroupUiModel>,

    onClubClick: (Int) -> Unit

) {

    ScreenScaffold {

        item {

            LeagueTableCard(

                leagueName = overview.leagueName,

                season = overview.season,

                table = standings,

                onTeamClick = onClubClick

            )

        }

    }

}