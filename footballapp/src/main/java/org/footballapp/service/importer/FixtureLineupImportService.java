package org.footballapp.service.importer;

import org.footballapp.api.ApiFootballService;
import org.footballapp.api.dto.lineups.FixtureLineupResponse;
import org.footballapp.api.dto.lineups.FixtureLineupsResponse;
import org.footballapp.api.dto.lineups.FixturePlayer;
import org.footballapp.api.dto.lineups.FixturePlayerWrapper;
import org.footballapp.model.lineups.FixtureLineup;
import org.footballapp.model.lineups.FixtureLineupPlayer;
import org.footballapp.repository.FixtureLineupRepository;
import org.footballapp.repository.FixtureRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FixtureLineupImportService {

    private final ApiFootballService apiFootballService;
    private final FixtureLineupRepository repository;
    private final FixtureRepository fixtureRepository;

    public FixtureLineupImportService(
            ApiFootballService apiFootballService,
            FixtureLineupRepository repository,
            FixtureRepository fixtureRepository
    ) {
        this.apiFootballService = apiFootballService;
        this.repository = repository;
        this.fixtureRepository = fixtureRepository;
    }

    public void importLeagueFixtureLineups(
            int leagueId,
            int season
    ) throws Exception {

        List<Long> fixtureIds =
                fixtureRepository.getFixtureIds(
                        leagueId,
                        season
                );

        int total = fixtureIds.size();
        int current = 1;

        for (Long fixtureId : fixtureIds) {

            try {

                System.out.printf(
                        "[%d/%d] Importing fixture %d%n",
                        current,
                        total,
                        fixtureId
                );

                importFixtureLineups(
                        fixtureId
                );

            } catch (Exception ex) {

                System.err.printf(
                        "Failed to import fixture %d%n",
                        fixtureId
                );

                ex.printStackTrace();

            }

            current++;

        }

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

        if (lineup == null ||
                lineup.getTeam() == null) {

            return;

        }

        int teamId = lineup.getTeam().getId();

        FixtureLineup fixtureLineup =
                new FixtureLineup();

        fixtureLineup.setFixtureId(
                fixtureId
        );

        fixtureLineup.setTeamId(
                teamId
        );

        if (lineup.getCoach() != null) {

            fixtureLineup.setCoachId(
                    lineup.getCoach().getId()
            );

            fixtureLineup.setCoachName(
                    lineup.getCoach().getName()
            );

        }

        fixtureLineup.setFormation(
                lineup.getFormation()
        );

        repository.saveFixtureLineup(
                fixtureLineup
        );

        int displayOrder = 1;

        displayOrder = savePlayerList(
                fixtureId,
                teamId,
                lineup.getStartXI(),
                true,
                displayOrder
        );

        savePlayerList(
                fixtureId,
                teamId,
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

            if (wrapper == null ||
                    wrapper.getPlayer() == null) {

                continue;

            }

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