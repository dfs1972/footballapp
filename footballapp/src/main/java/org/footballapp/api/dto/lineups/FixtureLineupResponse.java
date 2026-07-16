package org.footballapp.api.dto.lineups;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * One team's lineup returned by the
 * API-Football fixtures/lineups endpoint.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FixtureLineupResponse {

    private FixtureLineupTeam team;

    private FixtureCoach coach;

    private String formation;

    private List<FixturePlayerWrapper> startXI;

    private List<FixturePlayerWrapper> substitutes;

    public FixtureLineupTeam getTeam() {
        return team;
    }

    public void setTeam(
            FixtureLineupTeam team
    ) {
        this.team = team;
    }

    public FixtureCoach getCoach() {
        return coach;
    }

    public void setCoach(
            FixtureCoach coach
    ) {
        this.coach = coach;
    }

    public String getFormation() {
        return formation;
    }

    public void setFormation(
            String formation
    ) {
        this.formation = formation;
    }

    public List<FixturePlayerWrapper> getStartXI() {
        return startXI;
    }

    public void setStartXI(
            List<FixturePlayerWrapper> startXI
    ) {
        this.startXI = startXI;
    }

    public List<FixturePlayerWrapper> getSubstitutes() {
        return substitutes;
    }

    public void setSubstitutes(
            List<FixturePlayerWrapper> substitutes
    ) {
        this.substitutes = substitutes;
    }

}