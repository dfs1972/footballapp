# CURRENT_STATE.md

## Current Focus

Phase 3 - Screen Migration

---

# CURRENT_STATE.md

## Current Focus

Phase 3 – Screen Migration

Current screen:

**Fixtures Screen**

---

## Completed This Session

### Fixtures

Created:

- FixtureUiModel
- FixtureDayUiModel
- FixtureStatus

Created reusable component:

- StatusChip

Created:

- FixtureCard

Created:

- FixturesScreen

Expanded PreviewData with:

- Fixture preview fixtures
- FixtureDayUiModel preview

Updated:

- AppDimensions
  - Added StatusChipWidth
  - Added StatusChipHeight
  - Began separating badge sizes

Improved:

- Horizontal FixtureCard layout
- StatusChip now uses Box() with centred text
- Home and Away teams now displayed horizontally
- FixtureCard uses reusable HomeTeam, FixtureCentre and AwayTeam composables

---

## Remaining Polish

### FixtureCard

Needs small layout adjustments:

- Home team still requires slightly more horizontal space.
- "Hibernian" currently truncates.
- Review TeamBadge size once real badges are available.
- Fine tune spacing around badges.

### SectionHeading

Current heading ("TODAY") sits too far left.

Goal:

Align section headings with the ScreenHeader title rather than the edge of the screen.

---

## Fixtures Screen

Current hierarchy:

ScreenScaffold

↓

SectionHeading

↓

FixtureCard

↓

FixtureCard

↓

FixtureCard

Screen architecture complete.

Only visual polish remains before marking screen complete.

---

## Completed Production Screens

✓ Competitions

✓ League Overview

✓ League Table

Fixtures Screen (≈95% complete)

---

# CURRENT_STATE.md

## FootballApp UI Redesign

### Current Phase

Phase 3 – Screen Migration & UI Polish

---

# Overall Progress

## Completed Screens

✅ Competitions

✅ League Overview

✅ League Table

## Current Screen

🟡 Fixtures Screen (≈95% complete)

Architecture complete.

Currently undergoing final UI polish.

---

# Major Change This Session

The original FixtureCard design displayed:

[Home Logo] [Home Team] [Status] [Away Team] [Away Logo]

After extensive preview testing this proved unsuitable for mobile phones because:

- long team names became truncated
- logos consumed valuable horizontal space
- spacing never looked balanced
- mirrored layout was difficult to scan

The design has now been simplified.

---

# New FixtureCard Design

Current direction:

┌──────────────────────────────────────────┐
│ Celtic                     [15:00]       │
│ Rangers                                  │
└──────────────────────────────────────────┘

Material 3 card.

Rounded corners.

StatusChip aligned on the right.

Two-line fixture layout inspired by modern football apps (OneFootball/FotMob), while keeping FootballApp's own design language.

Benefits:

- long club names fit naturally
- no badge spacing issues
- cleaner visual hierarchy
- scalable for live scores

---

# FixtureCard

Removed:

- Team badges
- HomeTeam composable
- AwayTeam composable

Current hierarchy:

SectionCard

↓

Column (Home / Away)

↓

FixtureCentre

FixtureCentre now acts as the fixed right-hand column.

---

# TeamBadge

Created reusable TeamBadge component.

Currently retained for:

- League Table
- Teams Screen
- Team Details

Removed from Fixtures list.

Placeholder behaviour remains available.

---

# Competitions Screen

Migrated to ScreenScaffold.

Now consistent with:

- League Overview
- League Table
- Fixtures

All major screens now share:

ScreenScaffold

↓

ScreenHeader

↓

Screen Content

---

# Design System

Reusable components now include:

- ScreenScaffold
- ScreenHeader
- SectionCard
- SectionHeading
- NavigationCard
- CompetitionRow
- CompetitionList
- TopStandingsCard
- LeagueTableHeader
- LeagueTableRow
- LeagueTableCard
- TableDivider
- StatusChip
- FixtureCard
- TeamBadge

---

# Remaining Fixtures Polish

Minor refinements only:

- Fine tune spacing between fixture text and StatusChip.
- Review card padding.
- Check typography hierarchy (Home vs Away team).
- Review StatusChip width if necessary.

No architectural changes expected.

---

# Next Screen

Once Fixtures is complete:

Teams Screen

Planned workflow:

Purpose

↓

ASCII wireframe

↓

UiModel

↓

PreviewData

↓

Components

↓

Screen

↓

Preview

↓

Polish

---

# UI Philosophy

FootballApp now follows these principles:

- Information-first.
- Material 3.
- Consistent spacing.
- Minimal clutter.
- Components over duplication.
- Preview-driven development.
- Backend-independent UI.

---

# Notes

A key design decision was made during this session:

Not every screen benefits from club badges.

Badges remain valuable for:

- League Table
- Teams
- Team Details

but were intentionally removed from the Fixtures list to maximise readability and support long club names.

This gives each screen a clearer purpose and a more focused information hierarchy.

# CURRENT_STATE.md

## FootballApp UI Redesign

### Current Progress

## Completed Screens

✅ Competitions Screen

✅ League Overview Screen

✅ League Table Screen

✅ Fixtures Screen

---

## Fixtures Screen

Completed and considered feature complete.

### Final Design

- Two-line fixture layout.
- Home team above away team.
- StatusChip aligned on the right.
- Material 3 card design.
- Day headings displayed as:
  - Today • Saturday 20 June
  - Tomorrow • Sunday 21 June
  - etc.

### PreviewData

Fixture previews now include:

- Scheduled
- Live
- Finished
- Postponed

This allows all major fixture states to be previewed without backend integration.

### Design Decision

Club badges were intentionally removed from the Fixtures list.

Reason:

- maximise horizontal space
- support long club names
- improve readability
- reserve branding for Team and Fixture Details screens

---

## UI Framework

Reusable components now include:

- ScreenScaffold
- ScreenHeader
- SectionCard
- SectionHeading
- NavigationCard
- CompetitionList
- TopStandingsCard
- LeagueTableCard
- LeagueTableRow
- LeagueTableHeader
- TableDivider
- FixtureCard
- StatusChip
- TeamBadge

The reusable UI component library is now largely established.

---

## Next Session

Begin **Teams Screen**.

Planned workflow:

1. Define purpose of Teams Screen.
2. Produce ASCII wireframe.
3. Create TeamUiModel.
4. Expand PreviewData.
5. Build reusable TeamRow component.
6. Build TeamList component.
7. Build TeamsScreen.
8. Polish and preview.

---

## Design Philosophy

Each screen should answer one primary question.

Competitions:
"What competition do I want?"

League Overview:
"What can I explore?"

League Table:
"Where does every team stand?"

Fixtures:
"What fixtures are on today (or another day)?"

Teams:
"What clubs compete in this league?"

Additional detail belongs on the next level of navigation rather than cluttering list screens.