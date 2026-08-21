package com.example.footballapp.ui.viewmodel

import android.util.Log
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

        Log.d(
            "CountryViewModel",
            "CountryViewModel CREATED"
        )

        loadCountries()
    }

    fun loadCountries() {

        if (_isLoading.value) {

            Log.d(
                "CountryViewModel",
                "loadCountries ignored - already loading"
            )

            return
        }

        viewModelScope.launch {

            Log.d(
                "CountryViewModel",
                "Loading countries..."
            )

            _isLoading.value = true
            _error.value = null

            try {

                val result =
                    repository.getCountries()

                Log.d(
                    "CountryViewModel",
                    "Repository returned ${result.size} countries"
                )

                Log.d(
                    "CountryViewModel",
                    "First countries: ${result.take(5)}"
                )

                _countries.value = result

                Log.d(
                    "CountryViewModel",
                    "StateFlow now contains ${_countries.value.size} countries"
                )

            } catch (exception: Exception) {

                Log.e(
                    "CountryViewModel",
                    "Failed to load countries",
                    exception
                )

                _error.value =
                    exception.message
                        ?: "Failed to load countries."

            } finally {

                _isLoading.value = false

                Log.d(
                    "CountryViewModel",
                    "Loading finished"
                )
            }
        }
    }
}