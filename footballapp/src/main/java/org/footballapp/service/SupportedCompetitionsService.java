package org.footballapp.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.footballapp.config.competitions.SupportedCompetition;
import org.footballapp.config.competitions.SupportedCompetitionGroup;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class SupportedCompetitionsService {

    private static final String LOGO_BASE_URL =
            "https://media.api-sports.io/football/leagues/";

    private final List<SupportedCompetitionGroup> competitionGroups;

    public SupportedCompetitionsService(ObjectMapper objectMapper)
            throws IOException {

        competitionGroups = objectMapper.readValue(
                new ClassPathResource("supported-competitions.json").getInputStream(),
                new TypeReference<List<SupportedCompetitionGroup>>() {}
        );

        populateLogoUrls();
    }

    public List<SupportedCompetitionGroup> getCompetitionGroups() {
        return competitionGroups;
    }

    private void populateLogoUrls() {

        for (SupportedCompetitionGroup group : competitionGroups) {

            for (SupportedCompetition competition : group.getCompetitions()) {

                competition.setLogoUrl(
                        LOGO_BASE_URL
                                + competition.getCompetitionId()
                                + ".png"
                );
            }
        }
    }
}