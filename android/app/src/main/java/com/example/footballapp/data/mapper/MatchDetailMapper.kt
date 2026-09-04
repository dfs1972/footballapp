package com.example.footballapp.data.mapper

import com.example.footballapp.data.remote.dto.FixtureEventDto
import com.example.footballapp.ui.model.FixtureEventUiModel

fun FixtureEventDto.toUiModel() = FixtureEventUiModel(
    elapsed = time.elapsed,
    extra = time.extra,
    teamId = team.id,
    teamName = team.name,
    teamLogo = "",
    playerId = player?.id,
    playerName = player?.name,
    assistId = assist?.id,
    assistName = assist?.name,
    type = type,
    detail = detail,
    comments = comments
)
