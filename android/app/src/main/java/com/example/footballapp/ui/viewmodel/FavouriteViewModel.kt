package com.example.footballapp.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import com.example.footballapp.data.repository.FavouriteCompetition
import com.example.footballapp.data.repository.FavouriteRepository

class FavouriteViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val repository =
        FavouriteRepository(application.applicationContext)

    private val _favourite =
        mutableStateOf(repository.getFavourite())

    val favourite: State<FavouriteCompetition?>
        get() = _favourite

    fun getFavourite(): FavouriteCompetition? {
        return _favourite.value
    }

    fun saveFavourite(
        favourite: FavouriteCompetition
    ) {
        repository.saveFavourite(favourite)

        _favourite.value = favourite
    }

    fun clearFavourite() {
        repository.clearFavourite()

        _favourite.value = null
    }

    fun isFavourite(
        leagueId: Int,
        season: Int
    ): Boolean {

        val currentFavourite = _favourite.value

        return currentFavourite?.leagueId == leagueId &&
                currentFavourite.season == season
    }
}