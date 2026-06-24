package org.footballapp.service;

import org.footballapp.api.ApiFootballService;
import org.footballapp.databaserepository.LeagueUkRepository;
import org.footballapp.model.league.LeagueApiResponse;
import org.footballapp.model.league.LeagueUk;
import org.footballapp.model.league.LeaguesApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LeagueUkImportService {

    private final ApiFootballService apiFootballService;
    private final LeagueUkRepository leagueUkRepository;

    public LeagueUkImportService(
            ApiFootballService apiFootballService,
            LeagueUkRepository leagueUkRepository
    ) {
        this.apiFootballService =
                apiFootballService;

        this.leagueUkRepository =
                leagueUkRepository;
    }



    public void importUkLeagues()
            throws Exception {

        LeaguesApiResponse response =
                apiFootballService.getLeagues();

        int importedCount = 0;

        for (LeagueApiResponse item :
                response.getResponse()) {

            String country =
                    item.getCountry()
                            .getName();

            if (!isUkCountry(country)) {
                continue;
            }

            LeagueUk league =
                    new LeagueUk();

            league.setLeagueId(
                    item.getLeague()
                            .getId()
            );

            league.setName(
                    item.getLeague()
                            .getName()
            );

            league.setCountry(
                    country
            );

            league.setLogoUrl(
                    item.getLeague()
                            .getLogo()
            );

            leagueUkRepository.saveLeague(
                    league
            );

            importedCount++;
            logger.info(
                    "Imported {} leagues",
                    importedCount
            );
        }
    }

    private static final Logger logger =
            LoggerFactory.getLogger(
                    LeagueUkImportService.class
            );


    private boolean isUkCountry(
            String country
    ) {

        return country.equals(
                "England"
        )
                || country.equals(
                "Scotland"
        )
                || country.equals(
                "Wales"
        )
                || country.equals(
                "Northern Ireland"
        );
    }
}