package com.example.footballapp.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.footballapp.ui.model.LeagueTableRowUiModel
import com.example.footballapp.ui.previews.PreviewData
import com.example.footballapp.ui.design.AppSpacing

@Composable
fun LeagueTableCard(

    table: List<LeagueTableRowUiModel>,

    onTeamClick: (Int) -> Unit

) {

    SectionCard {

        LeagueTableHeader()

        Spacer(
            modifier = Modifier.height(AppSpacing.Small)
        )

        table.forEachIndexed { index, row ->

            LeagueTableRow(

                row = row,

                isEvenRow = false,

                onClubClick = onTeamClick

            )

            // Temporary location for Scottish Premiership
            if (index == 2) {

                TableDivider()

            }

        }

    }

}

@Preview(showBackground = true)
@Composable
private fun LeagueTableCardPreview() {

    LeagueTableCard(

        table = PreviewData.ScottishPremiershipTable,

        onTeamClick = {}

    )

}