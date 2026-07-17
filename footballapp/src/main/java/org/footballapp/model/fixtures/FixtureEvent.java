package org.footballapp.model.fixtures;

public class FixtureEvent {

    private int id;

    private long fixtureId;

    private Integer elapsed;

    private Integer extraTime;

    private int teamId;

    private Integer playerId;

    private Integer assistPlayerId;

    private String eventType;

    private String eventDetail;

    private String comments;

    public FixtureEvent() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getFixtureId() {
        return fixtureId;
    }

    public void setFixtureId(long fixtureId) {
        this.fixtureId = fixtureId;
    }

    public Integer getElapsed() {
        return elapsed;
    }

    public void setElapsed(Integer elapsed) {
        this.elapsed = elapsed;
    }

    public Integer getExtraTime() {
        return extraTime;
    }

    public void setExtraTime(Integer extraTime) {
        this.extraTime = extraTime;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public Integer getAssistPlayerId() {
        return assistPlayerId;
    }

    public void setAssistPlayerId(Integer assistPlayerId) {
        this.assistPlayerId = assistPlayerId;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventDetail() {
        return eventDetail;
    }

    public void setEventDetail(String eventDetail) {
        this.eventDetail = eventDetail;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}