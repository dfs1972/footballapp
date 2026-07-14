package com.example.footballapp.ui.screens.league

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.footballapp.ui.components.NavigationCard
import com.example.footballapp.ui.components.ScreenScaffold
import com.example.footballapp.ui.components.TopStandingsCard
import com.example.footballapp.ui.design.AppConstants
import com.example.footballapp.ui.design.Strings
import com.example.footballapp.ui.model.LeagueOverviewUiModel
import com.example.footballapp.ui.model.LeagueTableRowUiModel
import com.example.footballapp.ui.previews.PreviewData

@Composable
fun LeagueOverviewScreen(

    overview: LeagueOverviewUiModel,

    onLeagueTableClick: () -> Unit = {},

    topStandings: List<LeagueTableRowUiModel>,

    onFixturesClick: () -> Unit = {},

    onClubsClick: () -> Unit = {},

    onClubClick: (Int) -> Unit = {}

) {

    ScreenScaffold(

        title = overview.leagueName,

        subtitle = "Season ${overview.season}"

    ) {

        item {

            TopStandingsCard(

                standings = topStandings,

                onTeamClick = {

                    onClubClick(it.teamId)

                },

                onViewFullTable = onLeagueTableClick

            )

        }

        item {

            NavigationCard(

                title = Strings.LEAGUE_TABLE,

                subtitle = Strings.VIEW_COMPLETE_STANDINGS,

                onClick = onLeagueTableClick

            )

        }

        item {

            NavigationCard(

                title = Strings.FIXTURES,

                subtitle = Strings.UPCOMING_FIXTURES,

                onClick = onFixturesClick

            )

        }

        item {

            NavigationCard(

                title = Strings.CLUBS,

                subtitle = Strings.BROWSE_ALL_CLUBS,

                onClick = onClubsClick

            )

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LeagueOverviewScreenPreview() {

    LeagueOverviewScreen(

        overview = LeagueOverviewUiModel(

            leagueId = AppConstants.DEVELOPMENT_LEAGUE,

            leagueName = "Scottish Premiership",

            season = AppConstants.DEVELOPMENT_SEASON_TEXT,

            teamCount = 12,

            fixtureCount = 228

        ),
        topStandings =
            PreviewData
                .ScottishPremiershipTable
                .take(5)

    )

}