package org.footballapp.model.fixtures;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FixturesApiResponse {

    private List<FixtureResponse> response;

    public FixturesApiResponse() {
    }

    public List<FixtureResponse> getResponse() {
        return response;
    }

    public void setResponse(List<FixtureResponse> response) {
        this.response = response;
    }
}