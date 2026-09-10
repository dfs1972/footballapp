package com.example.footballapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.example.footballapp.ui.design.AppSpacing
import com.example.footballapp.ui.model.ClubDetailsUiModel
import com.example.footballapp.ui.theme.AppElevation
import com.example.footballapp.ui.theme.AppShapes
import com.example.footballapp.util.ColorUtils

@Composable
fun ClubHeaderCard(
    club: ClubDetailsUiModel,
    leagueName: String? = null,
    showDetails: Boolean = true
) {
    val teamColor = ColorUtils.parseHexColor(club.colors?.player?.primary)
        ?: MaterialTheme.colorScheme.primary
    val contentColor = ColorUtils.getContrastColor(teamColor)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = AppSpacing.Screen,
                vertical = AppSpacing.Twelve
            ),
        shape = AppShapes.Card,
        elevation = CardDefaults.cardElevation(
            defaultElevation = AppElevation.Card
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column {
            // Team Name with background
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(teamColor)
                    .padding(vertical = AppSpacing.Twenty, horizontal = AppSpacing.Medium),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "${club.name} Football Club",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = contentColor,
                    textAlign = TextAlign.Center
                )
            }

            if (showDetails) {
                // Content with padding
                Column(
                    modifier = Modifier.padding(AppSpacing.Twenty)
                ) {
                    if (leagueName != null) {
                        SectionHeading(
                            text = leagueName,
                            centered = true
                        )
                        Spacer(modifier = Modifier.height(AppSpacing.Small))
                    }

                    InfoRow(
                        label = "Founded",
                        value = club.founded?.toString()
                    )

                    InfoRow(
                        label = "Stadium",
                        value = club.stadium
                    )

                    InfoRow(
                        label = "Capacity",
                        value = club.capacity?.toString()
                    )

                    InfoRow(
                        label = "Coach",
                        value = club.coach
                    )
                }
            }
        }
    }
}
