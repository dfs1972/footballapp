package org.footballapp.model.league;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LeagueApiResponse {

    private LeagueApiInfo league;
    private CountryInfo country;

    public LeagueApiInfo getLeague() {
        return league;
    }

    public void setLeague(
            LeagueApiInfo league
    ) {
        this.league = league;
    }

    public CountryInfo getCountry() {
        return country;
    }

    public void setCountry(
            CountryInfo country
    ) {
        this.country = country;
    }
}