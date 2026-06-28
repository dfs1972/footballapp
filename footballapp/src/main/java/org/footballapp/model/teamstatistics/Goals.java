package org.footballapp.model.teamstatistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Goals {

    private GoalsTotals forGoals;
    private GoalsTotals against;

    @JsonProperty("for")
    public GoalsTotals getForGoals() {
        return forGoals;
    }

    public void setForGoals(GoalsTotals forGoals) {
        this.forGoals = forGoals;
    }

    public GoalsTotals getAgainst() {
        return against;
    }

    public void setAgainst(GoalsTotals against) {
        this.against = against;
    }
}