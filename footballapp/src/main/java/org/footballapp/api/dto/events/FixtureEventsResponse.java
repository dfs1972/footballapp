package org.footballapp.api.dto.events;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FixtureEventsResponse {

    private List<FixtureEventResponse> response;

    public List<FixtureEventResponse> getResponse() {

        return response;

    }

    public void setResponse(

            List<FixtureEventResponse> response

    ) {

        this.response = response;

    }

}