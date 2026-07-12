package com.example.footballapp.data.mapper

import com.example.footballapp.data.remote.dto.TeamDto
import com.example.footballapp.ui.model.ClubUiModel

fun TeamDto.toUiModel() =
    ClubUiModel(

        clubId = id,

        name = name,

        shortName = null,

        badgeUrl = null,

        stadium = null

    )