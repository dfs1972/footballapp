package org.footballapp.model.standings;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StandingGoals {

    private int forGoals;
    private int against;

    @JsonProperty("for")
    public void setForGoals(int forGoals) {
        this.forGoals = forGoals;
    }

    public int getForGoals() {
        return forGoals;
    }

    public int getAgainst() {
        return against;
    }

    public void setAgainst(int against) {
        this.against = against;
    }
}
