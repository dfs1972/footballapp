package org.footballapp.model.teamstatistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GoalsTotals {

    private FixturesTotals total;

    public FixturesTotals getTotal() {
        return total;
    }

    public void setTotal(FixturesTotals total) {
        this.total = total;
    }
}