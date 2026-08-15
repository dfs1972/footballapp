package com.example.footballapp.ui.screens.league

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.footballapp.ui.components.NavigationCard
import com.example.footballapp.ui.components.ScreenScaffold
import com.example.footballapp.ui.components.TopStandingsCard
import com.example.footballapp.ui.design.AppSpacing
import com.example.footballapp.ui.design.Strings
import com.example.footballapp.ui.model.LeagueOverviewUiModel
import com.example.footballapp.ui.model.LeagueTableGroupUiModel

@Composable
fun LeagueOverviewScreen(

    overview: LeagueOverviewUiModel,

    onLeagueTableClick: () -> Unit = {},

    topStandings: List<LeagueTableGroupUiModel>,

    onFixturesClick: () -> Unit = {},

    onClubsClick: () -> Unit = {},

    onClubClick: (Int) -> Unit = {}

) {

    ScreenScaffold {

        item {

            Spacer(
                modifier = Modifier.height(
                    AppSpacing.ExtraLarge
                )
            )

        }

        item {

            TopStandingsCard(

                leagueName = overview.leagueName,

                season = overview.season,

                standings = topStandings,

                onTeamClick = {

                    onClubClick(
                        it.teamId
                    )

                },

                onViewFullTable =
                    onLeagueTableClick

            )

        }

        item {

            NavigationCard(

                title =
                    Strings.LEAGUE_TABLE,

                subtitle =
                    Strings.VIEW_COMPLETE_STANDINGS,

                onClick =
                    onLeagueTableClick

            )

        }

        item {

            NavigationCard(

                title =
                    Strings.FIXTURES,

                subtitle =
                    Strings.UPCOMING_FIXTURES,

                onClick =
                    onFixturesClick

            )

        }

        item {

            NavigationCard(

                title =
                    Strings.CLUBS,

                subtitle =
                    Strings.BROWSE_ALL_CLUBS,

                onClick =
                    onClubsClick

            )

        }

    }

}