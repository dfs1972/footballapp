package com.example.footballapp.data.mapper

import com.example.footballapp.data.remote.dto.CompetitionMetadataDto
import com.example.footballapp.ui.model.CompetitionMetadataUiModel

fun CompetitionMetadataDto.toUiModel(): CompetitionMetadataUiModel {

    return CompetitionMetadataUiModel(

        currentRound = currentRound,

        standings = standings.map {
            it.toUiModel()
        }

    )
}