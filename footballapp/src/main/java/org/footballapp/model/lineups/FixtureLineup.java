package org.footballapp.model.lineups;

/**
 * Represents a team's lineup for a fixture.
 *
 * One record exists per team per fixture.
 */
public class FixtureLineup {

    private long fixtureId;

    private int teamId;

    private int coachId;

    private String coachName;

    private String formation;

    public FixtureLineup() {
    }

    public FixtureLineup(

            long fixtureId,

            int teamId,

            int coachId,

            String coachName,

            String formation

    ) {

        this.fixtureId = fixtureId;
        this.teamId = teamId;
        this.coachId = coachId;
        this.coachName = coachName;
        this.formation = formation;

    }

    public long getFixtureId() {
        return fixtureId;
    }

    public void setFixtureId(
            long fixtureId
    ) {
        this.fixtureId = fixtureId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(
            int teamId
    ) {
        this.teamId = teamId;
    }

    public int getCoachId() {
        return coachId;
    }

    public void setCoachId(
            int coachId
    ) {
        this.coachId = coachId;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(
            String coachName
    ) {
        this.coachName = coachName;
    }

    public String getFormation() {
        return formation;
    }

    public void setFormation(
            String formation
    ) {
        this.formation = formation;
    }

}