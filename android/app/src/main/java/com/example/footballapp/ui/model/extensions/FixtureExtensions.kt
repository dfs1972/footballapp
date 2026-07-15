package com.example.footballapp.ui.model.extensions

import com.example.footballapp.ui.model.FixtureDayUiModel
import com.example.footballapp.ui.model.FixtureUiModel

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