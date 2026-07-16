package org.footballapp.service.importer;

import org.footballapp.api.ApiFootballService;
import org.footballapp.api.dto.lineups.FixtureLineupResponse;
import org.footballapp.api.dto.lineups.FixtureLineupsResponse;
import org.footballapp.databaserepository.FixtureLineupRepository;
import org.footballapp.model.lineups.FixtureLineup;
import org.footballapp.model.lineups.FixtureLineupPlayer;
import org.springframework.stereotype.Service;
import java.util.List;
import org.footballapp.api.dto.lineups.FixturePlayer;
import org.footballapp.api.dto.lineups.FixturePlayerWrapper;

@Service
public class FixtureLineupImportService {

    private final ApiFootballService apiFootballService;

    private final FixtureLineupRepository repository;

    public FixtureLineupImportService(

            ApiFootballService apiFootballService,

            FixtureLineupRepository repository

    ) {

        this.apiFootballService = apiFootballService;
        this.repository = repository;

    }

    public void importFixtureLineups(

            long fixtureId

    ) throws Exception {

        FixtureLineupsResponse response =
                apiFootballService.getFixtureLineups(
                        fixtureId
                );

        if (response == null ||
                response.getResponse() == null) {

            return;

        }

        for (FixtureLineupResponse lineup :

                response.getResponse()) {

            saveLineup(

                    fixtureId,

                    lineup

            );

        }

    }

    private void saveLineup(

            long fixtureId,

            FixtureLineupResponse lineup

    ) throws Exception {

        FixtureLineup fixtureLineup =
                new FixtureLineup();

        fixtureLineup.setFixtureId(
                fixtureId
        );

        fixtureLineup.setTeamId(
                lineup.getTeam().getId()
        );

        fixtureLineup.setCoachId(
                lineup.getCoach().getId()
        );

        fixtureLineup.setCoachName(
                lineup.getCoach().getName()
        );

        fixtureLineup.setFormation(
                lineup.getFormation()
        );

        repository.saveFixtureLineup(
                fixtureLineup
        );

        int displayOrder = 1;

        displayOrder = savePlayerList(

                fixtureId,

                lineup.getTeam().getId(),

                lineup.getStartXI(),

                true,

                displayOrder

        );

        savePlayerList(

                fixtureId,

                lineup.getTeam().getId(),

                lineup.getSubstitutes(),

                false,

                displayOrder

        );

    }

    private int savePlayerList(

            long fixtureId,

            int teamId,

            List<FixturePlayerWrapper> players,

            boolean starting,

            int displayOrder

    ) throws Exception {

        if (players == null) {

            return displayOrder;

        }

        for (FixturePlayerWrapper wrapper : players) {

            FixturePlayer dto =
                    wrapper.getPlayer();

            FixtureLineupPlayer player =
                    new FixtureLineupPlayer();

            player.setFixtureId(
                    fixtureId
            );

            player.setTeamId(
                    teamId
            );

            player.setPlayerId(
                    dto.getId()
            );

            player.setShirtNumber(
                    dto.getNumber()
            );

            player.setPosition(
                    dto.getPos()
            );

            player.setGrid(
                    dto.getGrid()
            );

            player.setStarting(
                    starting
            );

            player.setDisplayOrder(
                    displayOrder++
            );

            repository.saveFixtureLineupPlayer(
                    player
            );

        }

        return displayOrder;

    }

}