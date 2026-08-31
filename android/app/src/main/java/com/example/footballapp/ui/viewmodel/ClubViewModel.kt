package com.example.footballapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballapp.data.repository.ClubRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ClubViewModel : ViewModel() {

    private val repository =
        ClubRepository()

    private val _uiState =
        MutableStateFlow(
            ClubUiState()
        )

    val uiState: StateFlow<ClubUiState> =
        _uiState.asStateFlow()

    fun loadClub(
        clubId: Int
    ) {

        val currentState = _uiState.value

        if (currentState.clubId == clubId &&
            currentState.club != null) {
            return
        }

        viewModelScope.launch {

            _uiState.value =
                ClubUiState(
                    isLoading = true
                )

            try {

                val club =
                    repository.getClub(
                        clubId
                    )

                _uiState.value =
                    ClubUiState(

                        isLoading = false,

                        clubId = clubId,

                        club = club

                    )

            } catch (e: Exception) {

                _uiState.value =
                    ClubUiState(

                        isLoading = false,

                        error = e.message

                    )

            }

        }

    }

}