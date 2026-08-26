package org.footballapp.model.competition;

import org.footballapp.model.standings.LeagueTableGroup;

import java.util.List;

public class CompetitionMetadata {

    private String currentRound;

    private List<LeagueTableGroup> standings;

    public String getCurrentRound() {
        return currentRound;
    }

    public void setCurrentRound(
            String currentRound
    ) {
        this.currentRound = currentRound;
    }

    public List<LeagueTableGroup> getStandings() {
        return standings;
    }

    public void setStandings(
            List<LeagueTableGroup> standings
    ) {
        this.standings = standings;
    }
}