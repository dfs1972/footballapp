package com.example.footballapp.ui.viewmodel

import com.example.footballapp.ui.model.ClubUiModel

data class ClubsUiState(

    val isLoading: Boolean = true,

    val leagueId: Int? = null,

    val season: Int? = null,

    val clubs: List<ClubUiModel> = emptyList(),

    val error: String? = null

)