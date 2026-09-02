package org.footballapp.mapper;

import org.footballapp.model.fixtures.Fixture;
import org.footballapp.model.fixtures.FixtureDetails;
import org.footballapp.model.fixtures.FixtureGoals;
import org.footballapp.model.fixtures.FixtureResponse;
import org.footballapp.model.fixtures.FixtureRow;
import org.footballapp.model.fixtures.FixtureTeams;
import org.footballapp.model.fixtures.FixturesApiResponse;
import org.footballapp.util.TeamNameFormatter;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
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

    /**
     * Maps a single API-Football fixture response
     * to FixtureDetails.
     */
    public FixtureDetails toFixtureDetails(
            FixturesApiResponse response
    ) {

        if (response == null
                || response.getResponse() == null
                || response.getResponse().isEmpty()) {

            return null;

        }

        return toFixtureDetails(
                response.getResponse().getFirst()
        );

    }

    private FixtureDetails toFixtureDetails(
            FixtureResponse response
    ) {

        Fixture fixture =
                response.getFixture();

        FixtureTeams teams =
                response.getTeams();

        FixtureGoals goals =
                response.getGoals();

        FixtureDetails details =
                new FixtureDetails();

        details.setFixtureId(
                fixture.getId()
        );

        /*
         * Use the same centralised UK date formatting
         * already used by FixtureMapper.
         */
        OffsetDateTime dateTime =
                OffsetDateTime.parse(
                        fixture.getDate()
                );

        ZonedDateTime ukDateTime =
                dateTime.atZoneSameInstant(
                        ZoneId.of("Europe/London")
                );

        details.setFixtureDate(
                        fixture.getDate()
        );

        details.setHomeTeamId(
                teams.getHome().getId()
        );

        details.setHomeTeam(
                TeamNameFormatter.format(
                        teams.getHome().getName()
                )
        );

        details.setHomeTeamLogo(
                teams.getHome().getLogo()
        );

        details.setAwayTeamId(
                teams.getAway().getId()
        );

        details.setAwayTeam(
                TeamNameFormatter.format(
                        teams.getAway().getName()
                )
        );

        details.setAwayTeamLogo(
                teams.getAway().getLogo()
        );

        details.setHomeGoals(
                goals.getHome()
        );

        details.setAwayGoals(
                goals.getAway()
        );

        if (fixture.getVenue() != null) {

            details.setVenueName(
                    fixture.getVenue().getName()
            );

        }

        if (fixture.getStatus() != null) {

            details.setStatusLong(
                    fixture.getStatus().getLongStatus()
            );

            details.setStatusShort(
                    fixture.getStatus().getShortStatus()
            );

            details.setElapsed(
                    fixture.getStatus().getElapsed()
            );

        }

        if (response.getLeague() != null) {

            details.setLeagueId(
                    response.getLeague().getId()
            );

            details.setLeagueName(
                    response.getLeague().getName()
            );

            details.setSeason(
                    response.getLeague().getSeason()
            );

            details.setRound(
                    response.getLeague().getRound()
            );

        }

        return details;

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

        populateFixtureDateTime(
                row,
                fixture.getDate()
        );

        row.setHomeTeamId(
                teams.getHome().getId()
        );

        row.setAwayTeamId(
                teams.getAway().getId()
        );

        row.setHomeTeam(
                TeamNameFormatter.format(
                        teams.getHome().getName()
                )
        );

        row.setAwayTeam(
                TeamNameFormatter.format(
                        teams.getAway().getName()
                )
        );

        row.setHomeGoals(
                goals.getHome()
        );

        row.setAwayGoals(
                goals.getAway()
        );

        return row;

    }

    /**
     * Formats fixture date/time for UK display.
     */
    private void populateFixtureDateTime(
            FixtureRow row,
            String rawDate
    ) {

        OffsetDateTime fixtureDate =
                OffsetDateTime.parse(
                        rawDate
                );

        ZonedDateTime ukDateTime =
                fixtureDate.atZoneSameInstant(
                        ZoneId.of(
                                "Europe/London"
                        )
                );

        row.setFixtureDate(
                ukDateTime.format(
                        DateTimeFormatter.ofPattern(
                                "EEE dd MMM yyyy"
                        )
                )
        );

        row.setFixtureTime(
                ukDateTime.format(
                        DateTimeFormatter.ofPattern(
                                "HH:mm"
                        )
                )
        );
    }

}