package org.footballapp.controller.snapshot;

import org.footballapp.service.snapshot.JsonSnapshotService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
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

    @GetMapping("/snapshot/teamFixtures/{teamId}/{last}")
    public String saveTeamFixtures(
            @PathVariable int teamId,
            @PathVariable int last
    ) throws Exception {

        snapshotService.saveTeamFixtures(teamId, last);

        return "Last "
                + last
                + " fixtures snapshot created for team "
                + teamId + ".";
    }

    @GetMapping("/snapshot/players/{teamId}/{season}")
    public String savePlayers(
            @PathVariable int teamId,
            @PathVariable int season
    ) throws Exception {

        snapshotService.savePlayers(teamId, season);

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

        snapshotService.saveStatistics(
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
}