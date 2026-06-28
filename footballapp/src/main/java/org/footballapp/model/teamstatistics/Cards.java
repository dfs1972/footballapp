package org.footballapp.model.teamstatistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Cards {

    private CardColour yellow;
    private CardColour red;

    public CardColour getYellow() {
        return yellow;
    }

    public void setYellow(CardColour yellow) {
        this.yellow = yellow;
    }

    public CardColour getRed() {
        return red;
    }

    public void setRed(CardColour red) {
        this.red = red;
    }
}