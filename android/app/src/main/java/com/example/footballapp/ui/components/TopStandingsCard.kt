package com.example.footballapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.footballapp.ui.design.Strings
import com.example.footballapp.ui.model.LeagueTableRowUiModel
//import com.example.footballapp.ui.previews.PreviewData
import com.example.footballapp.ui.design.AppSpacing
import com.example.footballapp.ui.model.LeagueTableGroupUiModel

@Composable
fun TopStandingsCard(

    leagueName: String,

    season: String,

    title: String = Strings.TOP_FIVE,

    standings: List<LeagueTableGroupUiModel>,

    onTeamClick: (LeagueTableRowUiModel) -> Unit,

    onViewFullTable: () -> Unit,

    viewMoreText: String = Strings.VIEW_FULL_TABLE

) {

    SectionCard {

        CardHeader(

            title = leagueName,

            subtitle = "$title · $season"

        )

        standings
            .sortedBy {
                when (it.group) {
                    "North" -> 0
                    "South" -> 1
                    else -> 2
                }
            }
            .forEach { group ->

                Text(
                    text = group.group,
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = AppSpacing.Small
                        )
                )

            group.standings
                .take(5)
                .forEach { standing ->

                    Row(

                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                onTeamClick(standing)
                            }
                            .padding(
                                vertical = AppSpacing.Small
                            ),

                        verticalAlignment =
                            Alignment.CenterVertically

                    ) {

                        Text(
                            text = standing.position.toString(),
                            modifier = Modifier.width(
                                AppSpacing.ExtraLarge
                            ),
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )

                        Text(
                            text = standing.teamName,
                            modifier = Modifier.weight(1f),
                            color = MaterialTheme.colorScheme.onSurface
                        )

                        Text(
                            text = "${standing.points} pts",
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
        }

        Row(

            modifier = Modifier
                .fillMaxWidth()
                .clickable {

                    onViewFullTable()

                }
                .padding(
                    top = AppSpacing.Medium
                ),

            horizontalArrangement =
                Arrangement.End,

            verticalAlignment =
                Alignment.CenterVertically

        ) {

            Text(

                text = viewMoreText,

                color =
                    MaterialTheme.colorScheme.primary,

                style =
                    MaterialTheme.typography.labelLarge

            )

            Icon(

                imageVector =
                    Icons.AutoMirrored.Filled.KeyboardArrowRight,

                contentDescription = null,

                tint =
                    MaterialTheme.colorScheme.primary

            )

        }

    }

}