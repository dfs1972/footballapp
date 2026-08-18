package org.footballapp.service;

import org.footballapp.model.fixtures.CompetitionStage;
import org.footballapp.model.fixtures.FixtureRoundsApiResponse;
import org.footballapp.model.competition.CompetitionMetadata;
import org.footballapp.model.standings.LeagueTableGroup;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

        metadata.setStages(
                getCompetitionStages(
                        leagueId,
                        season
                )
        );

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

    public List<CompetitionStage> getCompetitionStages(
            int leagueId,
            int season
    ) throws Exception {

        FixtureRoundsApiResponse response =
                footballDataProvider.getFixtureRounds(
                        leagueId,
                        season,
                        false
                );

        if (response == null
                || response.getResponse() == null
                || response.getResponse().isEmpty()) {

            return List.of();
        }

        Map<String, List<String>> stages =
                new LinkedHashMap<>();

        for (String round : response.getResponse()) {

            if (round == null
                    || round.isBlank()) {
                continue;
            }

            String[] parts =
                    round.split(
                            "\\s+-\\s+",
                            2
                    );

            String stageName;

            if (parts.length > 1) {
                stageName = parts[0].trim();
            } else {
                stageName = "Regular Season";
            }

            stages
                    .computeIfAbsent(
                            stageName,
                            key -> new ArrayList<>()
                    )
                    .add(round);
        }

        List<CompetitionStage> result =
                new ArrayList<>();

        for (Map.Entry<String, List<String>> entry
                : stages.entrySet()) {

            CompetitionStage stage =
                    new CompetitionStage();

            stage.setName(entry.getKey());
            stage.setRounds(entry.getValue());

            result.add(stage);
        }

        return result;
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