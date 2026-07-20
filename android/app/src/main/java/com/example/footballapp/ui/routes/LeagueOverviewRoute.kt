package com.example.footballapp.ui.routes

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.footballapp.state.UiState
import com.example.footballapp.ui.previews.PreviewData
import com.example.footballapp.ui.screens.league.LeagueOverviewScreen
import com.example.footballapp.viewmodel.LeagueOverviewViewModel

@Composable
fun LeagueOverviewRoute(

    onLeagueTableClick: () -> Unit = {},

    onFixturesClick: () -> Unit = {},

    onClubsClick: () -> Unit = {},

    onClubClick: (Int) -> Unit = {}

) {

    val viewModel: LeagueOverviewViewModel = viewModel()

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {

        viewModel.loadLeagueOverview(
            leagueId = 179,
            season = 2024
        )

    }

    when (val state = uiState) {

        UiState.Loading -> {
            // TODO Loading screen
        }

        is UiState.Error -> {
            // TODO Error screen
        }

        is UiState.Success -> {

            LeagueOverviewScreen(

                overview = state.data,

                topStandings =
                    PreviewData
                        .ScottishPremiershipTable
                        .take(5),

                onLeagueTableClick = onLeagueTableClick,

                onFixturesClick = onFixturesClick,

                onClubsClick = onClubsClick,

                onClubClick = onClubClick

            )

        }

    }

}