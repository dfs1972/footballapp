package org.footballapp.model.standings;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StandingRecord {

    private int played;
    private int win;
    private int draw;
    private int lose;

    private StandingGoals goals;

    /**Getters and Setters*/
    public int getPlayed() {
        return played;
    }

    public void setPlayed(int played) {
        this.played = played;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getLose() {
        return lose;
    }

    public void setLose(int lose) {
        this.lose = lose;
    }

    public StandingGoals getGoals() {
        return goals;
    }

    public void setGoals(StandingGoals goals) {
        this.goals = goals;
    }
}
