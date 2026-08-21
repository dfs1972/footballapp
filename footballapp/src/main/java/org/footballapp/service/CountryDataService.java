package org.footballapp.service;

import org.footballapp.model.country.CountryApiResponse;
import org.footballapp.model.country.CountriesApiResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryDataService {

    private final FootballDataProvider footballDataProvider;

    public CountryDataService(
            FootballDataProvider footballDataProvider
    ) {
        this.footballDataProvider =
                footballDataProvider;
    }

    public List<CountryApiResponse> getCountries()
            throws Exception {

        CountriesApiResponse response =
                footballDataProvider.getCountries();

        if (response == null
                || response.getResponse() == null) {

            return List.of();
        }

        return response.getResponse()
                .stream()
                .map(this::mapCountry)
                .toList();
    }

    private CountryApiResponse mapCountry(
            CountryApiResponse country
    ) {

        if (country == null) {
            return null;
        }

        String code = country.getCode();

        /*
         * Keep the API data if the country has no code.
         * We already know API-Football can return missing
         * code/flag values.
         */
        if (code == null || code.isBlank()) {
            country.setFlag(null);
            return country;
        }

        country.setFlag(
                "/images/flags/"
                        + code.toLowerCase()
        );

        return country;
    }
}