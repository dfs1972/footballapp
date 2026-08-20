package org.footballapp.controller;

import org.footballapp.model.country.CountryApiResponse;
import org.footballapp.service.CountryDataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {

    private final CountryDataService countryDataService;

    public CountryController(
            CountryDataService countryDataService) {

        this.countryDataService = countryDataService;

    }

    @GetMapping("/countries")
    public List<CountryApiResponse> getCountries()
            throws Exception {

        return countryDataService.getCountries();
    }
}
