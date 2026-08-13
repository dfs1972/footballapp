package com.example.footballapp.ui.model

import java.time.YearMonth

data class TeamFixturesMonthUiModel(

    val yearMonth: YearMonth,

    val fixtureDays: List<FixtureDayUiModel>

)