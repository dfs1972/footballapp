## Current Progress

### Backend

- Java backend imports football data into a local PostgreSQL database.
- Repository and service layers are established.
- Local database remains the primary data source during UI development.
- Future backend will expose a REST API consumed by the Android app.

### Android UI

The new Jetpack Compose UI is being developed using PreviewData before backend integration.

Completed screens:

- ✅ Competitions
- ✅ League Overview
- ✅ League Table
- ✅ Fixtures
- ✅ Clubs
- ✅ Club Details

Reusable components completed:

- ScreenScaffold
- SectionCard
- NavigationCard
- ClubRow
- ClubList
- ClubBadge
- InfoRow
- LeagueTableCard
- FixtureCard
- TopStandingsCard

UI models added:

- ClubUiModel
- ClubDetailsUiModel
- CompetitionUiModel
- FixtureUiModel
- LeagueTableRowUiModel
- StandingUiModel

Current navigation:

Competitions
→ League Overview
→ Clubs
→ Club Details

# CURRENT_STATE.md (update)
## Current Status (July 2026)
## UI
✅ Modern Jetpack Compose UI established.
✅ Reusable component library completed.
✅ Preview-driven development workflow established.
✅ Consistent UiModel layer implemented.
✅ Team → Club terminology refactor completed.
Navigation

### Demo Mode navigation is complete.

Competitions
│
▼
League Overview
┌────┼──────────────┐
▼    ▼              ▼
Table Fixtures     Clubs
│                  │
│                  ▼
└──────────────► Club Details
│
┌─────────┴─────────┐
▼                   ▼
Squad              Fixtures
│
▼
Player Details

### Documentation
Repository documentation reorganised.

docs/
AI_CONTEXT.md
ARCHITECTURE.md
CHANGELOG.md
CURRENT_STATE.md
DEVELOPMENT_LOG.md
UI_GUIDELINES.md

tools/
repomix/
Backend

### Existing Java backend remains unchanged.

PostgreSQL database
Import services
API-Football integration
Repository layer

Backend is ready for REST API integration.

## Next Milestone

Phase 2 – Connect the Android application to the backend.

Initial goals:

Introduce ViewModels.
Introduce Repository abstraction.
Replace PreviewData with ViewModel state.
Connect Android to the Spring Boot REST API.
Continue using the existing Compose UI unchanged.

## July 10th 2026 – Cloud Database Migration Complete

- Replaced hardcoded JDBC credentials with environment variables.
- Created FootballApp database on Neon.
- Migrated schema and data from local PostgreSQL.
- Verified Spring Boot REST API against Neon.
- `/leagues` endpoint successfully returning live data from cloud database.

## Live Data Integration

Completed migration of Competitions screen from PreviewData to live REST data.

Added:

- FootballApiClient
- FootballApiService
- CompetitionRepository
- CompetitionMapper
- CompetitionViewModel
- CompetitionUiState

CompetitionsScreen now retrieves competitions from the Spring Boot backend via Retrofit.

Verified end-to-end:

Android → Retrofit → Spring Boot → Neon PostgreSQL.