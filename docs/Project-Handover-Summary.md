FootballApp — Comprehensive Project Handover

Date: 14 August 2026
Project: FootballApp
Development status: Active development
Current phase: Android UI / Fixture Details / JSON development data
Backend data source during development: Downloaded API-Football JSON snapshots
Production data source: API-Football live API
Database: No longer used by the application

1. IMPORTANT — READ THIS FIRST

This project has gone through a significant architectural migration.

The original application used:

Android
↓
Spring Boot
↓
Repositories
↓
PostgreSQL

That architecture is no longer the development architecture.

The current architecture is:

Android
↓
Retrofit
↓
Spring Boot REST API
↓
FootballDataProvider
↓
JsonFootballDataProvider
↓
Downloaded API-Football JSON

The eventual production architecture will replace the JSON provider with the live API provider:

Android
↓
Retrofit
↓
Spring Boot REST API
↓
FootballDataProvider
↓
ApiFootballDataProvider
↓
API-Football

The purpose of the JSON system is to allow development and testing without continuously calling API-Football.

Do not reintroduce PostgreSQL or the old JDBC repository architecture unless there is a very specific future requirement.

The JSON snapshot architecture is intentional.

2. AUTHORITATIVE PROJECT FILES

For future development, the most recent Repomix files are the source of truth for the code.

Current authoritative files:

repomix-backend-August-14-26.md
repomix-android-August-14-26.md

Repomix files are usually updated daily or even twice per day.

The handover describes:

current architecture
completed work
decisions
known limitations
next development priorities

It should not override the actual source code contained in the latest Repomix.

The project has accumulated numerous historical handovers and Repomix files. These should not be treated as current unless specifically required for historical context.

3. OVERALL ARCHITECTURE

The current application follows this general architecture.

Backend
API-Football
│
▼
ApiFootballClient
│
▼
JSON Snapshot Generator
│
▼
mockapi/
│
▼
JsonFootballDataProvider
│
▼
LeagueDataService
│
▼
REST Controllers
Android
Spring Boot REST API
│
▼
Retrofit
│
▼
DTO
│
▼
Mapper
│
▼
UiModel
│
▼
Repository
│
▼
ViewModel
│
▼
UiState
│
▼
Jetpack Compose

This separation should be maintained.

In particular:

The ViewModel should not be responsible for converting backend DTOs into UiModels.

Mapping belongs in the repository/data layer.

4. BACKEND TECHNOLOGY

The backend is a Spring Boot application.

Important technologies/components include:

Java
Spring Boot
REST controllers
Jackson
API-Football
JSON snapshot provider
FootballDataProvider
JsonFootballDataProvider
JsonLoader
MockApiPaths
Retrofit-compatible REST endpoints for Android

The old PostgreSQL/JDBC infrastructure has been removed.

Previous work explicitly removed:

PostgreSQL
JDBC repositories
BaseRepository
DataSource
JDBC dependency
PostgreSQL dependency
spring.datasource.* configuration

The backend was rebuilt successfully after this cleanup.

5. JSON SNAPSHOT ARCHITECTURE

The development backend uses downloaded API-Football responses.

The root is:

mockapi/

JsonLoader loads files from this filesystem directory:

private static final Path MOCK_API_ROOT =
Paths.get("mockapi");

It resolves the requested snapshot against that root and throws SnapshotNotFoundException when the file does not exist.

This is deliberate.

The JSON files are not application resources.

They live on the filesystem alongside the backend project.

6. CURRENT SNAPSHOT STRUCTURE

The important structure is:

mockapi/


├── competitions/
│   └── {leagueId}/
│       ├── league.json
│       ├── standings.json
│       ├── teams.json
│       ├── fixtures.json
│       │
│       └── teams/
│           └── {teamId}/
│               ├── players.json
│               ├── fixtures.json
│               └── statistics.json
│
├── teams/
│   └── {teamId}/
│       └── team.json
│
├── players/
│   └── {playerId}/
│       ├── details.json
│       ├── statistics.json
│       └── transfers.json
│
└── fixtures/
└── {fixtureId}/
├── fixture.json
├── events.json
├── lineups.json
└── statistics.json

The important architectural decision is that fixture packages remain global.

They are not stored underneath a competition.

Correct:

mockapi/fixtures/1382676/events.json

Not:

