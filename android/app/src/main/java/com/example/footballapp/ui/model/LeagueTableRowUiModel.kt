package com.example.footballapp.ui.model

data class LeagueTableRowUiModel(

    val position: Int,

    val teamId: Int,

    val teamName: String,

    val teamLogo: String? =null,

    val played: Int,

    val wins: Int,

    val draws: Int,

    val losses: Int,

    val goalDifference: Int,

    val points: Int,

    val qualification: QualificationType,

    /**
     * Reserved for a future release.
     * Examples:
     * "WWDLW"
     * "LWWDW"
     */
    val form: String? = null

)