package com.example.footballapp.ui.viewmodel

import com.example.footballapp.ui.model.FixtureDetailsUiModel

data class FixtureDetailsUiState(

    val isLoading: Boolean = true,

    val fixture: FixtureDetailsUiModel? = null,

    val error: String? = null

)