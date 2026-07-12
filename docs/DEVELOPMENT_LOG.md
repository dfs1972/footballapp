# Development Log

## 2026-07-07

Milestone: Club Details

Completed:
- ClubsScreen
- ClubDetailsUiModel
- ClubScreen
- ClubBadge refactor
- InfoRow
- PreviewData updates

Next:
- Squad feature

# Demo Mode Polish

## 08/07/2026

□ League table badge alignment
□ Club row badge alignment
□ Consistent spacing between badge and text
□ Verify typography hierarchy
□ Test scrolling on all screens
□ Test dark mode
□ Navigation back stack

### Navigation Milestone

Implemented Demo Mode navigation:

✓ Competitions
✓ League Overview
✓ League Table
✓ Fixtures
✓ Clubs
✓ Club Details

Remaining:

□ Squad
□ Player Details

DEVELOPMENT_LOG.md (new entry)
## July 2026 – Demo Mode Complete

### Navigation

- Completed FootballNavHost.
- Connected all major application screens.
- Standardised navigation around Club Details.
- Added Club → Squad navigation.
- Added Club → Fixtures navigation.
- Added Squad → Player Details navigation.
- Fixed Top 5 Clubs card to display five clubs.

### UI

- Refined ClubBadge sizing and alignment.
- Continued Team → Club terminology refactor.
- Completed reusable screen architecture.

### Documentation

- Added ARCHITECTURE.md.
- Reorganised project documentation into /docs.
- Moved RepoMix snapshots into /tools/repomix.

### Repository

- GitHub milestone commit created.

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

# Milestone

Completed the first fully parameterised navigation flow.

Competition selection now passes the selected leagueId through
Navigation Compose.

LeagueOverviewScreen is now populated from the Spring Boot backend
via Retrofit, Repository and ViewModel.

The app is no longer dependent on DemoData for Competition selection
or League Overview.

Only the TopStandingsCard remains on PreviewData pending the League
Table migration.