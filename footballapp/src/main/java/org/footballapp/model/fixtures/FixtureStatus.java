package org.footballapp.model.fixtures;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FixtureStatus {

    @JsonProperty("long")
    private String longStatus;

    @JsonProperty("short")
    private String shortStatus;

    private Integer elapsed;

    public FixtureStatus() {
    }

    public String getLongStatus() {
        return longStatus;
    }

    public void setLongStatus(String longStatus) {
        this.longStatus = longStatus;
    }

    public String getShortStatus() {
        return shortStatus;
    }

    public void setShortStatus(String shortStatus) {
        this.shortStatus = shortStatus;
    }

    public Integer getElapsed() {
        return elapsed;
    }

    public void setElapsed(Integer elapsed) {
        this.elapsed = elapsed;
    }
}
