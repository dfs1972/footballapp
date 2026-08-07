package org.footballapp.model.coaches;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CoachApiResponse {

    private List<Coach> response;

    public CoachApiResponse() {
    }

    public List<Coach> getResponse() {
        return response;
    }

    public void setResponse(
            List<Coach> response
    ) {
        this.response = response;
    }

}