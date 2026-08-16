package org.footballapp.service;

import org.footballapp.model.standings.LeagueTableFormat;
import org.springframework.stereotype.Service;

@Service
public class LeagueTableFormatResolver {

    public LeagueTableFormat resolve(
            int leagueId,
            int season
    ) {

        /*
         * Temporary format configuration.
         *
         * These are presentation rules, not API rules.
         */

        return switch (leagueId) {

            // FAW Championship
            case 111 ->
                    LeagueTableFormat.GROUPED_TABLE;

            // Cymru Premier
            case 110 ->
                    LeagueTableFormat.SINGLE_TABLE;

            // Scottish Premiership
            case 179 ->
                    LeagueTableFormat.SINGLE_TABLE;

            default ->
                    LeagueTableFormat.SINGLE_TABLE;
        };
    }
}