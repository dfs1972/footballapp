package org.footballapp.model.teamstatistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamStatisticsApiResponse {

    private TeamStatisticsResponse response;

    public TeamStatisticsResponse getResponse() {
        return response;
    }

    public void setResponse(TeamStatisticsResponse response) {
        this.response = response;
    }
}