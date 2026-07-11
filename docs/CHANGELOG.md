## Project Status

Backend:
✅ Complete

Compose Design System:
✅ Complete

Production Screens:
- Competitions
- League Overview
- League Table

Current Focus:
Fixtures Screen

# CHANGELOG.md

# FootballApp Changelog

All notable project milestones are recorded here.

---

# 2026

## June 2026

### Backend

Completed the Java desktop backend.

Completed:

- API-Football integration
- PostgreSQL database
- Import services
- Repository layer
- League, Team, Venue, Standings and Fixture support
- Backend architecture stabilised

The backend now acts as the translation layer between API-Football and the Android application.

---

## July 2026

### Android Redesign Begins

Started a complete redesign of the Android application using Jetpack Compose and Material 3.

Established:

- new UI architecture
- reusable component library
- design system
- preview-driven workflow

Created:

- ScreenScaffold
- ScreenHeader
- SectionCard
- NavigationCard
- CompetitionRow
- CompetitionList
- SectionHeading

Introduced:

- PreviewData
- UiModels
- AppSpacing
- AppShapes
- AppElevation
- AppTypography

---

## August 2026

### Competition Screens

Completed production versions of:

- Competitions Screen
- League Overview Screen

Introduced:

- NavigationCard
- TopStandingsCard
- CompetitionUiModel
- CompetitionGroupUiModel

Established the new application navigation hierarchy.

---

### League Table Redesign

Completed a complete redesign of the League Table.

Created:

- LeagueTableRowUiModel
- QualificationType
- LeagueTableHeader
- LeagueTableRow
- LeagueTableCard
- TableDivider

Design improvements:

- Team badges
- Champion row highlighting
- Relegation row highlighting
- European qualification divider
- Simplified table layout
- Improved spacing and alignment
- "Team" header replacing "Club"

The League Table now follows the FootballApp design language and reusable component architecture.

---

### Documentation

Reorganised project documentation.

AI_CONTEXT.md

- rewritten
- architecture documented
- development philosophy documented

UI_GUIDELINES.md

- completely rewritten
- visual language documented
- component philosophy documented
- screen workflow documented

CURRENT_STATE.md

- simplified
- now records only current work and immediate next tasks

CHANGELOG.md

- converted into a milestone-based project history.

---

## Next Milestone

Fixtures Screen redesign.

Followed by:

- Teams
- Team Details
- Player Details
- Live data integration
- ViewModels