mockapi/competitions/179/fixtures/1382676/events.json

Fixture IDs are globally unique, so there was no benefit in adding leagueId to fixture paths and provider methods.

This decision was made deliberately during the snapshot refactoring.

7. HOW FIXTURE JSON IS USED

A fixture can have several downloaded API-Football snapshots:

mockapi/
└── fixtures/
└── 1382676/
├── fixture.json
├── events.json
├── lineups.json
└── statistics.json

These correspond to different API-Football endpoints.

For example:

fixture
events
lineups
statistics

The MockApiPaths utility centralises these paths.

The current JsonFootballDataProvider uses JsonLoader and MockApiPaths rather than constructing filesystem paths itself.

8. DEVELOPMENT DATA SOURCE

The project is currently being developed using downloaded JSON responses from API-Football.

This is important:

We do not currently rely on the database for fixture, event, lineup or player data.

Downloaded JSON is the development dataset.

Once the application is complete, the intention is to switch the provider to live API-Football requests.

Therefore:

JSON snapshot

should be regarded as:

a development substitute for the live API.

It should not become a second permanent data model.

9. SNAPSHOT GENERATION

The backend contains snapshot-generation functionality.

The relevant service is:

JsonSnapshotService

It can download API-Football responses and save them into the appropriate snapshot paths.

The snapshot generator checks API responses for errors before saving them.

This was added because API rate-limit responses were previously being accidentally written into snapshot files.

The system now:

API request
↓
API error?
├── yes → do not save snapshot
│
└── no → save JSON

Automatic retry handling for API minute limits was also implemented during the snapshot work.

10. API PROVIDER ABSTRACTION

The central backend abstraction is:

FootballDataProvider

There are effectively two possible data sources:

FootballDataProvider
│
├── Live API provider
│
└── JsonFootballDataProvider

This is one of the most important architectural decisions in the project.

Controllers should not care whether data came from:

API-Football
downloaded JSON

They should simply use the provider/service abstraction.

11. CURRENT BACKEND ENDPOINTS

The application currently has REST functionality for the major football data areas.

The important endpoints include:

/leagues


/leagueOverview


/leagueTable


/fixtures


/teamFixtures


/teams


/club


/teamPlayers


/playerDetails


/fixtureDetails


/fixtureLineup

These correspond to the main Android features.

ANDROID TECHNOLOGY

12. The Android application uses:

Kotlin
Jetpack Compose
Material 3
Navigation Compose
Retrofit
ViewModels
StateFlow
DTOs
repositories
mappers
UiModels

13. The application follows the standard flow:

REST
↓
Retrofit DTO
↓
Mapper
↓
UiModel
↓
Repository
↓
ViewModel
↓
UiState
↓
Compose
14. CURRENT ANDROID SCREENS

The application currently contains the following major screens/features.

Competitions
League Overview
League Table
Fixtures
Clubs
Club
Squad
Player Details
Team Fixtures
Fixture Details

Navigation is operational.

Current navigation routes include league/team-aware routes such as:

teamFixtures/{leagueId}/{teamId}


fixtureDetails/{leagueId}/{fixtureId}


player/{leagueId}/{playerId}

The navigation was deliberately refactored so that screens are no longer tied to a single development league.

15. DEVELOPMENT LEAGUE / SEASON

The application previously had extensive dependence on:

AppConstants.DEVELOPMENT_LEAGUE

This caused problems when navigating between competitions.

The navigation was refactored so that:

leagueId

travels through the navigation graph.

This was completed for:

Club
Squad
Team Fixtures
Player Details
Fixture Details

This should remain the approach.

Do not reintroduce hidden assumptions that everything belongs to the Scottish Premiership.

16. TEAM FIXTURES — CURRENT DESIGN

This has recently been simplified.

The previous idea of a complex date selector / scroll-to-date control was abandoned.

The current design is deliberately simple:

Rangers
2025/26


August
fixture
fixture
fixture


September
fixture
fixture


October
fixture
fixture

The user taps a month and it expands.

Fixtures underneath display:

date
teams
score or kick-off information

This is now working properly.

The reasoning was:

A user interested in a club will normally navigate to that club and select its fixtures.

Therefore the Team Fixtures screen should be simple and useful rather than technically elaborate.

17. GENERAL FIXTURES SCREEN

The general league-wide Fixtures screen has deliberately been deprioritised.

