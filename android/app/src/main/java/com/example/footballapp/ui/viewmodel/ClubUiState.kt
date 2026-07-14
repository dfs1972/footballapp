package com.example.footballapp.ui.viewmodel

import com.example.footballapp.ui.model.ClubDetailsUiModel

data class ClubUiState(

    val isLoading: Boolean = true,

    val club: ClubDetailsUiModel? = null,

    val error: String? = null

)