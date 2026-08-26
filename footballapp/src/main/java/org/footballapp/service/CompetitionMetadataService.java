package org.footballapp.service;

import org.footballapp.model.fixtures.FixtureRoundsApiResponse;
import org.footballapp.model.competition.CompetitionMetadata;
import org.footballapp.model.standings.LeagueTableGroup;
import org.springframework.stereotype.Service;

@Service
public class CompetitionMetadataService {

    private final FootballDataProvider footballDataProvider;
    private final LeagueDataService leagueDataService;

    public CompetitionMetadataService(
            FootballDataProvider footballDataProvider,
            LeagueDataService leagueDataService
    ) {
        this.footballDataProvider = footballDataProvider;
        this.leagueDataService = leagueDataService;
    }

    public CompetitionMetadata getCompetitionMetadata(
            int leagueId,
            int season
    ) throws Exception {

        CompetitionMetadata metadata =
                new CompetitionMetadata();

        metadata.setCurrentRound(
                getCurrentRound(
                        leagueId,
                        season
                )
        );

        metadata.setStandings(
                leagueDataService.getLeagueTable(
                        leagueId,
                        season
                )
        );

        return metadata;
    }

    public String getCurrentRound(
            int leagueId,
            int season
    ) throws Exception {

        FixtureRoundsApiResponse response =
                footballDataProvider.getFixtureRounds(
                        leagueId,
                        season,
                        true
                );

        if (response == null
                || response.getResponse() == null
                || response.getResponse().isEmpty()) {

            return null;
        }

        return response.getResponse().getFirst();
    }
}