The reasoning is important.

A league may contain hundreds of fixtures.

Most users are likely to want:

My club
↓
Club
↓
Fixtures

If they want another club:

Clubs
↓
Selected club
↓
Fixtures

Therefore there is little benefit in creating a complicated league-wide fixture browsing experience.

The general FixturesScreen can remain in the application for now.

Do not spend significant development time redesigning it unless a future requirement specifically calls for it.

18. FIXTURE DETAILS — CURRENT STATUS

Fixture Details is the next major area of development.

The current screen already displays basic fixture information.

Current information includes:

home team
away team
score
competition
round
date
kick-off
venue
lineup

The current screen is functional but basic. The existing Compose implementation uses FixtureDetailsUiModel, FixtureLineupUiModel, SectionCard, InfoRow, FixtureLineupCard, and DateFormatter.

The intention is to turn it into a proper match-centre / fixture details screen.

19. TARGET FIXTURE DETAILS DESIGN

The intended concept is:

Competition
Round


        HOME
         logo


       2 – 1


         logo
        AWAY


      Full Time

Then:

MATCH EVENTS
────────────────────────


14'   ⚽ Goal
Player


59'   🟥 Red Card
Player


64'   ⇄ Substitution
Player
Player


90+8' VAR
Goal cancelled

Then:

LINEUPS
────────────────────────


Home                 Away
...

Then:

MATCH INFORMATION
────────────────────────


Date
Kick-off
Venue
Competition
Round

The exact visual design has not yet been finalised.

The next project should not assume the exact layout above is mandatory. It is the agreed design direction.

20. IMPORTANT FIXTURE TEST DATA

Several Rangers fixture event datasets have now been downloaded.

The most useful test fixture is:

Fixture ID: 1382676

This is particularly valuable because its event data contains almost everything required to test the Match Events UI.

It includes:

goals
penalty
red card
yellow cards
substitutions
VAR
added time

The known events include:

51'     Dundee goal


54'     Rangers yellow card


56'     Rangers substitution


59'     Nasser Djiga — Red Card


64'     Rangers substitutions


67'     Dundee substitution


77'     Rangers substitution


83'     Dundee substitution


86'     Dundee yellow card


90+6'   Rangers yellow card


90+8'   VAR — Goal cancelled


90+3'   Dundee substitutions


90'     James Tavernier — Penalty

This fixture should be used as the primary development/test fixture for the event timeline.

21. OTHER USEFUL FIXTURE DATA

Other downloaded Rangers event datasets include:

1382667
1382676
1382689
1382695
1382699

They provide useful variation.

Examples include:

1382667

Contains:

Rangers goal
Motherwell goal
yellow cards
substitutions
1382676

Contains:

Dundee goal
Rangers penalty
Rangers red card
yellow cards
VAR goal cancellation
substitutions
1382689

Contains:

VAR goal cancellation
yellow cards
substitutions
1382695

Contains:

Hearts goals
Rangers yellow cards
substitutions
1382699

Contains:

Rangers goal
Livingston goal
penalty confirmation
VAR goal cancellation
yellow cards
substitutions

These are useful for ensuring the event UI isn't accidentally designed around one unusual fixture.

22. FIXTURE EVENTS DATA

The API-Football event data contains records such as:

{
"time": {
"elapsed": 59,
"extra": null
},
"team": {
"id": 257,
"name": "Rangers"
},
"player": {
"id": 303322,
"name": "Nasser Djiga"
},
"type": "Card",
"detail": "Red Card"
}

Events can have different structures depending on event type.

Examples:

Goal
Card
subst
Var

Therefore the Android model should not assume every event contains the same information.

This is particularly important for:

substitutions
VAR events
cards
goals without assists
events without player IDs
23. FIXTURE DETAILS BACKEND MODEL

The backend already has:

org.footballapp.model.fixtures.FixtureDetails

with fields:

fixtureId
fixtureDate


homeTeamId
homeTeam


awayTeamId
awayTeam


homeGoals
awayGoals


venueName


leagueId
leagueName


season
round

The Android DTO mirrors these fields.

Current Android DTO:

FixtureDetailsDto

Current UiModel:

FixtureDetailsUiModel

This part of the architecture is already established.

24. FIXTURE DETAILS VIEWMODEL

Current ViewModel:

