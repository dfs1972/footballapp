package com.example.footballapp.data.mapper

import com.example.footballapp.data.remote.dto.CompetitionMetadataDto
import com.example.footballapp.data.remote.dto.CompetitionStageDto
import com.example.footballapp.ui.model.CompetitionMetadataUiModel
import com.example.footballapp.ui.model.CompetitionStageUiModel

fun CompetitionMetadataDto.toUiModel(): CompetitionMetadataUiModel {

    return CompetitionMetadataUiModel(

        stages = stages.map {
            it.toUiModel()
        },

        currentRound = currentRound,

        standings = standings.map {
            it.toUiModel()
        }

    )
}

fun CompetitionStageDto.toUiModel(): CompetitionStageUiModel {

    return CompetitionStageUiModel(

        name = name,

        rounds = rounds

    )
}