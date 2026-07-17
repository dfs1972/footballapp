package org.footballapp.api.dto.events;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FixtureEventResponse {

    private EventTime time;
    private EventTeam team;
    private EventPlayer player;
    private EventAssist assist;

    private String type;
    private String detail;
    private String comments;

    public EventTime getTime() {
        return time;
    }

    public void setTime(EventTime time) {
        this.time = time;
    }

    public EventTeam getTeam() {
        return team;
    }

    public void setTeam(EventTeam team) {
        this.team = team;
    }

    public EventPlayer getPlayer() {
        return player;
    }

    public void setPlayer(EventPlayer player) {
        this.player = player;
    }

    public EventAssist getAssist() {
        return assist;
    }

    public void setAssist(EventAssist assist) {
        this.assist = assist;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

}