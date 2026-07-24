package org.footballapp.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.footballapp.config.competitions.SupportedCompetitionGroup;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

@Service
public class SupportedCompetitionsService {

    private final ObjectMapper objectMapper;

    private List<SupportedCompetitionGroup> competitionGroups;

    public SupportedCompetitionsService(
            ObjectMapper objectMapper
    ) {
        this.objectMapper = objectMapper;
    }

    @PostConstruct
    public void loadCompetitions() {

        try {

            InputStream inputStream =
                    new ClassPathResource(
                            "supported-competitions.json"
                    ).getInputStream();

            competitionGroups =
                    objectMapper.readValue(
                            inputStream,
                            new TypeReference<List<SupportedCompetitionGroup>>() {
                            }
                    );

        } catch (Exception ex) {

            throw new IllegalStateException(
                    "Failed to load supported competitions configuration",
                    ex
            );

        }

    }

    public List<SupportedCompetitionGroup> getCompetitionGroups() {

        return Collections.unmodifiableList(
                competitionGroups
        );

    }

}