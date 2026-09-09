package org.footballapp.config.competitions;

import java.util.List;

public class SupportedCompetitionGroup {

    private String country;
    private String headerIcon;
    private List<SupportedCompetition> competitions;

    public SupportedCompetitionGroup() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHeaderIcon() {
        return headerIcon;
    }

    public void setHeaderIcon(String headerIcon) {
        this.headerIcon = headerIcon;
    }

    public List<SupportedCompetition> getCompetitions() {
        return competitions;
    }

    public void setCompetitions(List<SupportedCompetition> competitions) {
        this.competitions = competitions;
    }
}