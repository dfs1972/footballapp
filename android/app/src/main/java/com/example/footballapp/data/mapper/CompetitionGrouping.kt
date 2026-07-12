package com.example.footballapp.data.mapper

import com.example.footballapp.ui.model.CompetitionGroupUiModel
import com.example.footballapp.ui.model.CompetitionUiModel

/**
 * Groups competitions into the sections displayed by the
 * Competitions screen.
 *
 * The backend returns a flat list of competitions.
 * This mapper organises them into UI groups.
 */
fun List<CompetitionUiModel>.toCompetitionGroups(): List<CompetitionGroupUiModel> {

    // -------------------------------------------------------------------------
    // Scotland
    // -------------------------------------------------------------------------

    val scotland = filter {

        it.name.contains("Scottish", ignoreCase = true) ||
                it.name == "League Cup"

    }

    val scottishLeagues = scotland.filter {

        "Championship" in it.name ||
                "League One" in it.name ||
                "League Two" in it.name ||
                "Premiership" in it.name

    }

    val scottishCups = scotland.filter {

        it.name == "Scottish Cup" ||
                it.name == "League Cup"

    }

    val groups = mutableListOf<CompetitionGroupUiModel>()

    if (scotland.isNotEmpty()) {

        groups.add(

            CompetitionGroupUiModel(

                title = "Scotland",

                headerIcon = "\uD83C\uDFF4",

                leagues = scottishLeagues,

                domesticCups = scottishCups,

                displayOrder = 1

            )

        )

    }

    return groups.sortedBy {

        it.displayOrder

    }

}