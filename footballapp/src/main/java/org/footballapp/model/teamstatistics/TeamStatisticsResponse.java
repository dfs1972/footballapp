package org.footballapp.model.teamstatistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamStatisticsResponse {

    private League league;
    private Team team;
    private Fixtures fixtures;
    private Goals goals;

    private CleanSheet clean_sheet;
    private FailedToScore failed_to_score;

    private Cards cards;

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Fixtures getFixtures() {
        return fixtures;
    }

    public void setFixtures(Fixtures fixtures) {
        this.fixtures = fixtures;
    }

    public Goals getGoals() {
        return goals;
    }

    public void setGoals(Goals goals) {
        this.goals = goals;
    }

    public CleanSheet getClean_sheet() {
        return clean_sheet;
    }

    public void setClean_sheet(CleanSheet clean_sheet) {
        this.clean_sheet = clean_sheet;
    }

    public FailedToScore getFailed_to_score() {
        return failed_to_score;
    }

    public void setFailed_to_score(FailedToScore failed_to_score) {
        this.failed_to_score = failed_to_score;
    }

    public Cards getCards() {
        return cards;
    }

    public void setCards(Cards cards) {
        this.cards = cards;
    }
}