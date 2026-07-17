package org.footballapp.api.dto.fixtures;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.footballapp.model.teams.Team;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FixtureTeamStatistics {

    private Team team;

    private List<Statistic> statistics;

    public FixtureTeamStatistics() {
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(
            Team team
    ) {
        this.team = team;
    }

    public List<Statistic> getStatistics() {
        return statistics;
    }

    public void setStatistics(
            List<Statistic> statistics
    ) {
        this.statistics = statistics;
    }

}