package com.example.footballapp.ui.viewmodel

import com.example.footballapp.ui.model.FixtureDetailsUiModel
import com.example.footballapp.ui.model.FixtureLineupUiModel

data class FixtureDetailsUiState(

    val isLoading: Boolean = true,

    val fixture: FixtureDetailsUiModel? = null,

    val lineup: FixtureLineupUiModel? = null,

    val error: String? = null

)