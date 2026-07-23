package com.example.footballapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.example.footballapp.ui.model.FixtureStatus
import com.example.footballapp.ui.model.FixtureUiModel
//import com.example.footballapp.ui.previews.PreviewData
import com.example.footballapp.ui.theme.AppDimensions
import com.example.footballapp.ui.design.AppSpacing

@Composable
fun FixtureCard(

    fixture: FixtureUiModel,

    onClick: () -> Unit

) {

    SectionCard(

        modifier = Modifier.clickable {

            onClick()

        }

    ) {

        Row(

            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = AppSpacing.Medium,
                    vertical = AppSpacing.Medium
                ),

            verticalAlignment = Alignment.Top

        ) {

            Column(

                modifier = Modifier.weight(1f)

            ) {

                Text(

                    text = fixture.homeTeamName,

                    style = MaterialTheme.typography.bodyMedium,

                    fontWeight = FontWeight.SemiBold,

                    maxLines = 1,

                    overflow = TextOverflow.Ellipsis

                )

                Text(

                    text = fixture.awayTeamName,

                    modifier = Modifier.padding(
                        top = AppSpacing.Small
                    ),

                    style = MaterialTheme.typography.bodyMedium,

                    fontWeight = FontWeight.SemiBold,

                    maxLines = 1,

                    overflow = TextOverflow.Ellipsis

                )

            }

            Spacer(

                modifier = Modifier.width(
                    AppSpacing.Medium
                )

            )

            FixtureCentre(

                fixture = fixture

            )

        }
    }
}

@Composable
private fun FixtureCentre(

    fixture: FixtureUiModel

) {

    Column(

        modifier = Modifier.width(
            AppDimensions.FixtureCentreWidth
        ),

        horizontalAlignment = Alignment.End

    ) {

        StatusChip(

            text = when (fixture.status) {

                FixtureStatus.SCHEDULED ->
                    fixture.kickOff

                FixtureStatus.LIVE ->
                    "LIVE"

                FixtureStatus.HALF_TIME ->
                    "HT"

                FixtureStatus.FINISHED ->
                    "FT"

                FixtureStatus.EXTRA_TIME ->
                    "ET"

                FixtureStatus.PENALTIES ->
                    "PEN"

                FixtureStatus.POSTPONED ->
                    "P/P"

                FixtureStatus.CANCELLED ->
                    "CAN"

            }

        )

        if (

            fixture.homeScore != null &&
            fixture.awayScore != null

        ) {

            Text(

                text = "${fixture.homeScore} - ${fixture.awayScore}",

                modifier = Modifier.padding(
                    top = AppSpacing.ExtraSmall
                ),

                style = MaterialTheme.typography.titleMedium,

                fontWeight = FontWeight.Bold

            )

        }

    }

}

//@Preview(name = "Scheduled", showBackground = true)
//@Composable
//private fun ScheduledPreview() {
//
//    MaterialTheme {
//
//        FixtureCard(
//
//            fixture = PreviewData.CelticVsRangers,
//
//            onClick = {}
//
//        )
//
//    }
//
//}
//
//@Preview(name = "Live", showBackground = true)
//@Composable
//private fun LivePreview() {
//
//    MaterialTheme {
//
//        FixtureCard(
//
//            fixture = PreviewData.HeartsVsAberdeen,
//
//            onClick = {}
//
//        )
//
//    }
//
//}
//
//@Preview(name = "Finished", showBackground = true)
//@Composable
//private fun FinishedPreview() {
//
//    MaterialTheme {
//
//        FixtureCard(
//
//            fixture = PreviewData.HibernianVsDundeeUnited,
//
//            onClick = {}
//
//        )
//
//    }
//
//}
//
//@Preview(name = "Postponed", showBackground = true)
//@Composable
//private fun PostponedPreview() {
//
//    MaterialTheme {
//
//        FixtureCard(
//
//            fixture = PreviewData.RossCountyVsStJohnstone,
//
//            onClick = {}
//
//        )
//
//    }
//
//}