package org.footballapp.model.competition;

import org.footballapp.model.fixtures.CompetitionStage;
import org.footballapp.model.standings.LeagueTableGroup;

import java.util.List;

public class CompetitionMetadata {

    private List<CompetitionStage> stages;

    private String currentRound;

    private List<LeagueTableGroup> standings;

    public List<CompetitionStage> getStages() {
        return stages;
    }

    public void setStages(
            List<CompetitionStage> stages
    ) {
        this.stages = stages;
    }

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