package org.footballapp.controller.snapshot;

import org.footballapp.service.snapshot.JsonSnapshotService;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile("live")
public class SnapshotController {

    private final JsonSnapshotService snapshotService;

    public SnapshotController(
            JsonSnapshotService snapshotService
    ) {
        this.snapshotService = snapshotService;
    }

    @GetMapping("/snapshot/league/{leagueId}")
    public String saveLeague(
            @PathVariable int leagueId
    ) throws Exception {

        snapshotService.saveLeague(leagueId);

        return "League " + leagueId + " snapshot created.";
    }

    @GetMapping("/snapshot/standings/{leagueId}/{season}")
    public String saveStandings(
            @PathVariable int leagueId,
            @PathVariable int season
    ) throws Exception {

        snapshotService.saveStandings(leagueId, season);

        return "Standings snapshot created for league "
                + leagueId
                + " season "
                + season + ".";
    }


    /*********************************************************************
     *
     * TEAMS SECTION
     *
     * *******************************************************************
     */

    @GetMapping("/snapshot/teams/{leagueId}/{season}")
    public String saveTeams(
            @PathVariable int leagueId,
            @PathVariable int season
    ) throws Exception {

        snapshotService.saveTeams(leagueId, season);

        return "Teams snapshot created for league "
                + leagueId
                + " season "
                + season + ".";
    }

    @GetMapping("/snapshot/team/{teamId}")
    public String saveTeam(
            @PathVariable int teamId
    ) throws Exception {

        snapshotService.saveTeam(teamId);

        return "Team " + teamId + " snapshot created.";
    }


    /*********************************************************************
     *
     * FIXTURES SECTION
     *
     * *******************************************************************
     */

    @GetMapping("/snapshot/fixtures/{leagueId}/{season}")
    public String saveFixtures(
            @PathVariable int leagueId,
            @PathVariable int season
    ) throws Exception {

        snapshotService.saveFixtures(leagueId, season);

        return "Fixtures snapshot created for league "
                + leagueId
                + " season "
                + season + ".";
    }

    @GetMapping("/snapshot/fixture/{fixtureId}")
    public String saveFixture(
            @PathVariable long fixtureId
    ) throws Exception {

        snapshotService.saveFixture(fixtureId);

        return "Fixture " + fixtureId + " snapshot created.";
    }

    @GetMapping("/snapshot/teamFixtures/{teamId}/{leagueId}/{season}")
    public String saveTeamFixtures(
            @PathVariable int teamId,
            @PathVariable int leagueId,
            @PathVariable int season
    ) throws Exception {

        snapshotService.saveTeamFixtures(
                teamId,
                leagueId,
                season
        );

        return "Team fixtures snapshot created for team "
                + teamId
                + ", league "
                + leagueId
                + ", season "
                + season
                + ".";
    }

    @GetMapping("/snapshot/fixtureEvents/{fixtureId}")
    public String saveFixtureEvents(
            @PathVariable long fixtureId
    ) throws Exception {

        snapshotService.saveFixtureEvents(fixtureId);

        return "Fixture events snapshot created for fixture "
                + fixtureId
                + ".";
    }

    @GetMapping("/snapshot/fixtureLineups/{fixtureId}")
    public String saveFixtureLineups(
            @PathVariable long fixtureId
    ) throws Exception {

        snapshotService.saveFixtureLineups(fixtureId);

        return "Fixture lineups snapshot created for fixture "
                + fixtureId
                + ".";
    }

    @GetMapping("/snapshot/fixtureStatistics/{fixtureId}")
    public String saveFixtureStatistics(
            @PathVariable long fixtureId
    ) throws Exception {

        snapshotService.saveFixtureStatistics(fixtureId);

        return "Fixture statistics snapshot created for fixture "
                + fixtureId
                + ".";
    }

    /*********************************************************************
     *
     * PLAYERS SECTION
     *
     * *******************************************************************
     */

    @GetMapping("/snapshot/players/{teamId}/{season}")
    public String saveTeamPlayers(
            @PathVariable int teamId,
            @PathVariable int season
    ) throws Exception {

        snapshotService.saveTeamPlayers(teamId, season);

        return "Players snapshot created for team "
                + teamId
                + " season "
                + season + ".";
    }

    @GetMapping("/snapshot/player/{playerId}/{season}")
    public String savePlayer(
            @PathVariable int playerId,
            @PathVariable int season
    ) throws Exception {

        snapshotService.savePlayer(playerId, season);

        return "Player "
                + playerId
                + " snapshot created for season "
                + season + ".";
    }

    @GetMapping("/snapshot/statistics/{teamId}/{leagueId}/{season}")
    public String saveStatistics(
            @PathVariable int teamId,
            @PathVariable int leagueId,
            @PathVariable int season
    ) throws Exception {

        snapshotService.saveTeamStatistics(
                teamId,
                leagueId,
                season
        );

        return "Statistics snapshot created for team "
                + teamId
                + ", league "
                + leagueId
                + ", season "
                + season + ".";
    }


    /*********************************************************************
     *
     * PACKAGES
     *
     * *******************************************************************
     */


    /**
     * Save complete league package
     */

    @GetMapping("/snapshot/completeLeaguePackage/{leagueId}/{season}")
    public String saveCompleteLeaguePackage(
            @PathVariable int leagueId,
            @PathVariable int season
    ) throws Exception {

        snapshotService.saveCompleteLeaguePackage(
                leagueId,
                season
        );

        return "Complete league package created for league "
                + leagueId
                + ", season "
                + season
                + ".";
    }

    /**
     * Save league package
     */

    @GetMapping("/snapshot/leaguePackage/{leagueId}/{season}")
    public String saveLeaguePackage(
            @PathVariable int leagueId,
            @PathVariable int season
    ) throws Exception {

        snapshotService.saveLeaguePackage(
                leagueId,
                season
        );

        return "League package created for league "
                + leagueId
                + ", season "
                + season + ".";

    }

    /**
     * Save Supported League Package
     */

    @GetMapping("/snapshot/supportedLeaguePackages")
    public String saveSupportedLeaguePackages() throws Exception {

        snapshotService.saveSupportedLeaguePackages();

        return "Supported league packages created.";
    }

    /**
     * Save Team package
     */

    @GetMapping("/snapshot/teamPackage/{teamId}/{leagueId}/{season}")
    public String saveTeamPackage(
            @PathVariable int teamId,
            @PathVariable int leagueId,
            @PathVariable int season
    ) throws Exception {

        snapshotService.saveTeamPackage(
                teamId,
                leagueId,
                season
        );

        return "Team package created for team "
                + teamId
                + ", league "
                + leagueId
                + ", season "
                + season + ".";
    }

    /**
     * Save Fixture package
     */

    @GetMapping("/snapshot/fixturePackage/{fixtureId}")
    public String saveFixturePackage(
            @PathVariable long fixtureId
    ) throws Exception {

        snapshotService.saveFixturePackage(fixtureId);

        return "Fixture package created for fixture "
                + fixtureId
                + ".";
    }

    /******************************************
     *
     * TEMP PLAYER PACKAGE
     *
     * ****************************************
     * */

    @GetMapping("/snapshot/playerPackage/{playerId}/{season}")
    public String savePlayerPackage(
            @PathVariable int playerId,
            @PathVariable int season
    ) throws Exception {

        snapshotService.savePlayerPackage(
                playerId,
                season
        );

        return "Player package created "
                + playerId
                + ", season "
                + season + ".";

    }

}


