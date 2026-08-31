package com.example.footballapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.text.style.TextOverflow
import com.example.footballapp.ui.design.AppSpacing
import com.example.footballapp.ui.model.FixtureStatus
import com.example.footballapp.ui.model.FixtureUiModel
import com.example.footballapp.util.DateFormatter

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

        Column(

            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = AppSpacing.Medium,
                    vertical = AppSpacing.Medium
                ),

            verticalArrangement =
                Arrangement.spacedBy(
                    AppSpacing.Medium
                )

        ) {

            /*
             * Fixture date
             */

            Text(

                text =
                    DateFormatter.formatFixtureDateOnly(
                        fixture.fixtureDate
                    ),

                modifier =
                    Modifier.fillMaxWidth(),

                style =
                    MaterialTheme.typography.labelLarge,

                fontWeight =
                    FontWeight.SemiBold,

                textAlign =
                    TextAlign.Center

            )

            /*
             * Teams and kick-off / score
             */

            Row(

                modifier =
                    Modifier.fillMaxWidth(),

                verticalAlignment =
                    Alignment.CenterVertically

            ) {

                Text(

                    text =
                        fixture.homeTeamName,

                    modifier =
                        Modifier.weight(1f),

                    style =
                        MaterialTheme.typography.bodyLarge,

                    fontWeight =
                        FontWeight.SemiBold,

                    textAlign =
                        TextAlign.End,

                    maxLines = 1,

                    overflow =
                        TextOverflow.Ellipsis

                )

                Spacer(

                    modifier =
                        Modifier.width(
                            AppSpacing.Medium
                        )

                )

                FixtureCentre(

                    fixture = fixture

                )

                Spacer(

                    modifier =
                        Modifier.width(
                            AppSpacing.Medium
                        )

                )

                Text(

                    text =
                        fixture.awayTeamName,

                    modifier =
                        Modifier.weight(1f),

                    style =
                        MaterialTheme.typography.bodyLarge,

                    fontWeight =
                        FontWeight.SemiBold,

                    textAlign =
                        TextAlign.Start,

                    maxLines = 1,

                    overflow =
                        TextOverflow.Ellipsis

                )

            }

            /*
             * Details navigation
             */

            Row(

                modifier =
                    Modifier.fillMaxWidth(),

                horizontalArrangement =
                    Arrangement.End,

                verticalAlignment =
                    Alignment.CenterVertically

            ) {

                Text(

                    text = "Details",

                    style =
                        MaterialTheme.typography.labelLarge,

                    color =
                        MaterialTheme.colorScheme.onSurfaceVariant

                )

                Icon(

                    imageVector =
                        Icons.AutoMirrored.Filled.KeyboardArrowRight,

                    contentDescription = "View fixture details",

                    tint =
                        MaterialTheme.colorScheme.onSurfaceVariant

                )

            }

        }

    }

}

@Composable
private fun FixtureCentre(

    fixture: FixtureUiModel

) {

    Column(

        modifier =
            Modifier.width(
                AppSpacing.ExtraLarge * 2
            ),

        horizontalAlignment =
            Alignment.CenterHorizontally

    ) {

        when (fixture.status) {

            FixtureStatus.SCHEDULED -> {

                Text(

                    text =
                        fixture.kickOff,

                    style =
                        MaterialTheme.typography.titleMedium,

                    fontWeight =
                        FontWeight.Bold,

                    textAlign =
                        TextAlign.Center

                )

            }

            FixtureStatus.FINISHED -> {

                FixtureScore(
                    fixture = fixture
                )

            }

            FixtureStatus.LIVE -> {

                FixtureStatusText(
                    text = "LIVE"
                )

                FixtureScoreIfAvailable(
                    fixture = fixture
                )

            }

            FixtureStatus.HALF_TIME -> {

                FixtureStatusText(
                    text = "HT"
                )

                FixtureScoreIfAvailable(
                    fixture = fixture
                )

            }

            FixtureStatus.EXTRA_TIME -> {

                FixtureStatusText(
                    text = "ET"
                )

                FixtureScoreIfAvailable(
                    fixture = fixture
                )

            }

            FixtureStatus.PENALTIES -> {

                FixtureStatusText(
                    text = "PEN"
                )

                FixtureScoreIfAvailable(
                    fixture = fixture
                )

            }

            FixtureStatus.POSTPONED -> {

                FixtureStatusText(
                    text = "P/P"
                )

            }

            FixtureStatus.CANCELLED -> {

                FixtureStatusText(
                    text = "CAN"
                )

            }

        }

    }

}

@Composable
private fun FixtureScore(

    fixture: FixtureUiModel

) {

    if (
        fixture.homeScore != null &&
        fixture.awayScore != null
    ) {

        Text(

            text =
                "${fixture.homeScore} - ${fixture.awayScore}",

            style =
                MaterialTheme.typography.titleMedium,

            fontWeight =
                FontWeight.Bold,

            textAlign =
                TextAlign.Center

        )

    } else {

        Text(

            text = "FT",

            style =
                MaterialTheme.typography.labelLarge,

            fontWeight =
                FontWeight.Bold,

            textAlign =
                TextAlign.Center

        )

    }

}

@Composable
private fun FixtureScoreIfAvailable(

    fixture: FixtureUiModel

) {

    if (
        fixture.homeScore != null &&
        fixture.awayScore != null
    ) {

        Text(

            text =
                "${fixture.homeScore} - ${fixture.awayScore}",

            modifier =
                Modifier.padding(
                    top = AppSpacing.ExtraSmall
                ),

            style =
                MaterialTheme.typography.bodyMedium,

            fontWeight =
                FontWeight.Bold,

            textAlign =
                TextAlign.Center

        )

    }

}

@Composable
private fun FixtureStatusText(

    text: String

) {

    Text(

        text = text,

        style =
            MaterialTheme.typography.labelLarge,

        fontWeight =
            FontWeight.Bold,

        textAlign =
            TextAlign.Center,

        color =
            MaterialTheme.colorScheme.onSurface

    )

}