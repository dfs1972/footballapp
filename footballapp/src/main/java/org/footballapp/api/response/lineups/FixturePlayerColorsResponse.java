package org.footballapp.api.response.lineups;

public class FixturePlayerColorsResponse {

    private String primary;

    private String number;

    private String border;


    public String getPrimary() {
        return primary;
    }

    public void setPrimary(
            String primary
    ) {
        this.primary = primary;
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(
            String number
    ) {
        this.number = number;
    }


    public String getBorder() {
        return border;
    }

    public void setBorder(
            String border
    ) {
        this.border = border;
    }

}