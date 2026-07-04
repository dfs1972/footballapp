# UI_GUIDELINES.md

# FootballApp UI Guidelines

## Design Philosophy

FootballApp is designed as a modern football companion application.

The objective is not to display every available statistic, but to present football information in a way that is:

- clean
- calm
- consistent
- immediately recognisable
- easy to navigate

The UI should always prioritise user experience over displaying more data.

---

# Core Principles

## Recognition before Reading

Users should recognise information before they need to read it.

Examples:

- competition logos
- club badges
- national flags
- typography hierarchy
- spacing
- colour

Visual recognition should always take priority over additional text.

---

## Progressive Disclosure

Screens should reveal information gradually.

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

Users should never feel overwhelmed.

Each screen answers one primary question.

---

## Meaningful Colour

Colour communicates information.

Never use colour simply for decoration.

Examples:

✓ Champion

✓ Relegation

✓ Errors

Avoid colouring information that has no additional meaning.

Subtle colour is preferred over strong colour.

---

## Simplicity

When several designs are possible, prefer the simpler solution.

Avoid:

- unnecessary statistics
- duplicated information
- excessive buttons
- multiple competing colours

Football supporters already understand football.

The application should assist rather than explain.

---

## Consistency

Navigation should always feel familiar.

Users should never need to learn different interaction patterns on different screens.

Consistent:

- spacing
- typography
- card design
- navigation
- icons
- colours

---

# Visual Identity

FootballApp uses a calm, modern visual style.

Characteristics:

- rounded cards
- soft elevation
- subtle colours
- generous whitespace
- minimal dividers
- Material 3

The interface should feel polished without drawing attention to itself.

---

# Layout Principles

Every screen should follow approximately the same hierarchy.

```
Screen Header

↓

Primary Content

↓

Secondary Content

↓

Navigation
```

Screens should avoid unnecessary nesting.

---

# Component Philosophy

Compose components should have a single responsibility.

Examples:

```
ScreenScaffold

Responsible for:

- scrolling
- overall layout
- screen header
```

```
SectionCard

Responsible for:

- grouped content
```

```
NavigationCard

Responsible for:

- navigating to another screen
```

```
LeagueTableRow

Responsible for:

- displaying one team
```

Components should not:

- load data
- contain business logic
- understand API models

---

# Screen Design Workflow

Every new screen follows the same workflow.

1. Discuss purpose.
2. Create ASCII wireframe.
3. Identify reusable components.
4. Create UiModels.
5. Create PreviewData.
6. Build components.
7. Assemble screen.
8. Preview.
9. Polish.
10. Connect backend.

This process should be followed for all future screens.

---

# Theme

Use project theme values.

Never hardcode:

- spacing
- typography
- corner radius
- elevation

Current theme objects:

```
AppSpacing

AppDimensions

AppShapes

AppElevation

AppTypography
```

---

# Strings

Visible UI text should come from:

```
Strings.kt
```

Avoid hardcoded text inside components.

---

# UiModels

Screens and components consume UiModels.

Never pass backend DTOs directly into Compose UI.

UiModels represent presentation data.

---

# PreviewData

PreviewData exists to support UI development.

Purpose:

- Compose previews
- screen design
- component previews
- layout testing

PreviewData should not contain application logic.

---

# Cards

Cards should:

- have rounded corners
- use subtle elevation
- avoid heavy borders
- group related information

Cards should never feel cluttered.

---

# Navigation

Navigation should use NavigationCard.

Avoid using large buttons for navigation where a card is more appropriate.

Navigation should feel lightweight.

---

# League Table

The League Table is one of the primary screens of FootballApp.

## Header

Displays:

- Team
- Played
- Wins
- Draws
- Losses
- Points

Headers align with their corresponding data.

---

## Team Identification

Each row displays:

- league position
- club badge
- team name

Recognition before reading.

---

## Qualification

Champion:

- subtle green row tint

Relegation / Play-off:

- subtle red row tint

Safe teams:

- standard background

European qualification:

- indicated by a subtle divider

Avoid excessive colour.

---

## Tables

Football tables should:

- maximise readability
- minimise clutter
- avoid unnecessary grid lines
- align columns consistently
- keep statistics right aligned

Spacing should support quick visual scanning.

---

# Typography

Use Material 3 typography.

Hierarchy:

```
Headline

↓

Title

↓

Body

↓

Label
```

Avoid introducing additional font sizes.

---

# Icons

Icons should support recognition.

Avoid decorative icons.

Use icons only where they improve usability.

---

# Images

Competition logos

Club badges

Country flags

Player photos

should be displayed wherever practical.

Images improve recognition significantly.

---

# Dividers

Use dividers sparingly.

Prefer whitespace wherever possible.

Dividers should separate information, not decorate it.

---

# Future Screens

Future screens should reuse existing components whenever practical.

Prefer composition over duplication.

Before creating a new component, ask:

"Can an existing component be reused?"

---

# When In Doubt

Prefer:

- simplicity over complexity
- subtlety over decoration
- recognition over reading
- consistency over novelty
- composition over duplication
- reusable components over screen-specific code

The best UI is one that feels obvious to use.