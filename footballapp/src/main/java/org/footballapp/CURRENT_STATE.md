## Current Development Direction

FootballApp has entered the **v1.0 Product Completion** phase.

The backend architecture is considered feature-complete for the current feature set. Future backend work should only be undertaken when required to support the user interface.

Development now follows two core principles:

* **Backend as Translation Layer** – the backend transforms API-Football data into application-specific models for the Android app.
* **Screen-Driven Development** – each feature begins with the design of the screen, followed by identification of the data required. Backend changes are made only when necessary.

The immediate focus is to improve and polish the existing application, starting with the Competition Selection screen, before introducing new features.

Current UI Focus

Screen:
Competition Selection

Status:
Design Phase

Goals:

• Group competitions by country.
• Separate leagues and domestic cups.
• Display European competitions separately.
• Use Material 3 cards.
• Use competition logos.
• Backend supplies CompetitionGroup models.

## Current Development Session
Date 30th June 2026

Development Focus

Development has now transitioned from backend infrastructure to Android UI implementation.

The project now follows a Component-Driven UI architecture, where reusable Compose components are created first and screens are assembled from those components.

This complements the existing project principles:

Backend as Translation Layer
Screen-Driven Development
Component-Driven UI
UI Design Decisions

The first Android screen has been designed and renamed from League Selection to Competitions.

The purpose of the screen is:

Allow the user to quickly find and enter the football competition they want to explore.

Agreed design decisions:

Material Design 3
Dark theme
Rounded cards with subtle elevation
Larger country headings
Larger competition logos (36dp)
Vertical scrolling (LazyColumn)
Permanently expanded country sections
Separate sections for:
Leagues
Domestic Cups
UEFA Competitions
Official UEFA logo to represent UEFA Competitions (instead of EU flag)
Recognition before reading
Entire competition row is clickable
Material ripple effect
Material chevron arrow
No divider lines between rows (whitespace used instead)
FootballApp Design System

A reusable design system has been introduced.

Theme

Created:

ui/theme/

AppSpacing.kt
AppDimensions.kt
AppShapes.kt
AppElevation.kt
AppTypography.kt

These define project-wide spacing, dimensions, typography and component styling.

ScreenHeader.kt was refactored to use the theme instead of hardcoded values.

Components

Created and previewed successfully:

ui/components/

✓ ScreenHeader.kt

✓ SectionHeading.kt

✓ CompetitionRow.kt

Each component includes:

Preview
Material 3 styling
Theme support
Reusable API
UI Models

Created:

ui/model/

CompetitionUiModel.kt

CompetitionType.kt

Decision:

Compose components should accept UiModels rather than individual primitive values whenever they represent a domain object.

Example:

CompetitionRow(
competition,
onClick
)

rather than passing individual strings.

This mirrors the backend architecture where DTOs are translated into application models.

Android Architecture

Current Android structure:

ui/

components/

model/

theme/

(previews planned)

This will become the foundation for all future screens.

Dependency Updates

Project updated to support Material Icons.

Added:

androidx.compose.material:material-icons-extended

via Version Catalog.

Duplicate Coil dependency removed.

Documentation Updates

Updated:

AI_CONTEXT.md
UI_GUIDELINES.md

Added Design Decisions covering:

Competitions screen
Component-Driven UI
Compose components should consume UiModels
Official UEFA branding
Reusable design system
Current Progress
Theme
✓ AppSpacing

✓ AppDimensions

✓ AppShapes

✓ AppElevation

✓ AppTypography
Components
✓ ScreenHeader

✓ SectionHeading

✓ CompetitionRow

⬜ SectionCard

⬜ InfoCard

⬜ StatisticRow

⬜ StatusChip

⬜ MatchHeader
UI Models
✓ CompetitionUiModel

✓ CompetitionType
Next Session

Immediate objective:

Create SectionCard.kt

Responsibilities:

Rounded Material 3 card
Subtle elevation
Consistent padding
Content slot (@Composable () -> Unit)
Preview containing:
SectionHeading
Multiple CompetitionRows

Once SectionCard is complete, begin assembling the first production version of CompetitionsScreen from reusable components.

Project Status

FootballApp has now moved beyond backend development and entered the UI Assembly phase.

The backend architecture is considered stable.

Future work will focus on building the Android application by composing reusable UI components into polished screens, following the agreed design system and screen-driven development process.

# CURRENT STATE (End of Session)
Project Status

FootballApp has now entered the UI Assembly phase.