FixtureDetailsViewModel

Current state:

FixtureDetailsUiState

contains:

isLoading
fixture
lineup
error

The ViewModel currently loads:

fixture details
+
fixture lineup

The next logical extension is fixture events.

The eventual state will probably need to expose the match events as well.

Do not blindly copy an old implementation; inspect the current Repomix before making changes.

25. IMPORTANT ARCHITECTURAL CLEANUP

There was previously a small inconsistency where:

Repository
↓
DTO
↓
ViewModel
↓
UiModel

was used for Fixture Details while the rest of the application followed:

Repository
↓
UiModel
↓
ViewModel

The current code shown in the latest Android Repomix should be treated as authoritative when deciding whether that cleanup has already been completed.

The general rule remains:

Mapping belongs in the repository/data layer, not the ViewModel.

26. FIXTURE LINEUPS

Fixture Lineups are already implemented.

The backend endpoint is:

/fixtureLineup?fixtureId=...

The provider reads:

fixtures/{fixtureId}/lineups.json

The backend constructs a response containing teams and their lineup information.

The response includes information such as:

fixtureId
teamId
teamName
coachId
coachName
formation
players

This feature was migrated away from the database and is JSON-provider based.

27. LINEUP ARCHITECTURE

There are deliberately two different concepts in the backend:

org.footballapp.api.dto.lineups.FixtureLineupResponse

and:

org.footballapp.api.response.lineups.FixtureLineupResponse

They should not be merged casually.

The API DTO represents the API-Football lineup structure.

The backend response represents the response sent to Android.

This distinction was introduced intentionally.

28. SQUAD

Squad functionality is working with JSON data.

The application has been tested with realistic squad data.

Rangers has a substantial squad snapshot.

The player pipeline is:

JSON Snapshot
↓
JsonFootballDataProvider
↓
LeagueDataService
↓
PlayerMapper / PlayerDetailsMapper
↓
REST API
↓
Retrofit DTO
↓
UiModel
↓
Compose

Rangers' downloaded squad contains 47 players in the regenerated snapshot.

The Android DTO layer was hardened against nullable API-Football values.

29. SQUAD FILTERING

Squad filtering currently handles issues such as:

players transferred out before the selected season
loan players
players with valid squad numbers but zero appearances

This was tested particularly with Rangers.

Do not undo this filtering simply to make the JSON list match the raw API response.

The UI represents the selected club's relevant squad.

30. PLAYER DETAILS

Player Details is implemented.

It displays information including:

photo
nationality
date of birth
age
height
weight
captain status
appearances
starts
goals
assists
cards
minutes

Navigation is league-aware.

The player pipeline is JSON-driven.

31. CLUB DETAILS

Club Details is implemented.

It displays information such as:

club name
stadium
capacity
founded
manager/coach
fixtures
squad

Coach handling was improved so that API-Football's multiple coach records are examined and the current coach is selected appropriately.

32. LEAGUE TABLE

League Table is working.

It uses:

LeagueTableRowUiModel

and supports:

position
club
played
wins
draws
losses
goal difference
points
qualification status

The UI has been tested against JSON-backed league data.

33. LEAGUE OVERVIEW

League Overview is working.

It provides the entry point into:

League Table
Fixtures
Clubs

and associated competition information.

34. COMPETITIONS

The Competitions screen is working.

It groups competitions by country.

Example:

Scotland


Scottish Premiership
Scottish Championship
Scottish League One
Scottish League Two


Domestic Cups


Scottish Cup
League Cup

The application uses real backend competition configuration rather than relying entirely on preview data.

35. DARK MODE

App-wide dark mode has been implemented.

The original problem was that the Android theme explicitly used:

android:Theme.Material.Light.NoActionBar

This forced a light theme.

It was changed to:

android:Theme.Material.NoActionBar

and the Compose theme now uses:

DarkColorScheme
LightColorScheme

based on the system theme.

dynamicColor was removed.

Dark mode is therefore considered functional.

There may still be individual UI colours that should eventually be made more theme-aware.

36. SCREEN LAYOUT

ScreenScaffold now owns the application header.

The intended structure is:

ScreenScaffold
│
├── background
│
├── LazyColumn
│   ├── header-height spacer
│   └── screen content
│
└── fixed AppHeader

AppHeader should therefore not be independently added to individual screens.

