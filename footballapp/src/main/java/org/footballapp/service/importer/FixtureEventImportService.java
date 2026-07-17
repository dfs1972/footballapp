package org.footballapp.service.importer;

import org.footballapp.api.ApiFootballService;
import org.footballapp.api.dto.events.FixtureEventResponse;
import org.footballapp.api.dto.events.FixtureEventsResponse;
import org.footballapp.repository.FixtureEventRepository;
import org.footballapp.model.fixtures.FixtureEvent;
import org.springframework.stereotype.Service;

@Service
public class FixtureEventImportService {

    public void replaceFixtureEvents(
            long fixtureId
    ) throws Exception {

        repository.deleteFixtureEvents(
                fixtureId
        );

        importFixtureEvents(
                fixtureId
        );

    }

    private final ApiFootballService apiFootballService;

    private final FixtureEventRepository repository;

    public FixtureEventImportService(

            ApiFootballService apiFootballService,

            FixtureEventRepository repository

    ) {

        this.apiFootballService = apiFootballService;
        this.repository = repository;

    }

    public void importFixtureEvents(

            long fixtureId

    ) throws Exception {

        FixtureEventsResponse response =
                apiFootballService.getFixtureEvents(
                        fixtureId
                );

        if (response == null ||
                response.getResponse() == null) {

            return;

        }

        for (FixtureEventResponse event :

                response.getResponse()) {

            saveEvent(

                    fixtureId,

                    event

            );

        }

    }

    private void saveEvent(

            long fixtureId,

            FixtureEventResponse dto

    ) throws Exception {

        FixtureEvent event =
                new FixtureEvent();

        event.setFixtureId(
                fixtureId
        );

        if (dto.getTime() != null) {

            event.setElapsed(
                    dto.getTime().getElapsed()
            );

            event.setExtraTime(
                    dto.getTime().getExtra()
            );

        }

        if (dto.getTeam() != null) {

            event.setTeamId(
                    dto.getTeam().getId()
            );

        }

        if (dto.getPlayer() != null) {

            event.setPlayerId(
                    dto.getPlayer().getId()
            );

        }

        if (dto.getAssist() != null) {

            event.setAssistPlayerId(
                    dto.getAssist().getId()
            );

        }

        event.setEventType(
                dto.getType()
        );

        event.setEventDetail(
                dto.getDetail()
        );

        event.setComments(
                dto.getComments()
        );

        repository.saveFixtureEvent(
                event
        );

    }

}