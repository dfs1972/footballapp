package org.footballapp.model.standings;

import java.util.List;

public class LeagueTableGroup {

    private String group;

    private List<LeagueTableRow> standings;

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public List<LeagueTableRow> getStandings() {
        return standings;
    }

    public void setStandings(
            List<LeagueTableRow> standings
    ) {
        this.standings = standings;
    }
}