package com.example.footballapp.ui.screens.clubs

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import com.example.footballapp.ui.components.AppHeader
import com.example.footballapp.ui.components.ClubList
import com.example.footballapp.ui.components.ScreenScaffold
import com.example.footballapp.ui.components.SectionCard
import com.example.footballapp.ui.design.AppSpacing
import com.example.footballapp.ui.model.ClubUiModel
import com.example.footballapp.ui.previews.PreviewData
import com.example.footballapp.ui.theme.HeaderBlue

@Composable
fun ClubsScreen(

    competitionName: String,

    season: String,

    clubs: List<ClubUiModel>,

    onClubClick: (Int) -> Unit

) {

    ScreenScaffold {

        item {

            AppHeader(

                backgroundColor = HeaderBlue

            )

        }

        item {

            Spacer(
                modifier = Modifier.height(AppSpacing.ExtraLarge)
            )

        }

        item {

            SectionCard {

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

