package org.footballapp.api.dto.events;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EventTime {

    private Integer elapsed;
    private Integer extra;

    public Integer getElapsed() {

        return elapsed;

    }

    public void setElapsed(

            Integer elapsed

    ) {

        this.elapsed = elapsed;

    }

    public Integer getExtra() {

        return extra;

    }

    public void setExtra(

            Integer extra

    ) {

        this.extra = extra;

    }

}