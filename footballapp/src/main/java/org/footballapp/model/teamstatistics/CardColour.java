package org.footballapp.model.teamstatistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CardColour {

    @JsonProperty("0-15")
    private CardMinute minute0to15;

    @JsonProperty("16-30")
    private CardMinute minute16to30;

    @JsonProperty("31-45")
    private CardMinute minute31to45;

    @JsonProperty("46-60")
    private CardMinute minute46to60;

    @JsonProperty("61-75")
    private CardMinute minute61to75;

    @JsonProperty("76-90")
    private CardMinute minute76to90;

    @JsonProperty("91-105")
    private CardMinute minute91to105;

    @JsonProperty("106-120")
    private CardMinute minute106to120;

    /**
     * Getters and Setters
     */
    public CardMinute getMinute0to15() {
        return minute0to15;
    }

    public void setMinute0to15(CardMinute minute0to15) {
        this.minute0to15 = minute0to15;
    }

    public CardMinute getMinute16to30() {
        return minute16to30;
    }

    public void setMinute16to30(CardMinute minute16to30) {
        this.minute16to30 = minute16to30;
    }

    public CardMinute getMinute31to45() {
        return minute31to45;
    }

    public void setMinute31to45(CardMinute minute31to45) {
        this.minute31to45 = minute31to45;
    }

    public CardMinute getMinute46to60() {
        return minute46to60;
    }

    public void setMinute46to60(CardMinute minute46to60) {
        this.minute46to60 = minute46to60;
    }

    public CardMinute getMinute61to75() {
        return minute61to75;
    }

    public void setMinute61to75(CardMinute minute61to75) {
        this.minute61to75 = minute61to75;
    }

    public CardMinute getMinute76to90() {
        return minute76to90;
    }

    public void setMinute76to90(CardMinute minute76to90) {
        this.minute76to90 = minute76to90;
    }

    public CardMinute getMinute91to105() {
        return minute91to105;
    }

    public void setMinute91to105(CardMinute minute91to105) {
        this.minute91to105 = minute91to105;
    }

    public CardMinute getMinute106to120() {
        return minute106to120;
    }

    public void setMinute106to120(CardMinute minute106to120) {
        this.minute106to120 = minute106to120;
    }
}