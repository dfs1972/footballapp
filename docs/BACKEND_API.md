# Backend & REST API

## Overview

The FootballApp backend is a Java Spring Boot application responsible for importing football data, managing the PostgreSQL database and exposing REST endpoints consumed by the Android application.

The backend acts as an abstraction layer between external football data providers and client applications. Android clients communicate only with the backend REST API and never directly with API-Football.

---

The backend provides a single abstraction (FootballDataProvider) for supplying football data to the Android application.

Two implementations are available:

Live API (ApiFootballService)
Offline snapshots (JsonFootballDataProvider)

No controller depends directly on a specific implementation.

Snapshot API

Snapshot endpoints are intended for development only.

Generated snapshots are stored under:

mockapi/

Snapshots mirror the application's navigation hierarchy.

League
/snapshot/leaguePackage/{leagueId}/{season}

Generates:

League
Standings
Teams
Fixtures
Team packages
Team
/snapshot/teamPackage/{teamId}/{leagueId}/{season}

Generates:

Team
Players
Team fixtures
Team statistics
Fixture
/snapshot/fixturePackage/{fixtureId}

Generates:

Fixture
Events
Lineups
Statistics
Snapshot Naming Convention

League

league_179.json
standings_179_2024.json
fixtures_179_2024.json
teams_179_2024.json

Team

team_247.json
team_fixtures_247_179_2024.json
players_247_2024.json
statistics_247_179_2024.json

Fixture

fixture_1220110.json
fixture_events_1220110.json
fixture_lineups_1220110.json
fixture_statistics_1220110.json
Architectural Principles
Controllers depend only on FootballDataProvider.
Package builders orchestrate smaller snapshot methods.
Snapshot methods contain no orchestration logic.
Android UI determines presentation (for example recent fixtures), while snapshots provide complete season data.
Snapshot structure mirrors application navigation rather than API-Football endpoints.
Every snapshot method is independently testable before being composed into larger package builders.