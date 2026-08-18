package org.footballapp.model.fixtures;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FixtureRoundsApiResponse {

    private List<String> response;

    public List<String> getResponse() {
        return response;
    }

    public void setResponse(
            List<String> response
    ) {
        this.response = response;
    }
}