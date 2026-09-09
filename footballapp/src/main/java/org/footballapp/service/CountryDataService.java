package org.footballapp.service;

import org.footballapp.model.country.CountryApiResponse;
import org.footballapp.model.country.CountriesApiResponse;
import org.footballapp.config.competitions.SupportedCompetitionGroup;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CountryDataService {

    private final FootballDataProvider footballDataProvider;
    private final SupportedCompetitionsService supportedCompetitionsService;

    public CountryDataService(
            FootballDataProvider footballDataProvider,
            SupportedCompetitionsService supportedCompetitionsService
    ) {
        this.footballDataProvider =
                footballDataProvider;
        this.supportedCompetitionsService =
                supportedCompetitionsService;
    }

    public List<CountryApiResponse> getCountries()
            throws Exception {

        CountriesApiResponse response =
                footballDataProvider.getCountries();

        if (response == null
                || response.getResponse() == null) {

            return List.of();
        }

        Set<String> supportedCountries = supportedCompetitionsService
                .getCompetitionGroups()
                .stream()
                .map(SupportedCompetitionGroup::getCountry)
                .map(String::toLowerCase)
                .collect(Collectors.toSet());

        return response.getResponse()
                .stream()
                .filter(country -> supportedCountries.contains(country.getName().toLowerCase()))
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