The backend architecture (API layer, repositories, PostgreSQL, translation layer and REST API) is considered stable and complete for the current scope.

Development focus has shifted almost entirely to the Android application.

Architecture

The project now follows a consistent layered architecture across both backend and Android.

API-Football
│
▼
Backend Translation Layer
(Java Desktop)

        │
        ▼
REST API

        │
        ▼
Android Repository
(future)

        │
        ▼
UiModels

        │
        ▼
Compose Components

        │
        ▼
Screens

The backend remains responsible for translating API-Football data into application-friendly models.

Android never communicates directly with API-Football.

UI Design System

The reusable Compose design system is now largely complete.

Theme

Completed:

AppSpacing
AppDimensions
AppShapes
AppElevation
AppTypography

All new components should use these shared theme classes rather than hardcoded values.

UI Models

Created:

CompetitionUiModel
CompetitionGroupUiModel
CompetitionType

Decision:

Compose components should receive UiModels rather than primitive values or backend DTOs.

Example:

CompetitionRow(
competition = competition,
onClick = { ... }
)
Reusable Components

Completed:

ScreenHeader
SectionHeading
CompetitionRow
CompetitionList
SectionCard

Responsibilities:

ScreenHeader

Provides consistent screen title and subtitle.

SectionHeading

Displays section headings such as:

Leagues
Domestic Cups
UEFA Competitions
CompetitionRow

Displays one competition.

Receives:

CompetitionUiModel

Displays:

Logo
Competition name
Navigation arrow
Material ripple

Entire row is clickable.

CompetitionList

Displays a list of competitions.

Internally composes multiple CompetitionRow components.

Removes repeated row-building code from screens.

SectionCard

Generic reusable Material 3 card.

Provides:

Rounded corners
Elevation
Padding
Content slot

Contains no football-specific logic.

Preview Data

Created:

ui/previews/

PreviewData.kt

Contains sample UI data used by previews.

Currently includes:

Scottish leagues
Scottish domestic cups
Scotland CompetitionGroup

Future preview data should remain independent from production repositories.

Competitions Screen

Created first complete screen:

CompetitionsScreen

Current structure:

LazyColumn

↓

ScreenHeader

↓

SectionCard

↓

Country Heading

↓

SectionHeading

↓

CompetitionList

↓

SectionHeading

↓

CompetitionList

Current implementation uses:

PreviewData.Scotland

through

val groups = listOf(

    PreviewData.Scotland

)

This structure allows future countries to be added without modifying the screen layout.

Example:

val groups = listOf(

    PreviewData.Scotland,

    PreviewData.England,

    PreviewData.Spain,

    PreviewData.Italy,

    PreviewData.Uefa

)

Only PreviewData changes.

Screen code remains unchanged.

CompetitionGroupUiModel

Introduced:

displayOrder

to support future sorting and user customisation.

Current properties:

displayOrder

title

headerIcon

leagues

domesticCups

title intentionally replaces country, allowing support for sections such as:

UEFA Competitions
UI Architecture Principles

The following principles are now established.

Component-Driven UI

Screens are assembled from reusable components.

Stateless Components

Components receive data via parameters and expose callbacks.

They do not own application state.

UiModels

Components consume UiModels rather than primitive values or backend DTOs.

Backend as Translation Layer

Android never communicates directly with API-Football.

Recognition before Reading

Icons, logos and layout should communicate meaning before text.

Material 3

Material 3 is the design foundation throughout the application.

Current UI Package Structure
ui/

components/

model/

previews/

screens/
competitions/

theme/

Future screens will be placed under:

screens/

league/

fixtures/

team/

player/
Next Development Phase

The design system is now considered sufficiently mature.

Development will move from creating infrastructure to building FootballApp's remaining screens.

Recommended order:

1. Refine Competitions screen

2. Create ScreenScaffold component
   (shared structure for all screens)

3. Build League Overview screen

4. Build League Table screen

5. Build Fixtures screen

6. Build Fixture Details screen

7. Build Team screen

8. Build Player screen

9. Introduce ViewModels

10. Connect Android to backend REST API

11. Navigation

12. Final UI polish
    Overall Project Status

The project has reached an important milestone.

Previously, development focused on backend infrastructure:

API-Football
PostgreSQL
Import Services
Repositories
REST API

Current development is focused on delivering the user experience.

The backend is now regarded as the stable foundation that supports the Android application.

Future work will primarily consist of assembling reusable UI components into polished screens, followed by connecting those screens to the existing backend through UiModels and ViewModels.