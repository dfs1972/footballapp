package org.footballapp.model.teams;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Represents the root JSON response returned by
 * API-Football's teams endpoint.
 *
 * Example:
 * {
 *   "response": [...]
 * }
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamsApiResponse {

    private List<TeamResponse> response;

    public TeamsApiResponse() {
    }

    public List<TeamResponse> getResponse() {
        return response;
    }

    public void setResponse(List<TeamResponse> response) {
        this.response = response;
    }
}