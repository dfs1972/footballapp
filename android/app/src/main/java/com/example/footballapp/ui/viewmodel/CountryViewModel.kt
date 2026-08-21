package com.example.footballapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballapp.data.repository.CountryRepository
import com.example.footballapp.ui.model.CountryUiModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CountryViewModel(
    private val repository: CountryRepository = CountryRepository()
) : ViewModel() {

    private val _countries =
        MutableStateFlow<List<CountryUiModel>>(emptyList())

    val countries: StateFlow<List<CountryUiModel>> =
        _countries.asStateFlow()

    private val _isLoading =
        MutableStateFlow(false)

    val isLoading: StateFlow<Boolean> =
        _isLoading.asStateFlow()

    private val _error =
        MutableStateFlow<String?>(null)

    val error: StateFlow<String?> =
        _error.asStateFlow()

    init {
        loadCountries()
    }

    fun loadCountries() {

        if (_isLoading.value) {
            return
        }

        viewModelScope.launch {

            _isLoading.value = true
            _error.value = null

            try {

                _countries.value =
                    repository.getCountries()

            } catch (exception: Exception) {

                _error.value =
                    exception.message
                        ?: "Failed to load countries."

            } finally {

                _isLoading.value = false
            }
        }
    }
}