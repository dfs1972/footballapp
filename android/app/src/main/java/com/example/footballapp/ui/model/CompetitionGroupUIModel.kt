package com.example.footballapp.ui.model

/**
 * Represents a group of competitions displayed on the
 * Competitions screen.
 *
 * Examples:
 * - Scotland
 * - England
 * - UEFA Competitions
 */
data class CompetitionGroupUiModel(

    /**
     * Section title.
     */
    val title: String,

    /**
     * Country flag emoji or future drawable/icon.
     */
    val headerIcon: String,

    /**
     * League competitions.
     */
    val leagues: List<CompetitionUiModel>,

    /**
     * Domestic cup competitions.
     *
     * Empty for UEFA.
     */
    val domesticCups: List<CompetitionUiModel>,

    /**
     * Allows groups to be displayed in a particular order.
     */
    val displayOrder: Int

)