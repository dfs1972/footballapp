# FootballApp Architecture

### Last Updated: 13 July 2026

### Overview

FootballApp is split into two independent applications:

Backend – Java 25 + Spring Boot
Frontend – Android (Jetpack Compose)

The backend exposes a REST API consumed by the Android application.

Development currently uses a historical snapshot of the Scottish Premiership 2024 season stored in a Neon PostgreSQL database.

High-Level Architecture
Android Application
(Jetpack Compose + Retrofit)
│
HTTP / JSON REST
│
▼
Spring Boot REST API
│
REST Controllers
│
▼
LeagueDataService
│
┌──────────────────┼──────────────────┐
│                  │                  │
▼                  ▼                  ▼
TeamRepository     FixtureRepository   PlayerRepository
StandingRepository VenueRepository     LeagueRepository
│
▼
Neon PostgreSQL
Backend Layers
## Controllers

Controllers expose REST endpoints to the Android application.

### Responsibilities:

Receive HTTP requests.
Validate request parameters.
Delegate business logic to the service layer.
Return JSON DTOs.

Controllers contain no database logic.

## Service Layer

The LeagueDataService acts as the primary application service.

### Responsibilities:

Coordinate repository calls.
Build complex response objects.
Combine data from multiple tables.
Isolate business logic from controllers.

Examples include:

Club Details
Player Details
League Overview
Repository Layer

Repositories provide all database access.

### Responsibilities:

Execute SQL queries.
Map ResultSet objects into domain models.
Hide SQL implementation from the service layer.

Repositories never communicate directly with Android.

## Database

Development database:

Neon PostgreSQL

### Primary tables:

leagues
seasons
teams
venues
league_teams
standings
fixtures
players
player_statistics
team_statistics
season_clubs

### Key relationships:

teams
│
└── venue_id ─────────► venues

players
│
└─────────────────────► player_statistics

The schema is fully normalised to minimise duplicated data.

### Dependency Injection

The backend now uses Spring Boot constructor injection throughout.

Responsibilities managed by Spring include:

Controller creation
Service creation
Repository creation
Dependency management

Manual object construction has been removed.

### REST API

Current verified endpoints:

GET /leagues
GET /leagueOverview
GET /leagueTable
GET /fixtures
GET /teams
GET /teamDetails
GET /teamFixtures
GET /teamPlayers
GET /playerDetails
GET /club

All endpoints have been verified against the Neon development database.

## Data Flow

Example request:

Android
│
GET /teamDetails
│
▼
TeamController
│
▼
LeagueDataService
│
▼
Repositories
│
▼
Neon PostgreSQL
│
▼
Repositories
│
▼
LeagueDataService
│
▼
JSON Response
│
▼
Android UI
Android Architecture

The Android application follows a layered architecture:

Compose UI
│
▼
ViewModels
│
▼
Repositories
│
▼
Retrofit
│
▼
Spring Boot Backend

During development, PreviewData is gradually being replaced by live Retrofit data.

### Current Development Phase

Backend implementation is complete.

### Current focus:

Retrofit integration.
Replace PreviewData.
Connect ViewModels to live REST endpoints.
Complete end-to-end testing.
Future Expansion

### The architecture is designed to support:

Additional football leagues.
Multiple seasons.
Live API synchronisation.
Scheduled background imports.
User favourites.
Player search.
Match statistics.
Caching.
Authentication (if required).

The current architecture is intended to scale without significant structural changes.

### External APIs are treated as integration layers.
The FootballApp database is designed around the application's needs,
not around the structure of third-party JSON responses.
During import, flexible API responses are mapped into strongly typed domain models.

# Backend Update

Repositories now use a Spring-managed DataSource with HikariCP,
instead of obtaining connections directly from DatabaseConnection.