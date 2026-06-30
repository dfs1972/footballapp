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
