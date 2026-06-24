package org.footballapp.model.league;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LeaguesApiResponse {

    private List<LeagueApiResponse> response;

    public List<LeagueApiResponse> getResponse() {
        return response;
    }

    public void setResponse(
            List<LeagueApiResponse> response
    ) {
        this.response = response;
    }
}