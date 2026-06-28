# FootballApp

FootballApp is a full-stack football statistics application built with Java, Spring Boot, PostgreSQL and Android (Jetpack Compose).

The project imports football data from API-Football into a PostgreSQL database and exposes a REST API that is consumed by the Android application. The long-term goal is to provide a fast, responsive football companion app using locally managed historical data together with selected live football information during active seasons.

---

# Features

Current functionality includes:

* League selection
* League overview
* League table
* Team details
* Squad information
* Player profiles
* Fixtures
* Fixture details
* Team fixtures

The backend currently imports:

* Leagues
* Teams
* Venues
* League teams
* Standings
* Fixtures
* Players
* Player statistics

---

# Technology Stack

## Backend

* Java
* Spring Boot
* PostgreSQL
* JDBC
* Jackson
* Gradle

## Android

* Kotlin
* Jetpack Compose
* Material 3
* Navigation Compose
* Coil
* OkHttp

## Data Source

* API-Football (API-Sports)

---

# Architecture

```text
                    API-Football
                          │
                          ▼
                  Import Services
                          │
                          ▼
                   PostgreSQL Database
                          │
                          ▼
                  Repository Layer
                          │
                          ▼
                  LeagueDataService
                          │
                          ▼
                  Spring Boot REST API
                          │
                          ▼
                  Android Application
```

The backend manages all business logic and database access.

The Android application is responsible for presentation and user interaction.

---

# Project Structure

```text
backend/
    Java Spring Boot application

android/
    Android application
    Jetpack Compose UI

database/
    PostgreSQL schema

docs/
    Project documentation
```

---

# Documentation

Additional documentation is available in the **docs** folder.

| Document            | Description                              |
| ------------------- | ---------------------------------------- |
| PROJECT_OVERVIEW.md | Project overview and objectives          |
| DATABASE.md         | PostgreSQL database design               |
| BACKEND_API.md      | Backend architecture and REST API        |
| ANDROID_APP.md      | Android architecture and UI              |
| ROADMAP.md          | Planned features and future development  |
| CHANGELOG.md        | Completed milestones and project history |

---

# Development Status

The project has reached the stage where the complete backend platform is operational.

Current capabilities include:

* Importing football data into PostgreSQL
* Exposing REST APIs through Spring Boot
* Browsing football information using the Android application
* Navigating from leagues to teams, squads and player profiles

Development is currently focused on improving the Android user experience, expanding REST endpoints and preparing the application for future public deployment.

---

# Long-Term Vision

FootballApp is being designed as a scalable football platform rather than simply an Android application.

Historical football data will be stored within a PostgreSQL database managed by the FootballApp backend. During active football seasons, selected live information will continue to be retrieved from API-Football where appropriate.

Future versions are planned to include:

* Head-to-head statistics
* Player search
* Transfers
* Injuries
* Match events
* Live scores
* Favourite teams
* Image caching
* Scheduled data imports
* Web application
* Public cloud deployment

---

# Contributing

The project is currently under active development.

Documentation and architecture continue to evolve as new functionality is added.

---

# Licence

This project is intended as both a learning exercise and a production-quality football application built using modern Java, Spring Boot, PostgreSQL and Android development practices.
