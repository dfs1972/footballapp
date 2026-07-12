package com.example.footballapp.ui.viewmodel

import com.example.footballapp.ui.model.ClubUiModel

data class ClubsUiState(

    val isLoading: Boolean = true,

    val clubs: List<ClubUiModel> = emptyList(),

    val error: String? = null

)