package com.example.footballapp.data.mapper

import com.example.footballapp.data.remote.dto.PlayerDto
import com.example.footballapp.ui.model.PlayerUiModel

fun PlayerDto.toUiModel() =

    PlayerUiModel(

        playerId = playerId,

        shirtNumber = shirtNumber,

        name = displayName,

        position = position

    )