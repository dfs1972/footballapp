package org.footballapp.model.squad;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SquadApiResponse {

    private List<SquadResponse> response;

    public SquadApiResponse() {
    }

    public List<SquadResponse> getResponse() {
        return response;
    }

    public void setResponse(
            List<SquadResponse> response
    ) {
        this.response = response;
    }
}