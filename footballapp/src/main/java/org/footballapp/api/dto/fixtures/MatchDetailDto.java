package org.footballapp.api.dto.fixtures;

import org.footballapp.model.fixtures.FixtureDetails;
import org.footballapp.api.dto.events.FixtureEventDto;
import org.footballapp.api.response.lineups.FixtureLineupResponse;
import java.util.List;

public class MatchDetailDto {
    private FixtureDetails fixture;
    private FixtureLineupResponse lineup;
    private List<FixtureEventDto> events;

    public MatchDetailDto() {}

    public FixtureDetails getFixture() { return fixture; }
    public void setFixture(FixtureDetails fixture) { this.fixture = fixture; }
    public FixtureLineupResponse getLineup() { return lineup; }
    public void setLineup(FixtureLineupResponse lineup) { this.lineup = lineup; }
    public List<FixtureEventDto> getEvents() { return events; }
    public void setEvents(List<FixtureEventDto> events) { this.events = events; }
}
