package com.example.footballapp.ui.screens.clubs

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.MaterialTheme
import com.example.footballapp.ui.components.ClubList
import com.example.footballapp.ui.components.ScreenScaffold
import com.example.footballapp.ui.components.SectionCard
import com.example.footballapp.ui.model.ClubUiModel
import com.example.footballapp.ui.previews.PreviewData

@Composable
fun ClubsScreen(

    competitionName: String,

    season: String,

    clubs: List<ClubUiModel>,

    onClubClick: (Int) -> Unit

) {

    ScreenScaffold(

        title = competitionName,

        subtitle = season

    ) {

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

@Preview(showBackground = true)
@Composable
private fun ClubsScreenPreview() {

    MaterialTheme {

        ClubsScreen(

            competitionName = "Scottish Premiership",

            season = "2025/26",

            clubs = PreviewData.ScottishPremiershipClubList,

            onClubClick = {}

        )

    }

}

