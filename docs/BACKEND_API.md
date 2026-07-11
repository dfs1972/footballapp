# Backend & REST API

## Overview

The FootballApp backend is a Java Spring Boot application responsible for importing football data, managing the PostgreSQL database and exposing REST endpoints consumed by the Android application.

The backend acts as an abstraction layer between external football data providers and client applications. Android clients communicate only with the backend REST API and never directly with API-Football.

---

# Technology Stack

* Java
* Spring Boot
* PostgreSQL
* JDBC
* Jackson
* Gradle
* API-Football

---

# Backend Responsibilities

The backend is responsible for:

* Importing football data from API-Football
* Validating and transforming imported data
* Persisting data in PostgreSQL
* Providing REST endpoints for client applications
* Combining related information through repository queries
* Returning lightweight DTOs for Android

---

# High-Level Architecture

```text
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
              PostgreSQL
                     │
                     ▼
             Repository Layer
                     │
                     ▼
          LeagueDataService
                     │
                     ▼
             REST Controllers
                     │
                     ▼
          Android Application
```

---

# Application Layers

## API Layer

### ApiFootballClient

Responsible for HTTP communication with API-Football.

Responsibilities:

* Authentication
* HTTP requests
* Returning raw JSON

---

### ApiFootballService

Converts raw API responses into Java model classes using Jackson.

Responsibilities:

* Build endpoint URLs
* Deserialize JSON
* Return strongly typed objects

---

# Import Services

Each importer has a single responsibility.

Current import services include:

* LeagueImportService
* TeamImportService
* StandingsImportService
* FixtureImportService
* PlayerImportService

Each importer:

* Calls API-Football
* Maps JSON
* Persists data
* Avoids duplicate records where appropriate

---

# Repository Layer

Repositories communicate directly with PostgreSQL.

Responsibilities:

* SQL queries
* Inserts
* Updates
* Complex joins
* DTO construction

Repositories contain no presentation logic.

---

# Service Layer

LeagueDataService provides business logic for the REST API.

Responsibilities include:

* Combining repository calls
* Returning DTOs
* Simplifying controller code
* Isolating business logic from HTTP requests

---

# REST Controllers

Controllers expose backend functionality as REST endpoints.

Typical flow:

```text
HTTP Request
      │
      ▼
Controller
      │
      ▼
LeagueDataService
      │
      ▼
Repository
      │
      ▼
PostgreSQL
```

Controllers remain intentionally lightweight.

---

# Current REST Endpoints

## League

* GET /leagueOverview
* GET /leagueTable

---

## Teams

* GET /teams
* GET /teamDetails
* GET /teamPlayers
* GET /teamFixtures

---

## Players

* GET /playerDetails

---

## Fixtures

* GET /fixtures
* GET /fixtureDetails

---

# Data Transfer Objects (DTOs)

REST endpoints return lightweight DTOs rather than database entities.

Examples include:

* LeagueOverview
* TeamSummary
* TeamDetails
* PlayerSummary
* PlayerDetails
* FixtureSummary
* FixtureDetails

DTOs contain only the information required by the Android application.

---

# Design Principles

The backend follows several architectural principles:

* Separation of concerns
* Repository pattern
* Service layer
* DTO-based REST API
* Stateless controllers
* Normalised database design
* No direct Android access to PostgreSQL
* External APIs isolated behind service classes

---

# Error Handling

The backend validates:

* Missing database records
* Invalid parameters
* Empty API responses
* SQL exceptions
* JSON deserialization errors

Meaningful HTTP status codes are returned where appropriate.

---

# Performance Considerations

The backend has been designed to minimise external API usage.

Historical football information is stored locally within PostgreSQL.

Repository queries retrieve related information through SQL joins rather than storing duplicate data.

Future enhancements may include:

* Response caching
* Image caching
* Scheduled imports
* Background synchronisation
* CDN-hosted static images

---

# Planned Enhancements

Future backend development includes:

* Squad import service
* Live match support
* Transfers
* Injuries
* Match events
* Line-ups
* Head-to-head statistics
* Search API
* Authentication
* Administrative import tools

---

# Long-Term Architecture

```text
              API-Football
                     │
        Scheduled Imports / Live Calls
                     │
                     ▼
             Spring Boot Backend
                     │
              PostgreSQL Database
                     │
             REST API Endpoints
                     │
        ┌────────────┴────────────┐
        ▼                         ▼
 Android Application      Future Web Client
```

The backend is intended to become the central platform for all FootballApp clients. Historical data will be served from PostgreSQL, while selected live information will continue to be retrieved from API-Football during active football seasons.
