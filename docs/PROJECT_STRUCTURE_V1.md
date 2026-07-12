# FootballApp Project Structure

**Project:** FootballApp

**Version:** 1.0

**Last Updated:** 11 July 2026

---

# Purpose

This document provides a complete reference to the structure of FootballApp.

Unlike **ARCHITECTURE.md**, which explains how the application works, this document explains:

- Where everything is located.
- The purpose of each package.
- The responsibility of each layer.
- The current implementation status.
- Where future development should occur.

This document should be consulted before creating any new classes to avoid duplicate functionality.

---

# Project Overview

```
footballapp/

├── footballapp/          Spring Boot Backend
│
├── android/              Android Application
│
├── docs/                 Project Documentation
│
└── tools/                Development Tools
```

---

# Backend

Root

```
footballapp/src/main/java/org/footballapp
```

The backend is responsible for:

- Importing football data
- Managing PostgreSQL
- Providing the REST API
- Supplying all Android data

---

## api

Purpose

Communicates with API-Football.

Contains

```
ApiFootballClient
ApiFootballService
```

Responsibilities

- HTTP requests
- JSON parsing
- External API communication

Status

✅ Complete

---

## config

Purpose

Application configuration.

Contains

```
AppConfig
```

Responsibilities

- Create services
- Wire repositories
- Configure application

Status

✅ Complete

---

## controller

Purpose

Expose REST endpoints.

Current Controllers

```
LeaguesController

LeagueOverviewController

LeagueTableController

FixturesController

FixtureDetailsController

TeamsController

TeamDetailsController

TeamFixturesController

PlayerController
```

Responsibilities

- HTTP endpoints
- Request validation
- Return JSON

Business logic should never exist here.

Status

✅ Complete

---

## database

Purpose

Database connectivity.

Contains

```
DatabaseConnection

schema/

data/

backups/
```

Responsibilities

- JDBC connection
- SQL schema
- SQL backups

Status

✅ Complete

---

## databaserepository

Purpose

Read and write PostgreSQL.

Current repositories

```
LeagueRepository

LeagueUkRepository

LeagueTeamRepository

StandingRepository

FixtureRepository

TeamRepository

VenueRepository

PlayerRepository

PlayerStatisticsRepository

TeamStatisticsRepository
```

Responsibilities

- SQL
- CRUD
- Mapping rows to Java models

Status

✅ Complete

---

## model

Purpose

Domain models.

Contains models for

```
League

League Overview

Standings

Fixtures

Teams

Venues

Players

Player Details

Player Statistics

Team Statistics
```

Responsibilities

Represent football data throughout the backend.

Status

✅ Complete

---

## service

Purpose

Business logic.

Current Services

```
LeagueDataService

FixtureService

StandingService

TeamService
```

Responsibilities

- Combine repository data
- Build response models
- Hide database implementation

Status

✅ Complete

---

## util

Purpose

Shared utility classes.

Status

Growing as required.

---

# Android

Root

```
android/app/src/main/java/com/example/footballapp
```

The Android application consumes the FootballApp REST API.

---

## data

Purpose

Retrieve backend data.

Structure

```
mapper/

remote/

repository/
```

Responsibilities

- Retrofit
- DTOs
- Mapping
- Repository Pattern

Status

🟡 In Progress

---

### mapper

Purpose

Convert DTOs into UiModels.

Current

```
CompetitionMapper
```

Status

🟡 Growing

---

### remote

Purpose

REST communication.

Contains

```
FootballApiClient

FootballApiService

dto/
```

Status

✅ Working

---

### repository

Purpose

Provide ViewModels with application data.

Current

```
CompetitionRepository
```

Status

🟡 Growing

---

## ui

Purpose

Compose user interface.

Sub-packages

```
components

design

model

navigation

previews

screens

theme

viewmodel
```

Status

Migration to Live Data

---

### components

Reusable Compose components.

Examples

```
SectionCard

CompetitionList

ClubBadge

InfoRow

PlayerRow
```

Status

✅ Mature

---

### design

Purpose

Design system.

Contains

```
Strings

Icons

Dimensions

AppSpacing

Animation

AppConstants
```

Status

Growing

---

### model

Purpose

UI Models.

Examples

```
CompetitionUiModel

ClubUiModel

PlayerUiModel
```

Status

Growing

---

### navigation

Purpose

Navigation graph.

Contains

```
FootballNavHost

FootballDestination
```

Status

✅ Complete

---

### previews

Purpose

Preview-only data.

Contains

```
PreviewData
```

IMPORTANT

PreviewData must never be used by runtime code.

Status

Being phased out.

---

### screens

Purpose

Compose screens.

Current Screens

```
Competitions

League Overview

League Table

Fixtures

Clubs

Club

Squad

Player Details
```

Migration Status

| Screen | Status |
|---------|--------|
| Competitions | ✅ Live Data |
| League Overview | 🟡 Migration |
| League Table | Preview |
| Fixtures | Preview |
| Clubs | Preview |
| Club | Preview |
| Squad | Preview |
| Player Details | Preview |

---

### theme

Purpose

Material theme.

Status

Stable

---

### viewmodel

Purpose

Application state.

Current

```
CompetitionViewModel

CompetitionUiState
```

Status

🟡 Growing

---

# Documentation

```
docs/

ARCHITECTURE.md

PROJECT_STRUCTURE.md

CURRENT_STATE.md

DEVELOPMENT_LOG.md

UI_GUIDELINES.md
```

Purpose

Project documentation.

---

# Development Status

## Backend

| Feature | Status |
|----------|--------|
| API Import | ✅ |
| PostgreSQL | ✅ |
| REST API | ✅ |
| Neon | ✅ |
| League Overview | ✅ |
| League Table | ✅ |
| Fixtures | ✅ |
| Teams | ✅ |
| Players | ✅ |

---

## Android

| Feature | Status |
|----------|--------|
| Compose UI | ✅ |
| Navigation | ✅ |
| Retrofit | ✅ |
| Competition Screen | ✅ Live |
| League Overview | 🟡 |
| League Table | Preview |
| Fixtures | Preview |
| Clubs | Preview |
| Squad | Preview |
| Player Details | Preview |

---

# Naming Conventions

Controllers

```
*Controller
```

Repositories

```
*Repository
```

Services

```
*Service
```

ViewModels

```
*ViewModel
```

Compose Screens

```
*Screen
```

REST DTOs

```
*Dto
```

UI Models

```
*UiModel
```

---

# Development Workflow

Before creating a new class:

1. Check PROJECT_STRUCTURE.md.
2. Search for an existing implementation.
3. Reuse existing models whenever possible.
4. Update this document after completing significant features.

---

# Future Expansion

Planned additions

- Live Scores
- Search
- Offline Cache
- Authentication
- Notifications
- Settings Synchronisation
- Desktop Administration Tools
- Cloud Deployment