This file is a merged representation of a subset of the codebase, containing specifically included files, combined into a single document by Repomix.

# File Summary

## Purpose
This file contains a packed representation of a subset of the repository's contents that is considered the most important context.
It is designed to be easily consumable by AI systems for analysis, code review,
or other automated processes.

## File Format
The content is organized as follows:
1. This summary section
2. Repository information
3. Directory structure
4. Repository files (if enabled)
5. Multiple file entries, each consisting of:
  a. A header with the file path (## File: path/to/file)
  b. The full contents of the file in a code block

## Usage Guidelines
- This file should be treated as read-only. Any changes should be made to the
  original repository files, not this packed version.
- When processing this file, use the file path to distinguish
  between different files in the repository.
- Be aware that this file may contain sensitive information. Handle it with
  the same level of security as you would the original repository.

## Notes
- Some files may have been excluded based on .gitignore rules and Repomix's configuration
- Binary files are not included in this packed representation. Please refer to the Repository Structure section for a complete list of file paths, including binary files
- Only files matching these patterns are included: footballapp/src/main/java/org/footballapp/model/**/*.java
- Files matching patterns in .gitignore are excluded
- Files matching default ignore patterns are excluded
- Files are sorted by Git change count (files with more changes are at the bottom)

# Directory Structure
```
footballapp/src/main/java/org/footballapp/model/club/ClubDetails.java
footballapp/src/main/java/org/footballapp/model/fixtures/Fixture.java
footballapp/src/main/java/org/footballapp/model/fixtures/FixtureDetails.java
footballapp/src/main/java/org/footballapp/model/fixtures/FixtureEvent.java
footballapp/src/main/java/org/footballapp/model/fixtures/FixtureGoals.java
footballapp/src/main/java/org/footballapp/model/fixtures/FixtureLeague.java
footballapp/src/main/java/org/footballapp/model/fixtures/FixtureResponse.java
footballapp/src/main/java/org/footballapp/model/fixtures/FixtureRow.java
footballapp/src/main/java/org/footballapp/model/fixtures/FixturesApiResponse.java
footballapp/src/main/java/org/footballapp/model/fixtures/FixtureStatistic.java
footballapp/src/main/java/org/footballapp/model/fixtures/FixtureTeam.java
footballapp/src/main/java/org/footballapp/model/fixtures/FixtureTeams.java
footballapp/src/main/java/org/footballapp/model/fixtures/FixtureVenue.java
footballapp/src/main/java/org/footballapp/model/league/CountryInfo.java
footballapp/src/main/java/org/footballapp/model/league/League.java
footballapp/src/main/java/org/footballapp/model/league/LeagueApiInfo.java
footballapp/src/main/java/org/footballapp/model/league/LeagueApiResponse.java
footballapp/src/main/java/org/footballapp/model/league/LeagueOverview.java
footballapp/src/main/java/org/footballapp/model/league/LeagueResponse.java
footballapp/src/main/java/org/footballapp/model/league/LeaguesApiResponse.java
footballapp/src/main/java/org/footballapp/model/league/LeagueTeam.java
footballapp/src/main/java/org/footballapp/model/league/LeagueUk.java
footballapp/src/main/java/org/footballapp/model/lineups/FixtureLineup.java
footballapp/src/main/java/org/footballapp/model/lineups/FixtureLineupPlayer.java
footballapp/src/main/java/org/footballapp/model/player/Paging.java
footballapp/src/main/java/org/footballapp/model/player/Player.java
footballapp/src/main/java/org/footballapp/model/player/PlayerBirth.java
footballapp/src/main/java/org/footballapp/model/player/PlayerResponse.java
footballapp/src/main/java/org/footballapp/model/player/PlayersApiResponse.java
footballapp/src/main/java/org/footballapp/model/playerdetails/PlayerDetails.java
footballapp/src/main/java/org/footballapp/model/playerdetails/PlayerSummary.java
footballapp/src/main/java/org/footballapp/model/playerstatistics/PlayerCards.java
footballapp/src/main/java/org/footballapp/model/playerstatistics/PlayerGames.java
footballapp/src/main/java/org/footballapp/model/playerstatistics/PlayerGoals.java
footballapp/src/main/java/org/footballapp/model/playerstatistics/PlayerLeague.java
footballapp/src/main/java/org/footballapp/model/playerstatistics/PlayerStatistics.java
footballapp/src/main/java/org/footballapp/model/playerstatistics/PlayerTeam.java
footballapp/src/main/java/org/footballapp/model/standings/LeagueTableRow.java
footballapp/src/main/java/org/footballapp/model/standings/Standing.java
footballapp/src/main/java/org/footballapp/model/standings/StandingAll.java
footballapp/src/main/java/org/footballapp/model/standings/StandingGoals.java
footballapp/src/main/java/org/footballapp/model/standings/StandingLeague.java
footballapp/src/main/java/org/footballapp/model/standings/StandingRecord.java
footballapp/src/main/java/org/footballapp/model/standings/StandingsApiResponse.java
footballapp/src/main/java/org/footballapp/model/standings/StandingsResponse.java
footballapp/src/main/java/org/footballapp/model/standings/StandingTeam.java
footballapp/src/main/java/org/footballapp/model/teamdetails/TeamDetails.java
footballapp/src/main/java/org/footballapp/model/teams/ID.java
footballapp/src/main/java/org/footballapp/model/teams/Team.java
footballapp/src/main/java/org/footballapp/model/teams/TeamResponse.java
footballapp/src/main/java/org/footballapp/model/teams/TeamsApiResponse.java
footballapp/src/main/java/org/footballapp/model/teams/Venue.java
footballapp/src/main/java/org/footballapp/model/teamstatistics/CardColour.java
footballapp/src/main/java/org/footballapp/model/teamstatistics/CardMinute.java
footballapp/src/main/java/org/footballapp/model/teamstatistics/Cards.java
footballapp/src/main/java/org/footballapp/model/teamstatistics/CleanSheet.java
footballapp/src/main/java/org/footballapp/model/teamstatistics/FailedToScore.java
footballapp/src/main/java/org/footballapp/model/teamstatistics/Fixtures.java
footballapp/src/main/java/org/footballapp/model/teamstatistics/FixturesTotals.java
footballapp/src/main/java/org/footballapp/model/teamstatistics/Goals.java
footballapp/src/main/java/org/footballapp/model/teamstatistics/GoalsTotals.java
footballapp/src/main/java/org/footballapp/model/teamstatistics/League.java
footballapp/src/main/java/org/footballapp/model/teamstatistics/Team.java
footballapp/src/main/java/org/footballapp/model/teamstatistics/TeamStatistics.java
footballapp/src/main/java/org/footballapp/model/teamstatistics/TeamStatisticsApiResponse.java
footballapp/src/main/java/org/footballapp/model/teamstatistics/TeamStatisticsResponse.java
```

# Files

## File: footballapp/src/main/java/org/footballapp/model/club/ClubDetails.java
```java
package org.footballapp.model.club;

public class ClubDetails {

    private int clubId;
    private String name;
    private String country;
    private int founded;

    private String stadium;
    private String city;
    private int capacity;

    public int getClubId() {
        return clubId;
    }

    public void setClubId(int clubId) {
        this.clubId = clubId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getFounded() {
        return founded;
    }

    public void setFounded(int founded) {
        this.founded = founded;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

}
```

## File: footballapp/src/main/java/org/footballapp/model/fixtures/Fixture.java
```java
package org.footballapp.model.fixtures;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Fixture {

    private long id;
    private String date;
    private FixtureVenue venue;

    public Fixture() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public FixtureVenue getVenue() {
        return venue;
    }

    public void setVenue(FixtureVenue venue) {
        this.venue = venue;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/fixtures/FixtureDetails.java
```java
package org.footballapp.model.fixtures;

public class FixtureDetails {

    private long fixtureId;

    private String fixtureDate;

    private int homeTeamId;
    private String homeTeam;

    private int awayTeamId;
    private String awayTeam;

    private Integer homeGoals;
    private Integer awayGoals;

    private String venueName;

    private int leagueId;
    private String leagueName;

    private int season;


    /**
     * Fixture Details Getters.
     */

    public long getFixtureId() {
        return fixtureId;
    }

    public String getFixtureDate() {
        return fixtureDate;
    }

    public int getHomeTeamId() {
        return homeTeamId;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public int getAwayTeamId() {
        return awayTeamId;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public Integer getHomeGoals() {
        return homeGoals;
    }

    public Integer getAwayGoals() {
        return awayGoals;
    }

    public String getVenueName() {
        return venueName;
    }

    public int getLeagueId() {
        return leagueId;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public int getSeason() {
        return season;
    }

    public String getRound() {
        return round;
    }

    private String round;

    /**
     * Fixture Details Setters
     */

    public void setFixtureId(long fixtureId) {
        this.fixtureId = fixtureId;
    }

    public void setFixtureDate(String fixtureDate) {
        this.fixtureDate = fixtureDate;
    }

    public void setHomeTeamId(int homeTeamId) {
        this.homeTeamId = homeTeamId;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public void setAwayTeamId(int awayTeamId) {
        this.awayTeamId = awayTeamId;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public void setHomeGoals(Integer homeGoals) {
        this.homeGoals = homeGoals;
    }

    public void setAwayGoals(Integer awayGoals) {
        this.awayGoals = awayGoals;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public void setRound(String round) {
        this.round = round;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/fixtures/FixtureEvent.java
```java
package org.footballapp.model.fixtures;

public class FixtureEvent {

    private int id;

    private long fixtureId;

    private Integer elapsed;

    private Integer extraTime;

    private int teamId;

    private Integer playerId;

    private Integer assistPlayerId;

    private String eventType;

    private String eventDetail;

    private String comments;

    public FixtureEvent() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getFixtureId() {
        return fixtureId;
    }

    public void setFixtureId(long fixtureId) {
        this.fixtureId = fixtureId;
    }

    public Integer getElapsed() {
        return elapsed;
    }

    public void setElapsed(Integer elapsed) {
        this.elapsed = elapsed;
    }

    public Integer getExtraTime() {
        return extraTime;
    }

    public void setExtraTime(Integer extraTime) {
        this.extraTime = extraTime;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public Integer getAssistPlayerId() {
        return assistPlayerId;
    }

    public void setAssistPlayerId(Integer assistPlayerId) {
        this.assistPlayerId = assistPlayerId;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventDetail() {
        return eventDetail;
    }

    public void setEventDetail(String eventDetail) {
        this.eventDetail = eventDetail;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/fixtures/FixtureGoals.java
```java
package org.footballapp.model.fixtures;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FixtureGoals {

    private Integer home;
    private Integer away;

    public FixtureGoals() {
    }

    /**Getters and Setters*/
    public Integer getHome() {
        return home;
    }

    public void setHome(Integer home) {
        this.home = home;
    }

    public Integer getAway() {
        return away;
    }

    public void setAway(Integer away) {
        this.away = away;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/fixtures/FixtureLeague.java
```java
package org.footballapp.model.fixtures;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FixtureLeague {
    private int id;
    private int season;
    private String round;

    public FixtureLeague() {
    }

    /** Getters and Setters*/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/fixtures/FixtureResponse.java
```java
package org.footballapp.model.fixtures;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FixtureResponse {

    private Fixture fixture;
    private FixtureLeague league;
    private FixtureTeams teams;
    private FixtureGoals goals;

    public FixtureResponse() {
    }

    public Fixture getFixture() {
        return fixture;
    }

    public void setFixture(Fixture fixture) {
        this.fixture = fixture;
    }

    public FixtureLeague getLeague() {
        return league;
    }

    public void setLeague(FixtureLeague league) {
        this.league = league;
    }

    public FixtureTeams getTeams() {
        return teams;
    }

    public void setTeams(FixtureTeams teams) {
        this.teams = teams;
    }

    public FixtureGoals getGoals() {
        return goals;
    }

    public void setGoals(FixtureGoals goals) {
        this.goals = goals;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/fixtures/FixtureRow.java
```java
package org.footballapp.model.fixtures;

public class FixtureRow {

    private long fixtureId;
    private String fixtureDate;
    private String fixtureTime;
    private int homeTeamId;
    private int awayTeamId;
    private String homeTeam;
    private String awayTeam;
    private int homeGoals;
    private int awayGoals;
    //private String round;

    /**Getters and Setters*/
    public long getFixtureId() {return fixtureId;}

    public void setFixtureId(long fixtureId) {this.fixtureId = fixtureId;}

    public String getFixtureDate() {return fixtureDate;}

    public void setFixtureDate(String fixtureDate) {
        this.fixtureDate = fixtureDate;
    }

    public String getFixtureTime() {return fixtureTime;}
    public void setFixtureTime(String fixtureTime) {this.fixtureTime = fixtureTime;}

    public int getHomeTeamId() {return homeTeamId;}

    public void setHomeTeamId(int homeTeamId) {this.homeTeamId = homeTeamId;}

    public int getAwayTeamId() {return awayTeamId;}

    public void setAwayTeamId(int awayTeamId) {this.awayTeamId = awayTeamId;}

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public int getHomeGoals() {
        return homeGoals;
    }

    public void setHomeGoals(int homeGoals) {
        this.homeGoals = homeGoals;
    }

    public int getAwayGoals() {
        return awayGoals;
    }

    public void setAwayGoals(int awayGoals) {
        this.awayGoals = awayGoals;
    }

//    public String getRound() {
//        return round;
//    }
//
//    public void setRound(String round) {
//        this.round = round;
//    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/fixtures/FixturesApiResponse.java
```java
package org.footballapp.model.fixtures;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FixturesApiResponse {

    private List<FixtureResponse> response;

    public FixturesApiResponse() {
    }

    public List<FixtureResponse> getResponse() {
        return response;
    }

    public void setResponse(List<FixtureResponse> response) {
        this.response = response;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/fixtures/FixtureStatistic.java
```java
package org.footballapp.model.fixtures;

import java.math.BigDecimal;

public class FixtureStatistic {

    private long fixtureId;
    private int teamId;

    private Integer shotsOnGoal;
    private Integer shotsOffGoal;
    private Integer totalShots;
    private Integer blockedShots;
    private Integer shotsInsideBox;
    private Integer shotsOutsideBox;
    private Integer fouls;
    private Integer cornerKicks;
    private Integer offsides;
    private String ballPossession;
    private Integer yellowCards;
    private Integer redCards;
    private Integer goalkeeperSaves;
    private Integer totalPasses;
    private Integer accuratePasses;
    private String passPercentage;
    private BigDecimal expectedGoals;
    private BigDecimal goalsPrevented;

    public FixtureStatistic() {
    }

    public long getFixtureId() {
        return fixtureId;
    }

    public void setFixtureId(long fixtureId) {
        this.fixtureId = fixtureId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public Integer getShotsOnGoal() {
        return shotsOnGoal;
    }

    public void setShotsOnGoal(Integer shotsOnGoal) {
        this.shotsOnGoal = shotsOnGoal;
    }

    public Integer getShotsOffGoal() {
        return shotsOffGoal;
    }

    public void setShotsOffGoal(Integer shotsOffGoal) {
        this.shotsOffGoal = shotsOffGoal;
    }

    public Integer getTotalShots() {
        return totalShots;
    }

    public void setTotalShots(Integer totalShots) {
        this.totalShots = totalShots;
    }

    public Integer getBlockedShots() {
        return blockedShots;
    }

    public void setBlockedShots(Integer blockedShots) {
        this.blockedShots = blockedShots;
    }

    public Integer getShotsInsideBox() {
        return shotsInsideBox;
    }

    public void setShotsInsideBox(Integer shotsInsideBox) {
        this.shotsInsideBox = shotsInsideBox;
    }

    public Integer getShotsOutsideBox() {
        return shotsOutsideBox;
    }

    public void setShotsOutsideBox(Integer shotsOutsideBox) {
        this.shotsOutsideBox = shotsOutsideBox;
    }

    public Integer getFouls() {
        return fouls;
    }

    public void setFouls(Integer fouls) {
        this.fouls = fouls;
    }

    public Integer getCornerKicks() {
        return cornerKicks;
    }

    public void setCornerKicks(Integer cornerKicks) {
        this.cornerKicks = cornerKicks;
    }

    public Integer getOffsides() {
        return offsides;
    }

    public void setOffsides(Integer offsides) {
        this.offsides = offsides;
    }

    public String getBallPossession() {
        return ballPossession;
    }

    public void setBallPossession(String ballPossession) {
        this.ballPossession = ballPossession;
    }

    public Integer getYellowCards() {
        return yellowCards;
    }

    public void setYellowCards(Integer yellowCards) {
        this.yellowCards = yellowCards;
    }

    public Integer getRedCards() {
        return redCards;
    }

    public void setRedCards(Integer redCards) {
        this.redCards = redCards;
    }

    public Integer getGoalkeeperSaves() {
        return goalkeeperSaves;
    }

    public void setGoalkeeperSaves(Integer goalkeeperSaves) {
        this.goalkeeperSaves = goalkeeperSaves;
    }

    public Integer getTotalPasses() {
        return totalPasses;
    }

    public void setTotalPasses(Integer totalPasses) {
        this.totalPasses = totalPasses;
    }

    public Integer getAccuratePasses() {
        return accuratePasses;
    }

    public void setAccuratePasses(Integer accuratePasses) {
        this.accuratePasses = accuratePasses;
    }

    public String getPassPercentage() {
        return passPercentage;
    }

    public void setPassPercentage(String passPercentage) {
        this.passPercentage = passPercentage;
    }

    public BigDecimal getExpectedGoals() {
        return expectedGoals;
    }

    public void setExpectedGoals(BigDecimal expectedGoals) {
        this.expectedGoals = expectedGoals;
    }

    public BigDecimal getGoalsPrevented() {
        return goalsPrevented;
    }

    public void setGoalsPrevented(BigDecimal goalsPrevented) {
        this.goalsPrevented = goalsPrevented;
    }

}
```

## File: footballapp/src/main/java/org/footballapp/model/fixtures/FixtureTeam.java
```java
package org.footballapp.model.fixtures;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FixtureTeam {
    private int id;
    private String name;

    public FixtureTeam() {

    }

    /**Getters and Setters*/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/fixtures/FixtureTeams.java
```java
package org.footballapp.model.fixtures;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FixtureTeams {

    private FixtureTeam home;
    private FixtureTeam away;

    public FixtureTeam getHome() {
        return home;
    }

    public void setHome(FixtureTeam home) {
        this.home = home;
    }

    /**Getters and Setters*/
    public FixtureTeam getAway() {
        return away;
    }

    public void setAway(FixtureTeam away) {
        this.away = away;
    }

    public FixtureTeams() {
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/fixtures/FixtureVenue.java
```java
package org.footballapp.model.fixtures;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FixtureVenue {

    private int id;
    private String name;
    private String city;

    public FixtureVenue() {
    }

    /**Getters and Setters*/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/league/CountryInfo.java
```java
package org.footballapp.model.league;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryInfo {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/league/League.java
```java
package org.footballapp.model.league;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Represents a football league & season returned by API-Football.
 *
 * Mapped from the JSON "team" object.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class League {

    private int id;
    private String name;
    private String country;
    private int season;

    public League() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/league/LeagueApiInfo.java
```java
package org.footballapp.model.league;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LeagueApiInfo {

    private int id;
    private String name;
    private String logo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/league/LeagueApiResponse.java
```java
package org.footballapp.model.league;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LeagueApiResponse {

    private LeagueApiInfo league;
    private CountryInfo country;

    public LeagueApiInfo getLeague() {
        return league;
    }

    public void setLeague(
            LeagueApiInfo league
    ) {
        this.league = league;
    }

    public CountryInfo getCountry() {
        return country;
    }

    public void setCountry(
            CountryInfo country
    ) {
        this.country = country;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/league/LeagueOverview.java
```java
package org.footballapp.model.league;

public class LeagueOverview {

    private int leagueId;
    private String leagueName;
    private int season;
    private int teamCount;
    private int fixtureCount;

    public int getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public int getTeamCount() {
        return teamCount;
    }

    public void setTeamCount(int teamCount) {
        this.teamCount = teamCount;
    }

    public int getFixtureCount() {
        return fixtureCount;
    }

    public void setFixtureCount(int fixtureCount) {
        this.fixtureCount = fixtureCount;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/league/LeagueResponse.java
```java
package org.footballapp.model.league;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Represents a single entry within the API-Football
 * response array.
 *
 * Each response contains:
 * - League information
 * - Country information
 * - Season information
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LeagueResponse {
    private int id;
    private String name;
    private String country;
    private int season;

    public LeagueResponse() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/league/LeaguesApiResponse.java
```java
package org.footballapp.model.league;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LeaguesApiResponse {

    private List<LeagueApiResponse> response;

    public List<LeagueApiResponse> getResponse() {
        return response;
    }

    public void setResponse(
            List<LeagueApiResponse> response
    ) {
        this.response = response;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/league/LeagueTeam.java
```java
package org.footballapp.model.league;

public class LeagueTeam {

    private int leagueId;
    private int season;
    private int teamId;

    public LeagueTeam() {
    }

    public int getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/league/LeagueUk.java
```java
package org.footballapp.model.league;

public class LeagueUk {

    private int leagueId;
    private String name;
    private String country;
    private String logoUrl;

    public int getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/lineups/FixtureLineup.java
```java
package org.footballapp.model.lineups;

/**
 * Represents a team's lineup for a fixture.
 *
 * One record exists per team per fixture.
 */
public class FixtureLineup {

    private long fixtureId;

    private int teamId;

    private int coachId;

    private String coachName;

    private String formation;

    public FixtureLineup() {
    }

    public FixtureLineup(

            long fixtureId,

            int teamId,

            int coachId,

            String coachName,

            String formation

    ) {

        this.fixtureId = fixtureId;
        this.teamId = teamId;
        this.coachId = coachId;
        this.coachName = coachName;
        this.formation = formation;

    }

    public long getFixtureId() {
        return fixtureId;
    }

    public void setFixtureId(
            long fixtureId
    ) {
        this.fixtureId = fixtureId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(
            int teamId
    ) {
        this.teamId = teamId;
    }

    public int getCoachId() {
        return coachId;
    }

    public void setCoachId(
            int coachId
    ) {
        this.coachId = coachId;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(
            String coachName
    ) {
        this.coachName = coachName;
    }

    public String getFormation() {
        return formation;
    }

    public void setFormation(
            String formation
    ) {
        this.formation = formation;
    }

}
```

## File: footballapp/src/main/java/org/footballapp/model/lineups/FixtureLineupPlayer.java
```java
package org.footballapp.model.lineups;

/**
 * Represents a player in a fixture lineup.
 *
 * One record exists per player per fixture.
 */
public class FixtureLineupPlayer {

    private long fixtureId;

    private int teamId;

    private int playerId;

    private int shirtNumber;

    private String position;

    private String grid;

    private boolean starting;

    private int displayOrder;

    public FixtureLineupPlayer() {
    }

    public FixtureLineupPlayer(

            long fixtureId,

            int teamId,

            int playerId,

            int shirtNumber,

            String position,

            String grid,

            boolean starting,

            int displayOrder

    ) {

        this.fixtureId = fixtureId;
        this.teamId = teamId;
        this.playerId = playerId;
        this.shirtNumber = shirtNumber;
        this.position = position;
        this.grid = grid;
        this.starting = starting;
        this.displayOrder = displayOrder;

    }

    public long getFixtureId() {
        return fixtureId;
    }

    public void setFixtureId(
            long fixtureId
    ) {
        this.fixtureId = fixtureId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(
            int teamId
    ) {
        this.teamId = teamId;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(
            int playerId
    ) {
        this.playerId = playerId;
    }

    public int getShirtNumber() {
        return shirtNumber;
    }

    public void setShirtNumber(
            int shirtNumber
    ) {
        this.shirtNumber = shirtNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(
            String position
    ) {
        this.position = position;
    }

    public String getGrid() {
        return grid;
    }

    public void setGrid(
            String grid
    ) {
        this.grid = grid;
    }

    public boolean isStarting() {
        return starting;
    }

    public void setStarting(
            boolean starting
    ) {
        this.starting = starting;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(
            int displayOrder
    ) {
        this.displayOrder = displayOrder;
    }

}
```

## File: footballapp/src/main/java/org/footballapp/model/player/Paging.java
```java
package org.footballapp.model.player;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Represents API-Football paging information.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Paging {

    private int current;
    private int total;

    public Paging() {
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/player/Player.java
```java
package org.footballapp.model.player;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a football player returned by API-Football.
 *
 * This model contains player identity information only.
 * Season statistics are stored separately.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Player {

    @JsonProperty("id")
    private int playerId;

    private String name;
    private String firstname;
    private String lastname;

    private Integer age;

    private String nationality;

    private String height;
    private String weight;

    private boolean injured;

    @JsonProperty("photo")
    private String photoUrl;

    private PlayerBirth birth;

    public Player() {
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public boolean isInjured() {
        return injured;
    }

    public void setInjured(boolean injured) {
        this.injured = injured;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public PlayerBirth getBirth() {
        return birth;
    }

    public void setBirth(PlayerBirth birth) {
        this.birth = birth;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/player/PlayerBirth.java
```java
package org.footballapp.model.player;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Represents a player's birth information.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerBirth {

    private String date;
    private String place;
    private String country;

    public PlayerBirth() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/player/PlayerResponse.java
```java
package org.footballapp.model.player;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.footballapp.model.playerstatistics.PlayerStatistics;

import java.util.List;

/**
 * Represents a single player returned by API-Football.
 *
 * The API also returns a statistics array, which will
 * be mapped later when player statistics are implemented.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerResponse {

    private Player player;

    private List<PlayerStatistics> statistics;

    public PlayerResponse() {
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<PlayerStatistics> getStatistics() {
        return statistics;
    }

    public void setStatistics(
            List<PlayerStatistics> statistics
    ) {
        this.statistics = statistics;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/player/PlayersApiResponse.java
```java
package org.footballapp.model.player;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Root API-Football response for player requests.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayersApiResponse {

    private Paging paging;

    private List<PlayerResponse> response;

    public PlayersApiResponse() {
    }

    public Paging getPaging() {
        return paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }

    public List<PlayerResponse> getResponse() {
        return response;
    }

    public void setResponse(
            List<PlayerResponse> response
    ) {
        this.response = response;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/playerdetails/PlayerDetails.java
```java
package org.footballapp.model.playerdetails;

import java.sql.Date;

public class PlayerDetails {

    private int playerId;

    private String displayName;

    private String firstName;

    private String lastName;

    private java.sql.Date birthDate;

    private Integer age;

    private String height;

    private String weight;

    private String nationality;

    private String photoUrl;

    private String position;

    private Integer shirtNumber;

    private Boolean captain;

    private Integer starts;

    private Integer appearances;

    private Integer minutes;

    private Integer goals;

    private Integer assists;

    private Integer yellowCards;

    private Integer redCards;

    private Double rating;

    private Integer teamId;

    private String teamName;

    private Integer leagueId;

    private String leagueName;

    private Integer season;

    /**
     * Constructor
     */
    public PlayerDetails() {
    }

    /**
     * getters and Setters
     */
    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getShirtNumber() {
        return shirtNumber;
    }

    public void setShirtNumber(Integer shirtNumber) {
        this.shirtNumber = shirtNumber;
    }

    public Boolean getCaptain() {
        return captain;
    }

    public void setCaptain(Boolean captain) {
        this.captain = captain;
    }

    public Integer getStarts() {
        return starts;
    }

    public void setStarts(Integer starts) {
        this.starts = starts;
    }

    public Integer getAppearances() {
        return appearances;
    }

    public void setAppearances(Integer appearances) {
        this.appearances = appearances;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    public Integer getGoals() {
        return goals;
    }

    public void setGoals(Integer goals) {
        this.goals = goals;
    }

    public Integer getAssists() {
        return assists;
    }

    public void setAssists(Integer assists) {
        this.assists = assists;
    }

    public Integer getYellowCards() {
        return yellowCards;
    }

    public void setYellowCards(Integer yellowCards) {
        this.yellowCards = yellowCards;
    }

    public Integer getRedCards() {
        return redCards;
    }

    public void setRedCards(Integer redCards) {
        this.redCards = redCards;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Integer getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(Integer leagueId) {
        this.leagueId = leagueId;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/playerdetails/PlayerSummary.java
```java
package org.footballapp.model.playerdetails;

/**
 * Summary information about a player for the Team Squad screen.
 */
public class PlayerSummary {

    private int playerId;

    private Integer age;

    private String nationality;

    private String displayName;

    private String photoUrl;

    private String position;

    private Integer shirtNumber;

    private Boolean captain;

    private Integer appearances;

    private Integer goals;

    private Integer assists;

    public PlayerSummary() {
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getShirtNumber() {
        return shirtNumber;
    }

    public void setShirtNumber(Integer shirtNumber) {
        this.shirtNumber = shirtNumber;
    }

    public Boolean getCaptain() {
        return captain;
    }

    public void setCaptain(Boolean captain) {
        this.captain = captain;
    }

    public Integer getAppearances() {
        return appearances;
    }

    public void setAppearances(Integer appearances) {
        this.appearances = appearances;
    }

    public Integer getGoals() {
        return goals;
    }

    public void setGoals(Integer goals) {
        this.goals = goals;
    }

    public Integer getAssists() {
        return assists;
    }

    public void setAssists(Integer assists) {
        this.assists = assists;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/playerstatistics/PlayerCards.java
```java
package org.footballapp.model.playerstatistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerCards {

    private Integer yellow;
    private Integer red;

    public PlayerCards() {
    }

    public Integer getYellow() {
        return yellow;
    }

    public void setYellow(Integer yellow) {
        this.yellow = yellow;
    }

    public Integer getRed() {
        return red;
    }

    public void setRed(Integer red) {
        this.red = red;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/playerstatistics/PlayerGames.java
```java
package org.footballapp.model.playerstatistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerGames {

    @JsonProperty("appearences")
    private Integer appearances;
    private Integer lineups;
    private Integer minutes;

    private String position;

    private Integer number;

    private Boolean captain;

    private String rating;

    public PlayerGames() {
    }

    public Integer getAppearances() {
        return appearances;
    }

    public void setAppearances(Integer appearences) {
        this.appearances = appearences;
    }

    public Integer getLineups() {
        return lineups;
    }

    public void setLineups(Integer lineups) {
        this.lineups = lineups;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Boolean getCaptain() {
        return captain;
    }

    public void setCaptain(Boolean captain) {
        this.captain = captain;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/playerstatistics/PlayerGoals.java
```java
package org.footballapp.model.playerstatistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerGoals {

    private Integer total;
    private Integer assists;

    public PlayerGoals() {
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getAssists() {
        return assists;
    }

    public void setAssists(Integer assists) {
        this.assists = assists;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/playerstatistics/PlayerLeague.java
```java
package org.footballapp.model.playerstatistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * League information contained within a player's statistics.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerLeague {

    @JsonProperty("id")
    private int leagueId;

    private String name;

    private int season;

    public PlayerLeague() {
    }

    public int getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/playerstatistics/PlayerStatistics.java
```java
package org.footballapp.model.playerstatistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerStatistics {

    private PlayerTeam team;

    private PlayerLeague league;

    private PlayerGames games;

    private PlayerGoals goals;

    private PlayerCards cards;

    public PlayerStatistics() {
    }

    public PlayerTeam getTeam() {
        return team;
    }

    public void setTeam(PlayerTeam team) {
        this.team = team;
    }

    public PlayerLeague getLeague() {
        return league;
    }

    public void setLeague(PlayerLeague league) {
        this.league = league;
    }

    public PlayerGames getGames() {
        return games;
    }

    public void setGames(PlayerGames games) {
        this.games = games;
    }

    public PlayerGoals getGoals() {
        return goals;
    }

    public void setGoals(PlayerGoals goals) {
        this.goals = goals;
    }

    public PlayerCards getCards() {
        return cards;
    }

    public void setCards(PlayerCards cards) {
        this.cards = cards;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/playerstatistics/PlayerTeam.java
```java
package org.footballapp.model.playerstatistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Team information contained within a player's statistics.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerTeam {

    @JsonProperty("id")
    private int teamId;

    private String name;

    @JsonProperty("logo")
    private String logoUrl;

    public PlayerTeam() {
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/standings/LeagueTableRow.java
```java
package org.footballapp.model.standings;


public class LeagueTableRow {

    private int position;
    private int teamId;
    private String teamName;
    private int played;
    private int wins;
    private int draws;
    private int losses;
    private int goalDifference;
    private int points;

    public int getPosition() {return position;}

    public void setPosition(int position) {this.position = position;}

    public int getTeamId() {return teamId;}

    public void setTeamId(int teamId) {this.teamId = teamId;}

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getPlayed() {return played;}

    public void setPlayed(int played) {this.played = played;}

    public int getWins() {return wins;}

    public void setWins(int wins) {this.wins = wins;}

    public int getDraws() {return draws;}

    public void setDraws(int draws) {this.draws = draws;}

    public int getLosses() {return losses;}

    public void setLosses(int losses) {this.losses = losses;}

    public int getGoalDifference() {return goalDifference;}

    public void setGoalDifference(int goalDifference) {this.goalDifference = goalDifference;}

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/standings/Standing.java
```java
package org.footballapp.model.standings;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Standing {

    private int rank;

    private StandingTeam team;

    private int points;

    private int goalsDiff;

    private StandingRecord all;

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public StandingTeam getTeam() {
        return team;
    }

    public void setTeam(StandingTeam team) {this.team = team;}

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getGoalsDiff() {
        return goalsDiff;
    }

    public void setGoalsDiff(int goalsDiff) {
        this.goalsDiff = goalsDiff;
    }

    public StandingRecord getAll() {
        return all;
    }

    public void setAll(StandingRecord all) {this.all = all;}
}
```

## File: footballapp/src/main/java/org/footballapp/model/standings/StandingAll.java
```java
package org.footballapp.model.standings;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StandingAll {

    private int played;
    private int win;
    private int draw;
    private int lose;

    /**Getters and Setters*/
    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getPlayed() {
        return played;
    }

    public void setPlayed(int played) {
        this.played = played;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getLose() {
        return lose;
    }

    public void setLose(int lose) {
        this.lose = lose;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/standings/StandingGoals.java
```java
package org.footballapp.model.standings;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StandingGoals {

    private int forGoals;
    private int against;

    @JsonProperty("for")
    public void setForGoals(int forGoals) {
        this.forGoals = forGoals;
    }

    public int getForGoals() {
        return forGoals;
    }

    public int getAgainst() {
        return against;
    }

    public void setAgainst(int against) {
        this.against = against;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/standings/StandingLeague.java
```java
package org.footballapp.model.standings;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StandingLeague {

    private int id;
    private int season;

    private List<List<Standing>> standings;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public List<List<Standing>> getStandings() {
        return standings;
    }

    public void setStandings(
            List<List<Standing>> standings
    ) {
        this.standings = standings;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/standings/StandingRecord.java
```java
package org.footballapp.model.standings;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StandingRecord {

    private int played;
    private int win;
    private int draw;
    private int lose;

    private StandingGoals goals;

    /**Getters and Setters*/
    public int getPlayed() {
        return played;
    }

    public void setPlayed(int played) {
        this.played = played;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getLose() {
        return lose;
    }

    public void setLose(int lose) {
        this.lose = lose;
    }

    public StandingGoals getGoals() {
        return goals;
    }

    public void setGoals(StandingGoals goals) {
        this.goals = goals;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/standings/StandingsApiResponse.java
```java
package org.footballapp.model.standings;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StandingsApiResponse {

    private List<StandingsResponse> response;

    public List<StandingsResponse> getResponse() {
        return response;
    }

    public void setResponse(
            List<StandingsResponse> response
    ) {
        this.response = response;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/standings/StandingsResponse.java
```java
package org.footballapp.model.standings;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StandingsResponse {

    private StandingLeague league;

    public StandingLeague getLeague() {
        return league;
    }

    public void setLeague(
            StandingLeague league
    ) {
        this.league = league;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/standings/StandingTeam.java
```java
package org.footballapp.model.standings;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StandingTeam {

    private int id;
    private String name;

    /**Getters and Setters*/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/teamdetails/TeamDetails.java
```java
package org.footballapp.model.teamdetails;

import org.footballapp.model.fixtures.FixtureRow;
import org.footballapp.model.teams.Team;
import org.footballapp.model.teams.Venue;

import java.util.List;

/**
 * Returns team, league position, points, form and recent fixtures.
 */
public class TeamDetails {

    private Team team;

    private Venue venue;

    private int leaguePosition;

    private int points;

    private String form;

    private List<FixtureRow> recentFixtures;

    public TeamDetails() {
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public int getLeaguePosition() {
        return leaguePosition;
    }

    public void setLeaguePosition(int leaguePosition) {
        this.leaguePosition = leaguePosition;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public List<FixtureRow> getRecentFixtures() {
        return recentFixtures;
    }

    public void setRecentFixtures(
            List<FixtureRow> recentFixtures
    ) {
        this.recentFixtures = recentFixtures;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/teams/ID.java
```java
package org.footballapp.model.teams;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// Returns the ID received from TeamResponse.
@JsonIgnoreProperties(ignoreUnknown = true)
public class ID {

    private int id;

    public ID() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
```

## File: footballapp/src/main/java/org/footballapp/model/teams/Team.java
```java
package org.footballapp.model.teams;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Represents a football club returned by API-Football.
 *
 * Mapped from the JSON "team" object.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Team {

    private int id;
    private String name;
    private String country;
    private int founded;
    private int venueId;

    public Team() {
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {return country;}
    public void setCountry(String country) {this.country = country;}

    public int getFounded() {return founded;}
    public void setFounded(int founded) {this.founded = founded;}

    public int getVenueId() {return venueId;}
    public void setVenueId(int venueId) {this.venueId = venueId;}

}
```

## File: footballapp/src/main/java/org/footballapp/model/teams/TeamResponse.java
```java
package org.footballapp.model.teams;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Represents a single entry within the API-Football
 * response array.
 *
 * Each response contains:
 * - Team information
 * - Venue information
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamResponse {

    private Team team;
    private Venue venue;

    public TeamResponse() {
    }

    public Team getTeam() {return team;}

    public void setTeam(Team team) {
        this.team = team;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

}
```

## File: footballapp/src/main/java/org/footballapp/model/teams/TeamsApiResponse.java
```java
package org.footballapp.model.teams;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Represents the root JSON response returned by
 * API-Football's teams endpoint.
 *
 * Example:
 * {
 *   "response": [...]
 * }
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamsApiResponse {

    private List<TeamResponse> response;

    public TeamsApiResponse() {
    }

    public List<TeamResponse> getResponse() {
        return response;
    }

    public void setResponse(List<TeamResponse> response) {
        this.response = response;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/teams/Venue.java
```java
package org.footballapp.model.teams;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Represents a stadium/venue returned by API-Football.
 *
 * Mapped from the JSON "venue" object.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Venue {

    private int id;
    private String name;
    private String address;
    private String city;
    private int capacity;
    private String surface;

    public Venue() {
    }

    public int getId() {return id;}
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {return address;}
    public void setAddress(String address) {this.address = address;}

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public int getCapacity() {return capacity;}
    public void setCapacity(int capacity) {this.capacity = capacity;}

    public String getSurface() {return surface;}
    public void setSurface(String surface) {this.surface = surface;}
}
```

## File: footballapp/src/main/java/org/footballapp/model/teamstatistics/CardColour.java
```java
package org.footballapp.model.teamstatistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CardColour {

    @JsonProperty("0-15")
    private CardMinute minute0to15;

    @JsonProperty("16-30")
    private CardMinute minute16to30;

    @JsonProperty("31-45")
    private CardMinute minute31to45;

    @JsonProperty("46-60")
    private CardMinute minute46to60;

    @JsonProperty("61-75")
    private CardMinute minute61to75;

    @JsonProperty("76-90")
    private CardMinute minute76to90;

    @JsonProperty("91-105")
    private CardMinute minute91to105;

    @JsonProperty("106-120")
    private CardMinute minute106to120;

    /**
     * Getters and Setters
     */
    public CardMinute getMinute0to15() {
        return minute0to15;
    }

    public void setMinute0to15(CardMinute minute0to15) {
        this.minute0to15 = minute0to15;
    }

    public CardMinute getMinute16to30() {
        return minute16to30;
    }

    public void setMinute16to30(CardMinute minute16to30) {
        this.minute16to30 = minute16to30;
    }

    public CardMinute getMinute31to45() {
        return minute31to45;
    }

    public void setMinute31to45(CardMinute minute31to45) {
        this.minute31to45 = minute31to45;
    }

    public CardMinute getMinute46to60() {
        return minute46to60;
    }

    public void setMinute46to60(CardMinute minute46to60) {
        this.minute46to60 = minute46to60;
    }

    public CardMinute getMinute61to75() {
        return minute61to75;
    }

    public void setMinute61to75(CardMinute minute61to75) {
        this.minute61to75 = minute61to75;
    }

    public CardMinute getMinute76to90() {
        return minute76to90;
    }

    public void setMinute76to90(CardMinute minute76to90) {
        this.minute76to90 = minute76to90;
    }

    public CardMinute getMinute91to105() {
        return minute91to105;
    }

    public void setMinute91to105(CardMinute minute91to105) {
        this.minute91to105 = minute91to105;
    }

    public CardMinute getMinute106to120() {
        return minute106to120;
    }

    public void setMinute106to120(CardMinute minute106to120) {
        this.minute106to120 = minute106to120;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/teamstatistics/CardMinute.java
```java
package org.footballapp.model.teamstatistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CardMinute {

    private Integer total;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/teamstatistics/Cards.java
```java
package org.footballapp.model.teamstatistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Cards {

    private CardColour yellow;
    private CardColour red;

    public CardColour getYellow() {
        return yellow;
    }

    public void setYellow(CardColour yellow) {
        this.yellow = yellow;
    }

    public CardColour getRed() {
        return red;
    }

    public void setRed(CardColour red) {
        this.red = red;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/teamstatistics/CleanSheet.java
```java
package org.footballapp.model.teamstatistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CleanSheet {

    private int total;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/teamstatistics/FailedToScore.java
```java
package org.footballapp.model.teamstatistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FailedToScore {

    private int total;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/teamstatistics/Fixtures.java
```java
package org.footballapp.model.teamstatistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Fixtures {

    private FixturesTotals played;
    private FixturesTotals wins;
    private FixturesTotals draws;
    private FixturesTotals loses;

    public FixturesTotals getPlayed() {
        return played;
    }

    public void setPlayed(FixturesTotals played) {
        this.played = played;
    }

    public FixturesTotals getWins() {
        return wins;
    }

    public void setWins(FixturesTotals wins) {
        this.wins = wins;
    }

    public FixturesTotals getDraws() {
        return draws;
    }

    public void setDraws(FixturesTotals draws) {
        this.draws = draws;
    }

    public FixturesTotals getLoses() {
        return loses;
    }

    public void setLoses(FixturesTotals loses) {
        this.loses = loses;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/teamstatistics/FixturesTotals.java
```java
package org.footballapp.model.teamstatistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FixturesTotals {

    private int total;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/teamstatistics/Goals.java
```java
package org.footballapp.model.teamstatistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Goals {

    private GoalsTotals forGoals;
    private GoalsTotals against;

    @JsonProperty("for")
    public GoalsTotals getForGoals() {
        return forGoals;
    }

    public void setForGoals(GoalsTotals forGoals) {
        this.forGoals = forGoals;
    }

    public GoalsTotals getAgainst() {
        return against;
    }

    public void setAgainst(GoalsTotals against) {
        this.against = against;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/teamstatistics/GoalsTotals.java
```java
package org.footballapp.model.teamstatistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GoalsTotals {

    private FixturesTotals total;

    public FixturesTotals getTotal() {
        return total;
    }

    public void setTotal(FixturesTotals total) {
        this.total = total;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/teamstatistics/League.java
```java
package org.footballapp.model.teamstatistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class League {

    private int id;
    private int season;

    // getters/setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/teamstatistics/Team.java
```java
package org.footballapp.model.teamstatistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Team {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/teamstatistics/TeamStatistics.java
```java
package org.footballapp.model.teamstatistics;

/**
 * Team statistics stored in PostgreSQL.
 */
public class TeamStatistics {

    private int teamId;
    private int leagueId;
    private int season;

    private int played;
    private int wins;
    private int draws;
    private int losses;

    private int goalsFor;
    private int goalsAgainst;

    private int cleanSheets;
    private int failedToScore;

    private int yellowCards;
    private int redCards;

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public int getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public int getPlayed() {
        return played;
    }

    public void setPlayed(int played) {
        this.played = played;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getGoalsFor() {
        return goalsFor;
    }

    public void setGoalsFor(int goalsFor) {
        this.goalsFor = goalsFor;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public void setGoalsAgainst(int goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
    }

    public int getCleanSheets() {
        return cleanSheets;
    }

    public void setCleanSheets(int cleanSheets) {
        this.cleanSheets = cleanSheets;
    }

    public int getFailedToScore() {
        return failedToScore;
    }

    public void setFailedToScore(int failedToScore) {
        this.failedToScore = failedToScore;
    }

    public int getYellowCards() {
        return yellowCards;
    }

    public void setYellowCards(int yellowCards) {
        this.yellowCards = yellowCards;
    }

    public int getRedCards() {
        return redCards;
    }

    public void setRedCards(int redCards) {
        this.redCards = redCards;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/teamstatistics/TeamStatisticsApiResponse.java
```java
package org.footballapp.model.teamstatistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamStatisticsApiResponse {

    private TeamStatisticsResponse response;

    public TeamStatisticsResponse getResponse() {
        return response;
    }

    public void setResponse(TeamStatisticsResponse response) {
        this.response = response;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/teamstatistics/TeamStatisticsResponse.java
```java
package org.footballapp.model.teamstatistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamStatisticsResponse {

    private League league;
    private Team team;
    private Fixtures fixtures;
    private Goals goals;

    private CleanSheet clean_sheet;
    private FailedToScore failed_to_score;

    private Cards cards;

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Fixtures getFixtures() {
        return fixtures;
    }

    public void setFixtures(Fixtures fixtures) {
        this.fixtures = fixtures;
    }

    public Goals getGoals() {
        return goals;
    }

    public void setGoals(Goals goals) {
        this.goals = goals;
    }

    public CleanSheet getClean_sheet() {
        return clean_sheet;
    }

    public void setClean_sheet(CleanSheet clean_sheet) {
        this.clean_sheet = clean_sheet;
    }

    public FailedToScore getFailed_to_score() {
        return failed_to_score;
    }

    public void setFailed_to_score(FailedToScore failed_to_score) {
        this.failed_to_score = failed_to_score;
    }

    public Cards getCards() {
        return cards;
    }

    public void setCards(Cards cards) {
        this.cards = cards;
    }
}
```
