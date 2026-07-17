package org.footballapp.api.dto.fixtures;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Statistic {

    private String type;
    private Object value;

    public Statistic() {
    }

    public String getType() {
        return type;
    }

    public void setType(
            String type
    ) {
        this.type = type;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(
            Object value
    ) {
        this.value = value;
    }

}