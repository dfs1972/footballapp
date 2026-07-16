package org.footballapp.api.dto.lineups;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Root response returned by the
 * API-Football fixtures/lineups endpoint.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FixtureLineupsResponse {

    private List<FixtureLineupResponse> response;

    public List<FixtureLineupResponse> getResponse() {
        return response;
    }

    public void setResponse(
            List<FixtureLineupResponse> response
    ) {
        this.response = response;
    }

}