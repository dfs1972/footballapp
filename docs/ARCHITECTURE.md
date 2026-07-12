# FootballApp Architecture

## Overview

FootballApp consists of three independent layers.

```
                ┌────────────────────────┐
                │   Android Application  │
                │   (Jetpack Compose)    │
                └──────────┬─────────────┘
                           │
                     HTTP / JSON
                           │
                ┌──────────▼─────────────┐
                │      Java REST API     │
                │    (Spring Boot)       │
                └──────────┬─────────────┘
                           │
                    PostgreSQL Database
                           │
                ┌──────────▼─────────────┐
                │ footballapp_db         │
                └────────────────────────┘
```

The Android application never communicates directly with API-Football.

Instead, all requests pass through the FootballApp backend, which provides a stable API regardless of where the data originally came from.

---

# Backend Architecture

The backend follows a layered architecture.

```
                 REST Controllers
                        │
                        ▼
               LeagueDataService
                        │
        ┌───────────────┼────────────────┐
        ▼               ▼                ▼
   TeamRepository  FixtureRepository  PlayerRepository
        ▼               ▼                ▼
             PostgreSQL Database
```

Data import follows a separate path.

```
API-Football

        │

        ▼

ApiFootballClient

        │

        ▼

ApiFootballService

        │

        ▼

Import Services

        │

        ▼

Repositories

        │

        ▼

PostgreSQL
```

The import pipeline is completely independent from the REST API.

The database acts as the single source of truth for the Android application.

---

# Backend Layers

## API Layer

Responsible for communicating with API-Football.

Classes

- ApiFootballClient
- ApiFootballService

Responsibilities

- Send HTTP requests
- Parse JSON
- Return Java model objects

---

## Import Layer

Responsible for downloading data and storing it.

Current import services include

- LeagueImportService
- LeagueUkImportService
- TeamImportService
- StandingsImportService
- FixtureImportService
- TeamStatisticsImportService
- PlayerImportService

Responsibilities

- Retrieve API data
- Transform into database models
- Save through repositories

---

## Repository Layer

Repositories communicate directly with PostgreSQL.

Current repositories

- LeagueUkRepository
- LeagueRepository
- LeagueTeamRepository
- TeamRepository
- VenueRepository
- StandingRepository
- FixtureRepository
- TeamStatisticsRepository
- PlayerRepository
- PlayerStatisticsRepository

Responsibilities

- SQL queries
- Inserts
- Updates
- Reads
- Mapping database rows into Java objects

---

## Service Layer

Application services provide business logic.

Current services

- LeagueDataService
- TeamService
- FixtureService
- StandingService

Responsibilities

- Combine repository data
- Build response models
- Hide database implementation from controllers

---

## Controller Layer

Controllers expose REST endpoints.

Current endpoints

| Endpoint | Purpose |
|----------|----------|
| /leagues | Enabled leagues |
| /leagueOverview | League overview |
| /leagueTable | League standings |
| /fixtures | League fixtures |
| /fixture | Fixture details |
| /teams | Clubs in league |
| /teamDetails | Club details |
| /teamFixtures | Club fixtures |
| /teamPlayers | Squad |
| /playerDetails | Player profile |

Controllers should remain thin.

Business logic belongs inside LeagueDataService.

---

# Database

The backend uses PostgreSQL.

Current core tables

- leagues
- leagues_uk
- teams
- venues
- league_teams
- standings
- fixtures
- players
- player_statistics
- team_statistics

The database is considered the source of truth for the application.

Android never calls API-Football directly.

---

# Android Architecture

The Android application follows modern Jetpack Compose architecture.

```
Navigation

      │

      ▼

Screens

      │

      ▼

ViewModels (planned)

      │

      ▼

Repository

      │

      ▼

FootballApp REST API
```

UI is completely separated from data retrieval.

---

# Design Principles

The project follows several architectural principles.

• Single Responsibility Principle

Each class has one responsibility.

Examples

- Repository → database access
- Controller → HTTP endpoints
- Import Service → data import
- LeagueDataService → business logic

---

• Database First

All application data is served from PostgreSQL.

The external API is only used during import.

---

• Thin Controllers

Controllers should never contain SQL or business logic.

---

• Repository Pattern

All database access is isolated inside repository classes.

---

• Service Layer

Business logic belongs in services.

Repositories should not know about REST.

Controllers should not know about SQL.

---

# Data Flow

Import

```
API-Football
        │
ApiFootballService
        │
Import Service
        │
Repository
        │
PostgreSQL
```

Application

```
Android
      │
REST API
      │
Controller
      │
LeagueDataService
      │
Repository
      │
PostgreSQL
```

---

# Android Toolchain

- Android Gradle Plugin: 9.2.1
- Kotlin: 2.2.10
- Compile SDK: 37
- Target SDK: 36
- Minimum SDK: 26
- Jetpack Compose BOM: 2026.02.01

# Future Architecture

Planned additions

- ViewModels
- Retrofit client
- Offline caching
- Player search
- Match events
- Live scores
- Authentication (optional)
- Cloud deployment
