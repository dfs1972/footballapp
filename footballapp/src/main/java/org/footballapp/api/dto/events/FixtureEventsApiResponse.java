package org.footballapp.api.dto.events;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FixtureEventsApiResponse {
    private List<FixtureEventDto> response;

    public FixtureEventsApiResponse() {}

    public List<FixtureEventDto> getResponse() { return response; }
    public void setResponse(List<FixtureEventDto> response) { this.response = response; }
}
