package com.example.footballapp.ui.viewmodel

import com.example.footballapp.ui.model.PlayerDetailsUiModel

data class PlayerDetailsUiState(

    val isLoading: Boolean = true,

    val playerId: Int? = null,

    val player: PlayerDetailsUiModel? = null,

    val error: String? = null

)