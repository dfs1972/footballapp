package com.example.footballapp.util

import com.example.footballapp.ui.model.FixtureStatus

object FixtureStatusResolver {

    fun fromShortStatus(status: String?): FixtureStatus {
        return when (status?.uppercase()) {
            "TBD", "NS" -> FixtureStatus.SCHEDULED
            "1H", "2H", "ET", "P", "LIVE" -> FixtureStatus.LIVE
            "HT" -> FixtureStatus.HALF_TIME
            "FT", "AET", "PEN" -> FixtureStatus.FINISHED
            "PST" -> FixtureStatus.POSTPONED
            "CANC" -> FixtureStatus.CANCELLED
            "ABD" -> FixtureStatus.CANCELLED
            "AWD" -> FixtureStatus.FINISHED
            "WO" -> FixtureStatus.FINISHED
            else -> FixtureStatus.SCHEDULED
        }
    }

    fun isLive(status: FixtureStatus): Boolean {
        return status == FixtureStatus.LIVE ||
                status == FixtureStatus.HALF_TIME ||
                status == FixtureStatus.EXTRA_TIME ||
                status == FixtureStatus.PENALTIES
    }

    fun isFinished(status: FixtureStatus): Boolean {
        return status == FixtureStatus.FINISHED ||
                status == FixtureStatus.CANCELLED
    }
}
