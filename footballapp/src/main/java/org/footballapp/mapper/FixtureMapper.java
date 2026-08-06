package org.footballapp.mapper;

import org.footballapp.model.fixtures.Fixture;
import org.footballapp.model.fixtures.FixtureGoals;
import org.footballapp.model.fixtures.FixtureResponse;
import org.footballapp.model.fixtures.FixtureRow;
import org.footballapp.model.fixtures.FixtureTeams;
import org.footballapp.model.fixtures.FixturesApiResponse;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class FixtureMapper {

    public List<FixtureRow> toFixtureRows(
            FixturesApiResponse response
    ) {

        List<FixtureRow> rows =
                new ArrayList<>();

        if (response == null
                || response.getResponse() == null) {

            return rows;

        }

        for (FixtureResponse fixtureResponse
                : response.getResponse()) {

            rows.add(
                    toFixtureRow(fixtureResponse)
            );

        }

        return rows;

    }

    private FixtureRow toFixtureRow(
            FixtureResponse response
    ) {

        Fixture fixture =
                response.getFixture();

        FixtureTeams teams =
                response.getTeams();

        FixtureGoals goals =
                response.getGoals();

        FixtureRow row =
                new FixtureRow();

        row.setFixtureId(
                fixture.getId()
        );

        OffsetDateTime dateTime =
                OffsetDateTime.parse(
                        fixture.getDate()
                );

        row.setFixtureDate(
                dateTime.toLocalDate().toString()
        );

        row.setFixtureTime(
                dateTime.toLocalTime().toString()
        );

        row.setHomeTeamId(
                teams.getHome().getId()
        );

        row.setAwayTeamId(
                teams.getAway().getId()
        );

        row.setHomeTeam(
                teams.getHome().getName()
        );

        row.setAwayTeam(
                teams.getAway().getName()
        );

        row.setHomeGoals(
                goals.getHome()
        );

        row.setAwayGoals(
                goals.getAway()
        );

        return row;

    }

}