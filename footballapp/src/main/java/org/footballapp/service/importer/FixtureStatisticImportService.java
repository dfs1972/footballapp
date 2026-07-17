package org.footballapp.service.importer;

import org.footballapp.api.ApiFootballService;
import org.footballapp.api.dto.fixtures.FixtureStatisticsResponse;
import org.footballapp.api.dto.fixtures.FixtureTeamStatistics;
import org.footballapp.api.dto.fixtures.Statistic;
import org.footballapp.repository.FixtureStatisticRepository;
import org.footballapp.model.fixtures.FixtureStatistic;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static org.postgresql.jdbc.PgResultSet.toBigDecimal;

@Service
public class FixtureStatisticImportService {

    private final ApiFootballService apiFootballService;

    private final FixtureStatisticRepository repository;

    public FixtureStatisticImportService(

            ApiFootballService apiFootballService,

            FixtureStatisticRepository repository

    ) {

        this.apiFootballService =
                apiFootballService;

        this.repository =
                repository;

    }

    public void importFixtureStatistics(

            long fixtureId,

            int teamId

    ) throws Exception {

        FixtureStatisticsResponse response =
                apiFootballService
                        .getFixtureStatistics(

                                fixtureId,

                                teamId

                        );

        if (response == null ||
                response.getResponse() == null ||
                response.getResponse().isEmpty()) {

            return;

        }

        for (FixtureTeamStatistics teamStatistics
                : response.getResponse()) {

            FixtureStatistic statistic =
                    new FixtureStatistic();

            statistic.setFixtureId(
                    fixtureId
            );

            statistic.setTeamId(
                    teamStatistics
                            .getTeam()
                            .getId()
            );

            mapStatistics(

                    statistic,

                    teamStatistics

            );

            repository.saveFixtureStatistic(

                    statistic

            );

        }



    }

    private void mapStatistics(

            FixtureStatistic statistic,

            FixtureTeamStatistics teamStatistics

    ) {

        if (teamStatistics.getStatistics() == null) {
            return;
        }

        for (Statistic item :
                teamStatistics.getStatistics()) {

            String type =
                    item.getType();

            Object value =
                    item.getValue();

            switch (type) {

                case "Shots on Goal":
                    statistic.setShotsOnGoal(
                            toInteger(value)
                    );
                    break;

                case "Shots off Goal":
                    statistic.setShotsOffGoal(
                            toInteger(value)
                    );
                    break;

                case "Total Shots":
                    statistic.setTotalShots(
                            toInteger(value)
                    );
                    break;

                case "Blocked Shots":
                    statistic.setBlockedShots(
                            toInteger(value)
                    );
                    break;

                case "Shots insidebox":
                    statistic.setShotsInsideBox(
                            toInteger(value)
                    );
                    break;

                case "Shots outsidebox":
                    statistic.setShotsOutsideBox(
                            toInteger(value)
                    );
                    break;

                case "Fouls":
                    statistic.setFouls(
                            toInteger(value)
                    );
                    break;

                case "Corner Kicks":
                    statistic.setCornerKicks(
                            toInteger(value)
                    );
                    break;

                case "Offsides":
                    statistic.setOffsides(
                            toInteger(value)
                    );
                    break;

                case "Ball Possession":
                    statistic.setBallPossession(
                            value == null
                                    ? null
                                    : value.toString()
                    );
                    break;

                case "Yellow Cards":
                    statistic.setYellowCards(
                            toInteger(value)
                    );
                    break;

                case "Red Cards":
                    statistic.setRedCards(
                            toInteger(value)
                    );
                    break;

                case "Goalkeeper Saves":
                    statistic.setGoalkeeperSaves(
                            toInteger(value)
                    );
                    break;

                case "Total passes":
                    statistic.setTotalPasses(
                            toInteger(value)
                    );
                    break;

                case "Passes accurate":
                    statistic.setAccuratePasses(
                            toInteger(value)
                    );
                    break;

                case "Passes %":
                    statistic.setPassPercentage(
                            value == null
                                    ? null
                                    : value.toString()
                    );
                    break;

                case "expected_goals":
                    statistic.setExpectedGoals(
                            toBigDecimal(value)
                    );
                    break;

                case "goals_prevented":
                    statistic.setGoalsPrevented(
                            toBigDecimal(value)
                    );
                    break;
            }

        }

    }
    private Integer toInteger(Object value) {

        if (value == null) {
            return null;
        }

        if (value instanceof Number number) {
            return number.intValue();
        }

        return Integer.parseInt(
                value.toString()
        );

    }

    private BigDecimal toBigDecimal(Object value) {

        if (value == null) {
            return null;
        }

        if (value instanceof BigDecimal decimal) {
            return decimal;
        }

        return new BigDecimal(
                value.toString()
        );

    }

}