This cleanup was completed across the major screens.

37. DATE FORMATTING

A reusable:

DateFormatter

exists on Android.

A reusable:

parseFixtureDate()

was added to centralise fixture date parsing.

Fixture dates are API dates and should not be manually parsed independently in every screen.

Team Fixtures uses formatted dates so users can understand when a fixture took place.

38. @OptIn(ExperimentalMaterial3Api::class)

If encountered during development:

@OptIn(ExperimentalMaterial3Api::class)

means that a Compose/Material 3 API being used is marked by Google as experimental.

It tells Kotlin:

"I understand that this API is experimental and I am explicitly opting into using it."

It is not an error and does not mean the application is unstable.

Only retain it where the current code actually requires an experimental Material 3 API.

39. PREVIEW DATA

There is still preview/demo data in the Android project.

For example:

PreviewData

contains Scottish competition and table information.

Some historical code and preview imports have also existed during the migration.

The important rule is:

Do not accidentally reconnect production screens to PreviewData when fixing or extending them.

Backend JSON data is now the intended development data source.

Preview data should only be retained where it has an actual purpose, such as Compose previews.

40. REPRESENTATIVE DATA LIMITATION

The development snapshot dataset is not necessarily complete for every club.

This is expected.

Historically, representative clubs were used to reduce the amount of data downloaded.

Therefore:

Club exists in league

does not necessarily mean:

complete team package exists locally

A missing snapshot may therefore produce a 404 or snapshot-not-found response.

This should not automatically be treated as an application bug.

41. DEVELOPMENT TESTING PRINCIPLE

When something appears wrong:

Do not immediately change the UI.

Use this sequence:

UI
↓
UiModel
↓
Mapper
↓
DTO
↓
REST endpoint
↓
Backend model
↓
JsonFootballDataProvider
↓
Snapshot JSON

Compare each layer.

This principle has already prevented several unnecessary changes during the project.

42. API-FOOTBALL DATA IS THE AUTHORITY

The JSON snapshots are downloaded from API-Football.

Therefore the application should generally represent what API-Football actually provides.

For example, if an API lineup contains an unusual player position:

"pos": "M"

then the Android application should not invent a different position simply because it looks unusual.

First determine whether the API data is correct.

43. CURRENT DEVELOPMENT SEASON

The primary development data currently relates to:

Season: 2025

and the main test competition is:

Scottish Premiership
League ID: 179

Rangers:

Team ID: 257

These are the main test values used during development.

However, the application should not be architecturally restricted to these values.

44. RANGERS TEST DATA

Rangers is currently the most useful development club.

Known identifiers:

Rangers
Team ID: 257


Scottish Premiership
League ID: 179


Season:
2025

Several Rangers fixtures have been downloaded with complete event data.

Rangers is therefore the preferred test club when developing:

Club Details
Squad
Team Fixtures
Fixture Details
Lineups
Match Events
45. FIXTURE DETAILS — RECOMMENDED NEXT DEVELOPMENT

The next substantial development task should be:

Match Events

Add fixture event support to the existing Fixture Details architecture.

The target event types are:

Goal
Penalty
Yellow Card
Red Card
Substitution
VAR

The UI should also correctly display added time:

90+3'
90+8'

rather than simply:

90'
46. EVENT MODEL DESIGN

Before writing the UI, inspect the actual event DTOs and JSON.

Do not assume that:

player
assist
comments
extra

will always be present.

A useful conceptual UI model might eventually contain:

minute
extraTime
teamId
teamName
playerId
playerName
assistPlayerId
assistPlayerName
type
detail
comments

But the exact model should be determined from the current backend DTO structure.

47. EVENT DISPLAY PRINCIPLE

The event timeline should be easy to scan.

For example:

51'       ⚽  Dundee
Player


59'       🟥  Rangers
Nasser Djiga


90'       ⚽  Rangers
James Tavernier
Penalty


90+8'     VAR
Goal cancelled

Substitutions may need a two-player representation:

64'       ⇄
Player OFF
Player ON

The exact presentation should be decided during implementation.

48. MATCH STATISTICS

Fixture statistics are already part of the snapshot architecture.

Fixture packages can contain:

statistics.json

Therefore Match Statistics is a natural future feature.

Potential information includes things such as:

possession
shots
shots on target
fouls
corners
offsides
passes
cards

