package com.example.footballapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballapp.ui.model.CompetitionMetadataUiModel
import com.example.footballapp.data.repository.CompetitionMetadataRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CompetitionMetadataViewModel : ViewModel() {

    private val repository =
        CompetitionMetadataRepository()

    private val _metadata =
        MutableStateFlow<CompetitionMetadataUiModel?>(null)

    val metadata: StateFlow<CompetitionMetadataUiModel?> =
        _metadata.asStateFlow()

    private val _error =
        MutableStateFlow<String?>(null)

    private val _isLoading =
        MutableStateFlow(false)

    val isLoading: StateFlow<Boolean> =
        _isLoading.asStateFlow()

    val error: StateFlow<String?> =
        _error.asStateFlow()

    fun loadMetadata(
        leagueId: Int,
        season: Int
    ) {

        viewModelScope.launch {

            try {

                _error.value = null
                _isLoading.value = true

                _metadata.value =
                    repository.getCompetitionMetadata(
                        leagueId = leagueId,
                        season = season
                    )

            } catch (e: Exception) {

                _error.value =
                    e.message ?: "Unknown error"

            } finally {

                _isLoading.value = false
            }
        }
    }
}