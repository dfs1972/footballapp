# FootballApp - Current Project State

## Last Updated: 13 July 2026

## Project Overview

### FootballApp consists of:

Backend: Java 25 + Spring Boot (IntelliJ IDEA)
Frontend: Android (Jetpack Compose, Android Studio)
Database: Neon PostgreSQL
Primary Data Source: API-Football

During development the application uses a historical snapshot of the Scottish Premiership 2024 season. This provides a stable dataset and avoids repeated API requests while developing and testing the Android application.

### Backend Status

Architecture

The backend now uses Spring Boot dependency injection throughout.

Android App
│
▼
REST Controllers
│
▼
LeagueDataService
│
▼
Repositories
│
▼
Neon PostgreSQL

Manual object construction has been removed in favour of constructor injection.

### Database

Current database contains:

Leagues
Seasons
Teams
Venues
League Teams
Standings
Fixtures
Players
Player Statistics
Team Statistics
Season Clubs

The database is fully normalised.

Examples:

teams.venue_id → venues.id
players stores player identity information.
player_statistics stores season and competition specific data.
REST API Status

All primary REST endpoints have been verified after the Spring migration.

Endpoint	Status
/leagues	✅ Verified
/leagueOverview	✅ Verified
/leagueTable	✅ Verified
/fixtures	✅ Verified
/teams	✅ Verified
/teamDetails	✅ Verified
/teamFixtures	✅ Verified
/teamPlayers	✅ Verified
/playerDetails	✅ Verified
/club	✅ Verified

Backend JSON contracts have been confirmed compatible with the Android frontend.

### Recent Backend Improvements

Completed:

Spring dependency injection migration.
Repository refactoring.
Shared Team ResultSet mapper introduced.
Fixed missing venueId mappings.
Verified repository and controller wiring.
Verified Neon database integration.

The backend is now considered stable for Android integration.

### Frontend Status

The Android application currently contains:

Competitions
League Overview
League Table
Fixtures
Clubs
Club
Squad
Player Details

Navigation between screens is complete.

Preview data is still used in some areas and will now be replaced incrementally with live backend data.

### Current Development Phase

The project is transitioning from backend development to frontend integration.

### Next objective:

Connect Android repositories to the live Spring REST API.
Replace PreviewData with Retrofit-backed data sources.
Verify each screen against live backend responses.
Complete end-to-end integration.
Known Issues

No known backend issues.

Minor data differences (such as null player statistics) reflect the source data supplied by API-Football rather than application defects.

### Immediate Next Steps
Update project documentation.
Commit verified backend state.
Begin Retrofit integration.
Replace Android preview data screen by screen.
Perform end-to-end testing.

### Project status:

Backend: Feature complete and verified.

Frontend: UI complete, transitioning to live data integration.