However:

Do not begin implementing statistics simply because the data exists.

Finish the core Fixture Details / Match Centre design first.

49. GENERAL DESIGN PHILOSOPHY

An important decision emerged during the Fixtures redesign:

Do not add complexity simply because the data or technology allows it.

Examples:

Rejected

Complex league-wide fixture date navigation.

Chosen

Simple Team Fixtures month expansion.

Rejected

A complicated scroll-to-date system.

Chosen

Months that expand to reveal fixtures.

This principle should be applied throughout the application.

The goal is a football application that is:

easy to understand
quick to navigate
visually clean
useful
not overloaded with unnecessary controls
50. CURRENT SCREEN HIERARCHY

The intended user journey is approximately:

Competitions
│
▼
League Overview
│
├── League Table
│
├── Fixtures
│
└── Clubs
│
▼
Club
│
├── Squad
│      │
│      ▼
│   Player Details
│
└── Fixtures
│
▼
Fixture Details
│
├── Match Events
├── Lineups
└── Statistics

This is the important user journey.

51. NAVIGATION PRINCIPLE

Routes should carry the context required to load the requested data.

For example:

fixtureDetails/{leagueId}/{fixtureId}

rather than relying on a global development league.

Likewise:

teamFixtures/{leagueId}/{teamId}

and:

player/{leagueId}/{playerId}

This allows the application to eventually support multiple competitions properly.

52. WHAT NOT TO DO

Avoid reintroducing:

Database repositories
FixtureRepository
PlayerRepository
JDBC repositories

unless there is a specific new architectural reason.

Hardcoded development league

Avoid:

AppConstants.DEVELOPMENT_LEAGUE

being used as hidden navigation context.

DTO → UiModel mapping in ViewModels

Mapping belongs in the repository/data layer.

Hardcoded JSON paths

Use:

MockApiPaths
UI-specific date parsing

Use:

DateFormatter
Giant fixture browsing systems

Keep Team Fixtures simple.

53. OLD CODE / HISTORICAL INFORMATION

The project has undergone several large migrations.

Historical documentation may mention:

PostgreSQL
JDBC
FixtureRepository
PlayerRepository
SQL imports
database lineups
old snapshot folder structures
legacy PreviewData
hardcoded development leagues

These are historical records, not instructions to restore the old architecture.

The latest Repomix is authoritative.

54. CURRENT BACKEND ARCHITECTURE — SHORT VERSION

For quick reference:

API-Football
│
▼
JsonSnapshotService
│
▼
mockapi/
│
▼
JsonFootballDataProvider
│
▼
FootballDataProvider
│
▼
LeagueDataService
│
▼
REST Controller
55. CURRENT ANDROID ARCHITECTURE — SHORT VERSION
    REST API
    │
    ▼
    Retrofit
    │
    ▼
    DTO
    │
    ▼
    Mapper
    │
    ▼
    UiModel
    │
    ▼
    Repository
    │
    ▼
    ViewModel
    │
    ▼
    UiState
    │
    ▼
    Compose
56. CURRENTLY COMPLETED

The following are considered functional:

Backend REST API
API-Football integration
JSON snapshot architecture
JSON provider
Competition loading
League Overview
League Table
League Fixtures
Clubs
Club Details
Squad
Player Details
Team Fixtures
Fixture Details basic information
Fixture Lineups
Android navigation
Dark mode
Centralised AppHeader
Fixture date parsing/formatting
57. CURRENTLY PARTIALLY COMPLETE
    Fixture Details

Basic match information works.

Lineups work.

The screen still needs to evolve into the full Match Centre.

Missing/improvable areas:

match event timeline
goals
penalties
yellow cards
red cards
substitutions
VAR
added time
improved team/score presentation
potentially match statistics
58. CURRENTLY DEPRIORITISED
    General Fixtures Screen

Leave it alone unless a specific requirement emerges.

Complex date selector

Abandoned.

Scroll-to-date system

Abandoned.

Complete dataset for every possible club

Not currently necessary.

Database reintroduction

Not required.

59. NEXT SESSION — RECOMMENDED ORDER

When the new project begins, do not immediately start changing code.

First:

Step 1 — Establish the clean baseline

Confirm:

Backend builds
Android builds
Backend starts
Android connects
Competitions load
Step 2 — Verify Fixture Details

Use:

