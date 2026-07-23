package com.example.footballapp.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.MaterialTheme
import com.example.footballapp.ui.model.ClubUiModel
//import com.example.footballapp.ui.previews.PreviewData

@Composable
fun ClubList(

    clubs: List<ClubUiModel>,

    onClubClick: (ClubUiModel) -> Unit

) {

    clubs.forEach { club ->

        ClubRow(

            club = club,

            onClick = onClubClick

        )

    }

}

//@Preview(showBackground = true)
//@Composable
//private fun ClubListPreview() {
//
//    MaterialTheme {
//
//        SectionCard {
//
//            ClubList(
//
//                clubs = PreviewData.ScottishPremiershipClubList,
//
//                onClubClick = {}
//
//            )
//
//        }
//
//    }
//
//}