package com.example.footballapp.data.repository

import android.content.Context

data class FavouriteCompetition(
    val leagueId: Int,
    val season: Int,
    val leagueName: String,
    val countryName: String,
    val type: String
)

class FavouriteRepository(
    context: Context
) {

    private val preferences = context.getSharedPreferences(
        "favourite_competitions",
        Context.MODE_PRIVATE
    )

    fun getFavourite(): FavouriteCompetition? {

        if (!preferences.contains(KEY_LEAGUE_ID)) {
            return null
        }

        return FavouriteCompetition(
            leagueId = preferences.getInt(KEY_LEAGUE_ID, -1),
            season = preferences.getInt(KEY_SEASON, -1),
            leagueName = preferences.getString(
                KEY_LEAGUE_NAME,
                ""
            ) ?: "",
            countryName = preferences.getString(
                KEY_COUNTRY_NAME,
                ""
            ) ?: "",
            type = preferences.getString(
                KEY_TYPE,
                "League"
            ) ?: "League"
        )
    }

    fun saveFavourite(
        favourite: FavouriteCompetition
    ) {
        preferences.edit()
            .putInt(
                KEY_LEAGUE_ID,
                favourite.leagueId
            )
            .putInt(
                KEY_SEASON,
                favourite.season
            )
            .putString(
                KEY_LEAGUE_NAME,
                favourite.leagueName
            )
            .putString(
                KEY_COUNTRY_NAME,
                favourite.countryName
            )
            .putString(
                KEY_TYPE,
                favourite.type
            )
            .apply()
    }

    fun clearFavourite() {
        preferences.edit()
            .clear()
            .apply()
    }

    companion object {

        private const val KEY_LEAGUE_ID =
            "league_id"

        private const val KEY_SEASON =
            "season"

        private const val KEY_LEAGUE_NAME =
            "league_name"

        private const val KEY_COUNTRY_NAME =
            "country_name"

        private const val KEY_TYPE =
            "type"
    }
}