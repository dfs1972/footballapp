package com.example.footballapp.ui.model

/**
 * Represents a football competition as displayed by the UI.
 *
 * This model is independent of the backend DTOs and exists purely
 * to provide the data required by the Compose UI.
 */
data class CompetitionUiModel(

    /**
     * Unique competition identifier.
     */
    val id: Int,

    /**
     * Competition name displayed to the user.
     */
    val name: String,

    /**
     * Country the competition belongs to.
     */
    val country: String,

    /**
     * Competition type, for example "League" or "Cup".
     */
    val type: String
)