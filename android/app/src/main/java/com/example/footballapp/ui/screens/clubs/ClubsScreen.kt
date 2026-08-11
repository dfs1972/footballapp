package com.example.footballapp.ui.screens.clubs

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.footballapp.ui.components.CardHeader
import com.example.footballapp.ui.components.ClubList
import com.example.footballapp.ui.components.ScreenScaffold
import com.example.footballapp.ui.components.SectionCard
import com.example.footballapp.ui.design.AppSpacing
import com.example.footballapp.ui.design.Strings
import com.example.footballapp.ui.model.ClubUiModel
import com.example.footballapp.ui.model.LeagueOverviewUiModel

@Composable
fun ClubsScreen(

    overview: LeagueOverviewUiModel,

    clubs: List<ClubUiModel>,

    onClubClick: (Int) -> Unit

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

            SectionCard {

                CardHeader(

                    title =
                        overview.leagueName,

                    subtitle =
                        Strings.CLUBS

                )

                ClubList(

                    clubs = clubs,

                    onClubClick = { club ->

                        onClubClick(

                            club.clubId

                        )

                    }

                )

            }

        }

    }

}