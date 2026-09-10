package com.example.footballapp.data.repository

import android.content.Context
import com.example.footballapp.ui.model.FixturePlayerColorsUiModel
import com.example.footballapp.ui.model.FixtureTeamColorsUiModel
import com.example.footballapp.util.TeamColorOverrides

class TeamColorRepository(context: Context) {

    private val preferences = context.getSharedPreferences("team_colors", Context.MODE_PRIVATE)

    fun saveTeamColors(teamId: Int, colors: FixtureTeamColorsUiModel) {
        val editor = preferences.edit()
        
        colors.player?.let {
            editor.putString("team_${teamId}_player_primary", it.primary)
            editor.putString("team_${teamId}_player_number", it.number)
            editor.putString("team_${teamId}_player_border", it.border)
        }
        
        colors.goalkeeper?.let {
            editor.putString("team_${teamId}_gk_primary", it.primary)
            editor.putString("team_${teamId}_gk_number", it.number)
            editor.putString("team_${teamId}_gk_border", it.border)
        }
        
        editor.apply()
    }

    fun getTeamColors(teamId: Int, teamName: String? = null): FixtureTeamColorsUiModel? {
        // 1. Check Hardcoded Overrides (Highest priority)
        val override = TeamColorOverrides.getOverride(teamId) 
            ?: teamName?.let { TeamColorOverrides.getOverrideByName(it) }
        
        if (override != null) return override

        // 2. Check SharedPreferences Cache
        val playerPrimary = preferences.getString("team_${teamId}_player_primary", null)
        val gkPrimary = preferences.getString("team_${teamId}_gk_primary", null)
        
        if (playerPrimary == null && gkPrimary == null) return null
        
        val player = if (playerPrimary != null) {
            FixturePlayerColorsUiModel(
                primary = playerPrimary,
                number = preferences.getString("team_${teamId}_player_number", null),
                border = preferences.getString("team_${teamId}_player_border", null)
            )
        } else null
        
        val gk = if (gkPrimary != null) {
            FixturePlayerColorsUiModel(
                primary = gkPrimary,
                number = preferences.getString("team_${teamId}_gk_number", null),
                border = preferences.getString("team_${teamId}_gk_border", null)
            )
        } else null
        
        return FixtureTeamColorsUiModel(player = player, goalkeeper = gk)
    }
}
