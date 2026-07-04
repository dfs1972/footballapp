# AI_CONTEXT.md

# FootballApp - Project Context

## Project Vision

FootballApp is a football companion application designed to present league, team, fixture and player information in a clean, modern and intuitive interface.

The project is **not** intended to expose every API endpoint available from API-Football. Instead, FootballApp presents carefully selected information that football supporters are most likely to want, using a consistent, component-driven UI.

The goal is to build an application that people enjoy using, rather than a database browser.

---

# Overall Architecture

FootballApp consists of two independent applications.

```
API-Football
        │
        ▼
Java Backend (Desktop)
Translation Layer
        │
        ▼
REST API
        │
        ▼
Android Application
```

The Android application **never communicates directly with API-Football**.

The backend is responsible for translating third-party API data into FootballApp models.

---

# Backend Architecture

The Java backend is responsible for:

- communicating with API-Football
- importing data
- caching data where appropriate
- exposing a clean REST API
- hiding API-Football implementation details from Android

Architecture:

```
Main
    │
    ▼
AppConfig
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

Android should never know how API-Football works.

Backend acts purely as a translation layer.

---

# Android Architecture

Android follows a layered architecture.

```
Repository

↓

UiModels

↓

Compose Components

↓

Screens
```

Screens display data.

Repositories retrieve data.

UiModels prepare data for presentation.

Components display reusable UI.

---

# UI Package Structure

```
ui/

    components/

    design/

    model/

    previews/

    screens/

        competitions/

        league/

        fixtures/

        teams/

        player/

    theme/
```

The older package:

```
com.example.footballapp.screens
```

is considered **legacy UI** and will gradually be replaced.

---

# Theme

The application uses Material 3.

Project-specific theme classes:

```
AppSpacing

AppDimensions

AppShapes

AppElevation

AppTypography
```

Avoid hardcoded spacing, typography and corner radius values.

---

# Design Package

```
ui/design/
```

Contains project-wide UI resources such as:

- Strings
- Icons
- Dimensions
- Animation

UI text should come from `Strings.kt` where appropriate.

---

# UI Models

UI components consume UiModels.

Never pass backend DTOs directly to Compose components.

Current models include:

```
CompetitionUiModel

CompetitionGroupUiModel

CompetitionType

StandingUiModel
```

Future UI models should follow the same pattern.

---

# Component-Driven UI

FootballApp is built from reusable Compose components.

Current components include:

```
ScreenScaffold

ScreenHeader

SectionCard

SectionHeading

CompetitionRow

CompetitionList

NavigationCard

TopStandingsCard
```

Screens should be assembled from components rather than containing layout logic.

---

# Screen-Driven Development

Development follows this process:

```
Design Screen

↓

ASCII Wireframe

↓

Identify reusable components

↓

Build components

↓

Assemble screen
```

Avoid building infrastructure without a screen that genuinely requires it.

---

# Design Principles

## Recognition before Reading

Prefer recognition over text.

Use:

- competition logos
- country flags
- icons
- typography
- spacing

to help users identify information quickly.

---

## Progressive Disclosure

Show the most important information first.

Allow users to drill down for additional detail.

Example:

```
Competitions

↓

League Overview

↓

League Table

↓

Team

↓

Player
```

Do not overwhelm users with every available statistic.

---

## Consistency

Navigation should look the same throughout the application.

Example:

```
League Table              >

Fixtures                  >

Teams                     >
```

Navigation cards are preferred over buttons.

---

## Simplicity

Every screen should answer one question.

Examples:

Competitions

> Which competition do I want?

League Overview

> What is happening in this competition?

League Table

> Where does every team currently stand?

Fixtures

> What matches are coming up?

Team

> Tell me about this club.

---

# Backend Philosophy

Backend is a translation layer.

Android should never:

- call API-Football
- understand API-Football DTOs
- know API-Football endpoints

Backend decides what Android needs.

---

# Current Development Strategy

Current focus is **Track 1 — Finish the Product**.

The objective is to complete every major screen using PreviewData before connecting the application to live backend data.

Once all screens exist:

- introduce ViewModels
- replace PreviewData
- connect repositories
- connect REST API

---

# Migration Strategy

Legacy screens are **not** being refactored.

Instead:

```
Legacy Screen

↓

Design

↓

New Screen

↓

Switch Navigation

↓

Delete Legacy Screen
```

This keeps the project stable throughout migration.

---

# Current Screen Status

Completed:

```
CompetitionsScreen

LeagueOverviewScreen
```

Remaining:

```
LeagueTableScreen

FixturesScreen

TeamsScreen

TeamScreen

PlayerScreen

FixtureDetailsScreen

SquadScreen
```

---

# PreviewData

PreviewData is intentionally used during UI development.

Purpose:

- Compose previews
- screen development
- visual design
- reusable sample data

PreviewData will eventually be replaced by ViewModels.

---

# AppState

Current AppState still contains some legacy values.

Future direction is:

```
selectedCompetition : CompetitionUiModel
```

rather than storing:

- leagueId
- leagueName
- season

separately.

---

# PostgreSQL

PostgreSQL remains part of the backend.

Its purpose is:

- caching
- development
- testing
- reducing unnecessary API requests

The application is **not** intended to become a historical football database.

The focus remains on current football information.

---

# Coding Guidelines

Prefer:

- UiModels over primitive values
- reusable components
- stateless Compose components
- Material 3
- project theme values
- Strings.kt for shared UI text

Avoid:

- duplicated UI
- hardcoded spacing
- hardcoded colours
- backend DTOs inside UI
- repository calls inside Compose screens

---

# Long-Term Goal

FootballApp should feel like a polished football application.

The user should never be aware that the data originated from API-Football.

Every screen should feel focused, uncluttered and consistent.

The application should prioritise user experience over exposing every available piece of data.

# UI Evolution Strategy

The existing screens under:

com.example.footballapp.screens

are considered prototype implementations.

They should not be refactored.

Instead:

Prototype Screen

↓

Redesign

↓

Identify reusable components

↓

Create new screen under ui/screens

↓

Switch navigation

↓

Delete prototype screen

This allows the application to evolve cleanly without mixing old and new architectures.
