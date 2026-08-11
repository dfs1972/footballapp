package com.example.footballapp.ui.design

object SeasonFormatter {

    fun format(season: Int): String {

        val nextYear =
            (season + 1) % 100

        return "%d/%02d".format(
            season,
            nextYear
        )
    }
}