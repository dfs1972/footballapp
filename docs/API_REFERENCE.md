# FootballApp REST API Reference

Last Updated: 13 July 2026

### Overview

The FootballApp backend exposes a REST API consumed by the Android application.

Development currently uses a historical snapshot of the Scottish Premiership 2024 season stored in Neon PostgreSQL.

Base URL (development):

http://localhost:8081

### GET /leagues

Returns all available leagues.

Response:

id
name
country

### GET /leagueOverview

Parameters:

leagueId
season

Returns:

leagueId
leagueName
season
teamCount
fixtureCount

### GET /leagueTable

Parameters:

leagueId
season

Returns one row per club:

position
teamId
teamName
played
wins
draws
losses
goalDifference
points

### GET /fixtures

Parameters:

leagueId
season

Returns all fixtures for the requested league and season.

Each fixture contains:

fixtureId
fixtureDate
fixtureTime
homeTeamId
awayTeamId
homeTeam
awayTeam
homeGoals
awayGoals

### GET /teams

Parameters:

leagueId
season

Returns all clubs in the selected competition.

Fields:

id
name
country
founded
venueId

### GET /teamDetails

Parameters:

leagueId
season
teamId

Returns:

Team
Venue
League Position
Points
Form
Recent Fixtures
### GET /teamFixtures

Parameters:

teamId

Returns every fixture involving the selected club.

### GET /teamPlayers

Parameters:

leagueId
season
teamId

Returns the squad for the selected season.

Fields include:

playerId
displayName
nationality
position
shirtNumber
captain
appearances
goals
assists
photoUrl

### GET /playerDetails

Parameters:

playerId
leagueId
season

Returns a complete player profile including:

Personal details
Team
League
Season
Position
Statistics
Photo

### GET /club

Parameters:

clubId

Returns static club information:

clubId
name
country
founded
stadium
city
capacity

## Notes

All endpoints have been verified against the Scottish Premiership 2024 development database.

The Android application should consume these endpoints through Retrofit repositories.