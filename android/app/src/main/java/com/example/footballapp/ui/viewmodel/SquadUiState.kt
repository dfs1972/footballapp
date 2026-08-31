package com.example.footballapp.ui.viewmodel

import com.example.footballapp.ui.model.PlayerUiModel

data class SquadUiState(

    val isLoading: Boolean = true,

    val teamId: Int? = null,

    val leagueId: Int? = null,

    val season: Int? = null,

    val players: List<PlayerUiModel> = emptyList(),

    val error: String? = null

)