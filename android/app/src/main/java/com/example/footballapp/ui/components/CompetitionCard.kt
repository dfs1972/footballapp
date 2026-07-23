package com.example.footballapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.example.footballapp.ui.design.AppSpacing
import com.example.footballapp.ui.model.CompetitionUiModel
//import com.example.footballapp.ui.previews.PreviewData
import com.example.footballapp.ui.theme.AppDimensions

@Composable
fun CompetitionCard(

    competition: CompetitionUiModel,

    onClick: (CompetitionUiModel) -> Unit

) {

    SectionCard(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick(competition)
            }
    ) {

        Column(

            modifier = Modifier
                .fillMaxWidth()
                .padding(AppSpacing.ExtraLarge),

            horizontalAlignment = Alignment.CenterHorizontally

        ) {

            AsyncImage(

                model = competition.logoUrl,

                contentDescription = competition.name,

                modifier = Modifier.size(AppDimensions.ImageExtraLarge)

            )

            Spacer(
                modifier = Modifier.height(AppSpacing.Medium)
            )

            Text(

                text = competition.name,

                style = MaterialTheme.typography.titleMedium,

                fontWeight = FontWeight.SemiBold

            )

        }

    }

}

//@Preview(showBackground = true)
//@Composable
//private fun CompetitionCardPreview() {
//
//    MaterialTheme {
//
//        CompetitionCard(
//
//            competition = PreviewData.ScottishPremiership,
//
//            onClick = {}
//
//        )
//
//    }
//
//}