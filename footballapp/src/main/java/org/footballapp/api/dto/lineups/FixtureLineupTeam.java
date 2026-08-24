package org.footballapp.api.dto.lineups;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Team information returned by the
 * API-Football fixtures/lineups endpoint.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FixtureLineupTeam {

    private int id;

    private String name;

    private String logo;

    private FixtureTeamColors colors;


    public int getId() {
        return id;
    }

    public void setId(
            int id
    ) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(
            String name
    ) {
        this.name = name;
    }


    public String getLogo() {
        return logo;
    }

    public void setLogo(
            String logo
    ) {
        this.logo = logo;
    }


    public FixtureTeamColors getColors() {
        return colors;
    }

    public void setColors(
            FixtureTeamColors colors
    ) {
        this.colors = colors;
    }

}