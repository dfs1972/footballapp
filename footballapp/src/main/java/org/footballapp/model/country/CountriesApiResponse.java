package org.footballapp.model.country;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CountriesApiResponse {

    private List<CountryApiResponse> response;

    public List<CountryApiResponse> getResponse() {
        return response;
    }

    public void setResponse(
            List<CountryApiResponse> response
    ) {
        this.response = response;
    }
}