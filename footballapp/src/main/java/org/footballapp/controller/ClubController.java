package org.footballapp.controller;

import org.footballapp.model.club.ClubDetails;
import org.footballapp.service.LeagueDataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST endpoints for club information.
 */
@RestController
public class ClubController {

    private final LeagueDataService leagueDataService;

    public ClubController(
            LeagueDataService leagueDataService
    ) {
        this.leagueDataService = leagueDataService;
    }

    /**
     * Returns details for a single club.
     */
    @GetMapping("/club")
    public ClubDetails getClub(

            @RequestParam int clubId

    ) throws Exception {

        return leagueDataService.getClubDetails(
                clubId
        );

    }

}