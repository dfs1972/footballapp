package org.footballapp.api.dto.events;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FixtureEventDto {

    private EventTimeDto time;
    private EventTeamDto team;
    private EventPlayerDto player;
    private EventPlayerDto assist;
    private String type;
    private String detail;
    private String comments;

    public FixtureEventDto() {
    }

    public EventTimeDto getTime() {
        return time;
    }

    public void setTime(EventTimeDto time) {
        this.time = time;
    }

    public EventTeamDto getTeam() {
        return team;
    }

    public void setTeam(EventTeamDto team) {
        this.team = team;
    }

    public EventPlayerDto getPlayer() {
        return player;
    }

    public void setPlayer(EventPlayerDto player) {
        this.player = player;
    }

    public EventPlayerDto getAssist() {
        return assist;
    }

    public void setAssist(EventPlayerDto assist) {
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
