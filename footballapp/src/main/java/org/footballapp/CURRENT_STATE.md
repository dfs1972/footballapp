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