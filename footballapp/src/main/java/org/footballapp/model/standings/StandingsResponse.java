package org.footballapp.model.standings;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StandingsResponse {

    private StandingLeague league;

    public StandingLeague getLeague() {
        return league;
    }

    public void setLeague(
            StandingLeague league
    ) {
        this.league = league;
    }
}
