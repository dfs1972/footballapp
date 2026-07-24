package org.footballapp.config.competitions;

public class SupportedCompetition {

    private int competitionId;
    private String name;
    private CompetitionType type;
    private boolean enabled;
    private String logoUrl;

    public SupportedCompetition() {
    }

    public int getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(int competitionId) {
        this.competitionId = competitionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CompetitionType getType() {
        return type;
    }

    public void setType(CompetitionType type) {
        this.type = type;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getLogoUrl() {return logoUrl;}

    public void setLogoUrl(String logoUrl) {this.logoUrl = logoUrl;}

}