package com.example.footballapp.ui.screens.league

import androidx.compose.runtime.Composable
import com.example.footballapp.ui.components.AppHeader
import com.example.footballapp.ui.components.LeagueTableCard
import com.example.footballapp.ui.components.ScreenScaffold
import com.example.footballapp.ui.model.LeagueOverviewUiModel
import com.example.footballapp.ui.model.LeagueTableRowUiModel
import com.example.footballapp.ui.theme.HeaderBlue

@Composable
fun LeagueTableScreen(

    overview: LeagueOverviewUiModel,

    standings: List<LeagueTableRowUiModel>,

    onClubClick: (Int) -> Unit

) {

    ScreenScaffold {

        item {

            AppHeader(

                backgroundColor = HeaderBlue

            )

        }

        item {

            LeagueTableCard(

                leagueName = overview.leagueName,

                table = standings,

                onTeamClick = onClubClick

            )

        }

    }

}