package com.example.footballapp.data.mapper

import com.example.footballapp.data.remote.dto.FixtureTeamStatisticsDto
import com.example.footballapp.ui.model.MatchStatisticsUiModel

fun List<FixtureTeamStatisticsDto>.toUiModel(): List<MatchStatisticsUiModel> {
    if (size < 2) return emptyList()

    val homeStats = this[0].statistics
    val awayStats = this[1].statistics

    val statTypes = listOf(
        "Ball Possession",
        "Total Shots",
        "Shots on Goal",
        "Shots off Goal",
        "Goalkeeper Saves",
        "Blocked Shots",
        "Shots insidebox",
        "Shots outsidebox",
        "Corner Kicks",
        "Offsides",
        "Fouls",
        "Total passes",
        "Passes accurate",
        "Passes %"
    )

    return statTypes.mapNotNull { type ->
        val homeStat = homeStats.find { it.type == type }
        val awayStat = awayStats.find { it.type == type }

        if (homeStat == null && awayStat == null) return@mapNotNull null

        val homeVal = homeStat?.value?.toString() ?: "0"
        val awayVal = awayStat?.value?.toString() ?: "0"

        // Calculate percentages for bars
        var homeP = 0f
        var awayP = 0f

        try {
            val h = homeVal.replace("%", "").toFloatOrNull() ?: 0f
            val a = awayVal.replace("%", "").toFloatOrNull() ?: 0f
            if (h + a > 0) {
                homeP = h / (h + a)
                awayP = a / (h + a)
            }
        } catch (e: Exception) {}

        MatchStatisticsUiModel(
            type = translateStatType(type),
            homeValue = homeVal,
            awayValue = awayVal,
            homePercentage = homeP,
            awayPercentage = awayP
        )
    }
}

private fun translateStatType(type: String): String {
    return when (type) {
        "Ball Possession" -> "Possession"
        "Shots on Goal" -> "Shots on target"
        "Shots off Goal" -> "Shots off target"
        "Shots insidebox" -> "Shots inside box"
        "Shots outsidebox" -> "Shots outside box"
        "Corner Kicks" -> "Corners"
        "Fouls" -> "Total Fouls"
        "Passes %" -> "Pass Percentage"
        else -> type
    }
}
