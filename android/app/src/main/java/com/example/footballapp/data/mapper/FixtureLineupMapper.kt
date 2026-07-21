package com.example.footballapp.data.mapper

import com.example.footballapp.data.remote.dto.FixtureLineupDto
import com.example.footballapp.ui.model.FixtureLineupUiModel
import com.example.footballapp.ui.model.FixtureTeamLineupUiModel
import com.example.footballapp.ui.model.PlayerLineupUiModel

fun FixtureLineupDto.toUiModel(): FixtureLineupUiModel =
    FixtureLineupUiModel(
        fixtureId = fixtureId,
        teams = teams.map { team ->
            FixtureTeamLineupUiModel(
                teamId = team.teamId,
                coachId = team.coachId,
                coachName = team.coachName,
                formation = team.formation,
                players = team.players.map { player ->
                    PlayerLineupUiModel(
                        playerId = player.playerId,
                        playerName = player.playerName,
                        photo = player.photo,
                        shirtNumber = player.shirtNumber,
                        position = player.position,
                        grid = player.grid,
                        starting = player.starting,
                        displayOrder = player.displayOrder
                    )
                }
            )
        }
    )