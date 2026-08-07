package org.footballapp.model.coaches;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CoachCareer {

    private CoachCareerTeam team;

    private String start;

    private String end;

    public CoachCareer() {
    }

    public CoachCareerTeam getTeam() {
        return team;
    }

    public void setTeam(CoachCareerTeam team) {
        this.team = team;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}