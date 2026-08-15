package com.example.footballapp.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.footballapp.ui.model.LeagueTableGroupUiModel
//import com.example.footballapp.ui.previews.PreviewData
import com.example.footballapp.ui.design.AppSpacing
import com.example.footballapp.ui.design.Strings

@Composable
fun LeagueTableCard(

    leagueName: String,

    season: String,

    table: List<LeagueTableGroupUiModel>,

    onTeamClick: (Int) -> Unit

) {

    SectionCard {

        CardHeader(

            title = leagueName,

            subtitle =
                "${Strings.LEAGUE_TABLE} · $season"

        )

        LeagueTableHeader()

        Spacer(
            modifier = Modifier.height(
                AppSpacing.Small
            )
        )

        table
            .sortedBy {
                when (it.group) {
                    "North" -> 0
                    "South" -> 1
                    else -> 2
                }
            }
            .forEachIndexed { groupIndex, group ->

                Text(
                    text = group.group,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(
                    modifier = Modifier.height(
                        AppSpacing.Small
                    )
                )

                group.standings.forEachIndexed { index, row ->

                    LeagueTableRow(
                        row = row,
                        isEvenRow = index % 2 == 0,
                        onClubClick = onTeamClick
                    )

                }

                if (groupIndex < table.lastIndex) {
                    TableDivider()
                }

        }

    }

}
