package com.example.footballapp.util

import com.example.footballapp.ui.model.FixturePlayerColorsUiModel
import com.example.footballapp.ui.model.FixtureTeamColorsUiModel

object TeamColorOverrides {

    /**
     * Map of Team ID to their "True" primary colors.
     * 
     * Use this to correct cases where the API returns misleading primary colors
     * (e.g. Celtic returning white instead of green).
     */
    private val overrides = mapOf(
        // Scottish Premiership (Synced with team-colours.json apiFootballTeamId)
        247 to "#018749", // Celtic (Green)
        257 to "#076FDF", // Rangers (Blue)
        250 to "#0059A3", // Kilmarnock (Blue)
        254 to "#54243A", // Heart Of Midlothian (Maroon)
        249 to "#057430", // Hibernian (Green)
        252 to "#CC0000", // Aberdeen (Red)
        256 to "#FFBB00", // Motherwell (Yellow)
        251 to "#000000", // St Mirren (Black)
        1386 to "#FF4C1C", // Dundee Utd (Orange)
        258 to "#005CAB", // St Johnstone (Blue)
        255 to "#F2D202", // Livingston (Yellow)
        253 to "#00274F", // Dundee (Navy)
        902 to "#002D55", // Ross County (Dark Blue)
        
        // English Premier League (Synced with team-colours.json apiFootballTeamId)
        33 to "#EA0000",  // Manchester United
        40 to "#E41E2C",  // Liverpool
        49 to "#1532C1",  // Chelsea
        42 to "#E10000",  // Arsenal
        50 to "#ABD1F5",  // Manchester City
        47 to "#FFFFFF",  // Tottenham
        34 to "#FFFFFF",  // Newcastle
        66 to "#88002D",  // Aston Villa
        45 to "#0237AB",  // Everton
        48 to "#74112E",  // West Ham
        51 to "#FFFFFF",  // Brighton
        39 to "#FBBD37",  // Wolves
        35 to "#FF0000",  // Bournemouth
        55 to "#FF0000",  // Brentford
        52 to "#1017DA",  // Crystal Palace
        46 to "#2424EB",  // Leicester
        57 to "#0055AA",  // Ipswich
        36 to "#FFFFFF",  // Fulham
        41 to "#FAFAFA",  // Southampton
        65 to "#E4232C",  // Nottingham Forest
    )

    fun getOverride(teamId: Int): FixtureTeamColorsUiModel? {
        val primary = overrides[teamId] ?: return null
        
        return FixtureTeamColorsUiModel(
            player = FixturePlayerColorsUiModel(
                primary = primary,
                number = null, // Will fallback to contrast logic
                border = null
            ),
            goalkeeper = null
        )
    }
    
    /**
     * Optional: Add name-based overrides for cases where IDs are unknown or inconsistent.
     */
    private val nameOverrides = mapOf(
        "Celtic" to "#018749",
        "Rangers" to "#1B449C",
        "Kilmarnock" to "#0059A3",
        "Hearts" to "#800020",
        "Hibernian" to "#007544",
        "Aberdeen" to "#E32221",
        "Motherwell" to "#FFBC17",
        "St Mirren" to "#000000",
        "Dundee United" to "#F47920",
        "St Johnstone" to "#005CAB"
    )

    fun getOverrideByName(name: String): FixtureTeamColorsUiModel? {
        val primary = nameOverrides.entries.find { 
            name.contains(it.key, ignoreCase = true) 
        }?.value ?: return null
        
        return FixtureTeamColorsUiModel(
            player = FixturePlayerColorsUiModel(
                primary = primary,
                number = null,
                border = null
            ),
            goalkeeper = null
        )
    }
}
