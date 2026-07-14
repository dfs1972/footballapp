package com.example.footballapp.ui.viewmodel

import com.example.footballapp.ui.model.PlayerUiModel

data class SquadUiState(

    val isLoading: Boolean = true,

    val players: List<PlayerUiModel> = emptyList(),

    val error: String? = null

)