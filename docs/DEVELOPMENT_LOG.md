# Development Log
13 July 2026
Spring Backend Migration Completed

Completed migration of the backend from manual object construction to full Spring Boot dependency injection.

Backend Refactoring

## Completed:

Removed manual service and repository construction.
Introduced constructor injection throughout the application.
Simplified controller wiring.
Verified Spring Boot startup with no dependency errors.
Confirmed application launches successfully using the Spring Boot entry point.
REST API Verification

Performed full end-to-end verification of all backend REST endpoints against the Neon PostgreSQL development database.

Verified endpoints:

✅ /leagues
✅ /leagueOverview
✅ /leagueTable
✅ /fixtures
✅ /teams
✅ /teamDetails
✅ /teamFixtures
✅ /teamPlayers
✅ /playerDetails
✅ /club

All endpoints returned valid JSON and matched the expected Android DTO structure.

Repository Improvements

Discovered two repository mapping issues during endpoint verification.

Team venue mapping

Issue:

venueId always returned 0 despite correct database values.

Cause:

venue_id was not being mapped from the SQL ResultSet in multiple repository methods.

Resolution:

Added missing team.setVenueId(rs.getInt("venue_id")).
Refactored duplicate mapping logic into a shared Team mapping helper.
Verified /teams and /teamDetails now return the correct venue ID.
Database Verification

Verified relationships within the Neon PostgreSQL database.

### Confirmed:

teams.venue_id correctly references venues.id.
players stores player identity information.
player_statistics stores season and competition statistics.
Historical Scottish Premiership 2024 data is correctly linked across tables.

No schema issues identified.

## Player Data Verification

### Verified:

/teamPlayers returns the complete imported squad.
/playerDetails correctly combines player identity with season statistics.
Null statistics reflect the imported API data rather than application defects.
Club Endpoint

### Verified /club endpoint.

Confirmed it provides a lightweight club profile including:

Club name
Country
Founded year
Stadium
City
Capacity

Decision:

Retain both /club and /teamDetails.

Although both describe a club, they serve different purposes:

/club provides static club information.
/teamDetails provides season-specific information including form, league position and recent fixtures.
Backend Status

Backend is now considered stable.

### Completed:

Spring migration
Repository verification
Database verification
REST endpoint verification

No known backend defects remain.

Next Development Phase

Focus now shifts to Android frontend integration.

### Next objectives:

Replace PreviewData with Retrofit API calls.
Connect ViewModels to backend repositories.
Verify each screen against live backend data.
Complete end-to-end testing between Android and Spring Boot backend.
Milestone Reached

This marks completion of the backend development phase.

The project now transitions from backend implementation to frontend integration and live data consumption.


# DEVELOPMENT_LOG.md

## July 28th 2026 – Snapshot System Refactor & Package Architecture

### Overview

The backend snapshot system has been extensively redesigned to support complete offline development of the Android application. Rather than generating isolated API responses, the backend now generates hierarchical snapshot packages that mirror the application's navigation structure.

FootballDataProvider

Introduced the FootballDataProvider abstraction to decouple controllers and services from specific data sources.

Current implementations:

ApiFootballService (live API)
JsonFootballDataProvider (offline snapshots)

Controllers and services now depend only on FootballDataProvider, allowing seamless switching between live and offline data.

Snapshot Architecture

Snapshot generation has been reorganised into reusable package builders.

Current hierarchy:

League Package
│
├── League
├── Standings
├── Fixtures
└── Team Packages
│
├── Team
├── Players
├── Team Fixtures
├── Statistics
└── Fixture Packages
│
├── Fixture
├── Events
├── Lineups
└── Statistics

Implemented package builders:

saveLeaguePackage()
saveTeamPackage()
saveFixturePackage()

All package builders are composed from individually tested snapshot methods.

Fixture Snapshots

Added support for fixture-specific snapshot generation.

Implemented:

saveFixture()
saveFixtureEvents()
saveFixtureLineups()
saveFixtureStatistics()
saveFixturePackage()

Snapshot filenames were standardised:

fixture_1220110.json
fixture_events_1220110.json
fixture_lineups_1220110.json
fixture_statistics_1220110.json
Team Fixtures

Refactored team fixtures to use league and season instead of the previous last parameter.

Old:

fixtures?team={team}&last=5

New:

fixtures?team={team}&league={league}&season={season}

Recent fixtures are now derived by the application from the full season snapshot.

Testing

All snapshot endpoints have been verified.

Verified endpoints include:

League packages
Team packages
Fixture packages
Events
Lineups
Statistics

Backend starts cleanly with no compilation errors.

Current Status

Snapshot infrastructure is considered complete for league competitions.

Development focus is now moving towards:

generating snapshots for every supported competition
validating all Android screens
implementing richer UI using imported fixture data
supporting domestic and UEFA cup competitions


## July 28th 2026 20:23– Snapshot Package Validation & Multi-League Planning

### Overview

The snapshot package architecture was further validated and refined.

Development concentrated on ensuring the package builders remain modular while preparing the Android application for testing against multiple football competitions.

Team Package Improvements

Introduced the helper method:

saveFixturePackages()

This helper:

Reads the generated Team Fixtures snapshot.
Parses the API-Football response.
Enumerates fixture IDs.
Generates Fixture Packages using the existing saveFixturePackage() method.

This maintains the package builder philosophy of composing larger packages from smaller, independently tested snapshot methods.

Architectural Decision

An important design decision was reached during implementation.

The original direction began moving towards generating complete offline mirrors of the API.

After review, it was agreed that this exceeds the current requirements.

The objective of the snapshot system is to provide representative data for Android development and UI validation rather than a complete offline replica of every API endpoint.

As a result, further expansion of automatic snapshot generation has been deferred until there is a demonstrated need.

Current Snapshot Architecture

League Package

League
Standings
Fixtures
Team Packages

Team Package

Team
Players
Team Fixtures
Statistics
Fixture Packages

Fixture Package

Fixture
Events
Lineups
Statistics

This hierarchy now provides complete navigation paths for Android development while remaining modular and reusable.

Next Development Phase

Development focus now moves from snapshot generation towards application validation.

Next objectives:

Generate snapshots for the English Premier League.
Verify handling of a 20-team competition.
Validate every Android screen against multiple league structures.
Confirm UI behaviour is independent of competition size.

This represents the transition from backend snapshot infrastructure to comprehensive Android testing.