Fixture 1382676
Step 3 — Inspect current event architecture

Trace:

events.json
↓
JsonFootballDataProvider
↓
FootballDataProvider
↓
LeagueDataService
↓
REST endpoint

Determine exactly what already exists.

Step 4 — Add missing event layers

Only add what is actually missing.

Step 5 — Add Android event support

Follow:

DTO
↓
Mapper
↓
UiModel
↓
Repository
↓
ViewModel
↓
UiState
↓
Compose
Step 6 — Build the Match Events UI

Test against fixture 1382676.

Step 7 — Test other fixtures

Use:

1382667
1382689
1382695
1382699

to make sure the UI handles different event combinations.

60. FIRST THING TO CHECK IN THE NEW PROJECT

Before making any modifications, inspect:

FootballDataProvider
JsonFootballDataProvider
MockApiPaths
JsonLoader
LeagueDataService
FixtureDetailsController
FixtureDetails model
Fixture events DTOs
Fixture event response models

Then Android:

FixtureDetailsDto
FixtureDetailsUiModel
FixtureDetailsRepository
FixtureDetailsViewModel
FixtureDetailsUiState
FixtureDetailsScreen
FootballDestination
FootballNavHost

The purpose is to determine what already exists before creating anything new.

61. DEVELOPMENT DATA TO KEEP

The new project should retain the downloaded JSON required for development.

At minimum, keep:

Scottish Premiership
League 179
Season 2025
Rangers
Team 257

and the fixture packages:

1382667
1382676
1382689
1382695
1382699

especially:

mockapi/fixtures/1382676/events.json

because it is the best Match Events test dataset.

62. FINAL ARCHITECTURAL PRINCIPLE

The most important principle for the new project is:

Keep the architecture clean, but don't over-engineer the application.

The backend should provide football data.

The Android application should present that data.

The JSON snapshot system exists to make development reliable.

The live API provider will eventually replace the JSON provider.

And the UI should concentrate on what a football supporter actually wants to see.

63. NEW PROJECT STARTING POINT

When starting the new project, consider the state to be:

FootballApp
│
├── Backend
│   ├── Spring Boot
│   ├── FootballDataProvider
│   ├── JsonFootballDataProvider
│   ├── API-Football integration
│   └── mockapi JSON snapshots
│
└── Android
├── Jetpack Compose
├── Retrofit
├── repositories
├── mappers
├── ViewModels
├── UiStates
└── screens

The application is not starting from scratch.

The architecture is already established.

The new project is primarily intended to remove the accumulated historical clutter and make the current architecture easier to work with.

64. IMMEDIATE NEXT FEATURE
    Fixture Details → Match Centre

The first real feature after rebuilding the project should be:

Match Events.

Use:

Fixture 1382676

and its downloaded:

events.json

as the primary test case.

The goal is a clean Match Centre containing:

Teams
Score
Competition
Round
Date
Venue


Match Events
Goals
Penalties
Cards
Substitutions
VAR


Lineups


Later:
Match Statistics

That gives us a natural progression from the functionality already completed.

65. PROJECT STATUS AT HANDOVER

Overall: 🟢 Stable architecture / active feature development

Backend: 🟢 JSON provider architecture established

Database: 🔴 Removed / no longer part of development architecture

Android: 🟢 Core screens operational

Navigation: 🟢 Operational

Dark mode: 🟢 Operational

Team Fixtures: 🟢 Simplified and working

General Fixtures: 🟡 Deprioritised

Fixture Details: 🟡 Functional but needs Match Centre development

Fixture Lineups: 🟢 Working

Fixture Events: 🟡 Data available; UI feature to be developed

Match Statistics: 🟡 Future feature

One final note for the new project

I think deleting the old project context and starting clean is a good decision at this point. We have reached the point where the architecture is substantially different from where the project began, and the historical material is now more likely to cause confusion than help.

The key thing to carry forward is not all the old documentation. It is this relatively small set of facts:

Spring Boot backend
↓
FootballDataProvider
↓
JSON snapshots during development
↓
REST API
↓
Retrofit
↓
Repository
↓
Mapper
↓
UiModel
↓
ViewModel
↓
UiState
↓
Compose

And the next feature is:

Fixture Details
↓
Match Events
↓
Lineups
↓
Statistics

That gives us a much cleaner starting point for the new project.




