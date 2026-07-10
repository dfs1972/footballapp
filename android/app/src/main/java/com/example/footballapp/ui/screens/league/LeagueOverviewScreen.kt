package com.example.footballapp.ui.screens.league

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.footballapp.ui.components.NavigationCard
import com.example.footballapp.ui.components.ScreenScaffold
import com.example.footballapp.ui.components.TopStandingsCard
import com.example.footballapp.ui.design.AppConstants
import com.example.footballapp.ui.design.Strings
import com.example.footballapp.ui.model.CompetitionUiModel
import com.example.footballapp.ui.previews.PreviewData

@Composable
fun LeagueOverviewScreen(

    competition: CompetitionUiModel,

    onLeagueTableClick: () -> Unit = {},

    onFixturesClick: () -> Unit = {},

    onClubsClick: () -> Unit = {},

    onClubClick: (Int) -> Unit = {}

) {

    ScreenScaffold(

        title = competition.name,

        subtitle = "Season ${AppConstants.CURRENT_SEASON}"

    ) {

        item {

            TopStandingsCard(

                standings = PreviewData.ScottishPremiershipStandings.take(5),

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

        competition = PreviewData.ScottishPremiership

    )

}