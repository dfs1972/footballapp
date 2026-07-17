package org.footballapp.api.dto.fixtures;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FixtureStatisticsResponse {

    private List<FixtureTeamStatistics> response;

    public FixtureStatisticsResponse() {
    }

    public List<FixtureTeamStatistics> getResponse() {
        return response;
    }

    public void setResponse(
            List<FixtureTeamStatistics> response
    ) {
        this.response = response;
    }

}