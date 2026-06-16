package org.footballapp.model.standings;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StandingsApiResponse {

    private List<StandingsResponse> response;

    public List<StandingsResponse> getResponse() {
        return response;
    }

    public void setResponse(
            List<StandingsResponse> response
    ) {
        this.response = response;
    }
}