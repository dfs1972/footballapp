package com.example.footballapp.ui.screens.fixtures

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.footballapp.ui.components.CardHeader
import com.example.footballapp.ui.components.FixtureListRow
import com.example.footballapp.ui.components.ScreenScaffold
import com.example.footballapp.ui.components.SectionHeading
import com.example.footballapp.ui.design.AppSpacing
import com.example.footballapp.ui.design.Strings
import com.example.footballapp.ui.model.CountryUiModel
import com.example.footballapp.ui.model.FixtureDayUiModel
import com.example.footballapp.ui.model.TeamFixturesMonthUiModel
import com.example.footballapp.ui.model.extensions.groupByMonth
import java.time.format.DateTimeFormatter
import java.util.Locale

@Composable
fun TeamFixturesScreen(

    clubName: String,

    season: String,

    fixtureDays: List<FixtureDayUiModel>,

    onFixtureSelected: (Long, Int) -> Unit,

    searchQuery: String = "",

    onSearchQueryChange: (String) -> Unit = {},

    searchResults: List<CountryUiModel> = emptyList(),

    onSearchResultClick: (CountryUiModel) -> Unit = {}

) {

    val months =
        remember(fixtureDays) {
            fixtureDays.groupByMonth()
        }

    var expandedMonths by remember {
        mutableStateOf(
            emptySet<java.time.YearMonth>()
        )
    }

    ScreenScaffold(
        searchQuery = searchQuery,
        onSearchQueryChange = onSearchQueryChange,
        searchResults = searchResults,
        onSearchResultClick = onSearchResultClick
    ) {

        item {

            Spacer(
                modifier = Modifier.height(
                    AppSpacing.ExtraLarge
                )
            )

        }

        item {

            CardHeader(

                title = clubName,

                subtitle =
                    "${Strings.FIXTURES} · $season"

            )

        }

        months.forEach { month ->

            item {

                MonthHeader(

                    month = month,

                    expanded =
                        month.yearMonth in expandedMonths,

                    onClick = {

                        expandedMonths =
                            if (
                                month.yearMonth
                                in expandedMonths
                            ) {
                                expandedMonths -
                                        month.yearMonth
                            } else {
                                expandedMonths +
                                        month.yearMonth
                            }

                    }

                )

            }

            if (
                month.yearMonth in expandedMonths
            ) {

                month.fixtureDays.forEach { day ->

                    item {

                        SectionHeading(

                            text = day.heading

                        )

                    }

                    items(

                        items = day.fixtures,

                        key = {
                            it.fixtureId
                        }

                    ) { fixture ->

                        FixtureListRow(

                            fixture = fixture,

                            onClick = {

                                onFixtureSelected(
                                    fixture.fixtureId,
                                    season.toInt()
                                )

                            }

                        )

                    }

                }

            }

        }

    }

}

@Composable
private fun MonthHeader(

    month: TeamFixturesMonthUiModel,

    expanded: Boolean,

    onClick: () -> Unit

) {

    Row(

        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            }
            .padding(
                horizontal = AppSpacing.Screen,
                vertical = AppSpacing.Medium
            ),

        verticalAlignment =
            Alignment.CenterVertically,

        horizontalArrangement =
            Arrangement.SpaceBetween

    ) {

        Text(

            text = month.yearMonth.format(
                DateTimeFormatter.ofPattern(
                    "MMMM yyyy",
                    Locale.UK
                )
            ),

            style =
                MaterialTheme.typography.titleMedium,

            fontWeight =
                FontWeight.Bold,

            color =
                MaterialTheme.colorScheme.onSurface

        )

        Icon(

            imageVector =
                if (expanded) {
                    Icons.Filled.KeyboardArrowDown
                } else {
                    Icons.AutoMirrored.Filled
                        .KeyboardArrowRight
                },

            contentDescription =
                if (expanded) {
                    "Collapse"
                } else {
                    "Expand"
                },

            tint =
                MaterialTheme.colorScheme
                    .onSurfaceVariant

        )

    }

}