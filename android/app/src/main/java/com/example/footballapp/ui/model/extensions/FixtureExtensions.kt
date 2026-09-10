package com.example.footballapp.ui.model.extensions

import android.util.Log
import com.example.footballapp.ui.model.FixtureDayUiModel
import com.example.footballapp.ui.model.FixtureUiModel
import com.example.footballapp.ui.model.TeamFixturesMonthUiModel
import com.example.footballapp.util.DateFormatter
import java.time.YearMonth

/**
 * Groups fixtures into day sections for display.
 */
fun List<FixtureUiModel>.groupByDay(): List<FixtureDayUiModel> =

    groupBy {

        it.fixtureDate

    }.map { (date, fixtures) ->

        FixtureDayUiModel(

            heading = date,

            fixtures = fixtures

        )

    }

fun List<FixtureDayUiModel>.groupByMonth():
        List<TeamFixturesMonthUiModel> {

    val monthGroups =
        mutableMapOf<
                YearMonth,
                MutableList<FixtureDayUiModel>
                >()

    for (day in this) {

        val fixtureDate =
            day.fixtures
                .firstOrNull()
                ?.fixtureDate
                ?: continue

        val date =
            DateFormatter.parseFixtureDate(
                fixtureDate
            )

        if (date == null) {
            Log.e("FixtureExtensions", "Failed to parse fixture date: $fixtureDate")
            continue
        }

        val yearMonth =
            YearMonth.from(date)

        monthGroups
            .getOrPut(yearMonth) {
                mutableListOf()
            }
            .add(day)
    }

    return monthGroups
        .toSortedMap()
        .map { (yearMonth, fixtureDays) ->

            Log.d("FixtureExtensions", "Grouped month: $yearMonth with ${fixtureDays.size} days")

            TeamFixturesMonthUiModel(

                yearMonth = yearMonth,

                fixtureDays = fixtureDays

            )
        }
}