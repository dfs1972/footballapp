package org.footballapp.controller;


import org.footballapp.config.AppConfig;
import org.footballapp.model.playerdetails.PlayerDetails;
import org.footballapp.service.LeagueDataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {

    private final LeagueDataService
            leagueDataService;

    public PlayerController() {

        AppConfig config =
                new AppConfig();

        leagueDataService =
                config.getLeagueDataService();
    }

    @GetMapping("/teamPlayers")
    public Object getPlayersForTeam(

            @RequestParam int teamId,

            @RequestParam int leagueId,

            @RequestParam int season

    ) throws Exception {

        return leagueDataService
                .getPlayersForTeam(
                        teamId,
                        leagueId,
                        season
                );
    }

    /**
     * Returns detailed information for a player.
     */
    @GetMapping("/playerDetails")
    public PlayerDetails getPlayerDetails(

            @RequestParam int playerId,

            @RequestParam int leagueId,

            @RequestParam int season

    ) throws Exception {

        return leagueDataService.getPlayerDetails(
                playerId,
                leagueId,
                season
        );
    }
}