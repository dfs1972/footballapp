# FootballApp UI Guidelines

## Purpose

This document defines the visual design principles for FootballApp.

The goal is to create a clean, modern football application that is easy to navigate and enjoyable to use.

FootballApp should prioritise clarity and usability over displaying the maximum amount of information.

---

# Design Philosophy

FootballApp is designed around one simple question:

**"What does the user want to know on this screen?"**

Each screen should answer one primary question.

Examples:

Competition Selection
→ Which competition do I want?

League Table
→ Who is top of the league?

Team
→ How is this team performing?

Player
→ How has this player performed?

Fixture
→ What happened in this match?

Avoid mixing unrelated information on the same screen.

Compose components should be stateless whenever possible.

Components receive all the data they need through parameters and communicate user interactions through callbacks (onClick, onSelected, etc.). They should not own application state or perform business logic.

---

# Visual Style

Use Material Design 3 as the foundation.

The app should feel modern, lightweight and uncluttered.

Prefer:

* Cards
* Rounded corners
* Generous spacing
* Simple typography
* Consistent iconography

Avoid:

* Overly complex layouts
* Excessive gradients
* Visual clutter

Club badges, competition logos and country flags provide enough colour without relying on decorative backgrounds.

---

# Cards

Cards are the primary presentation component.

Cards should group related information together.

Examples:

Competition cards

Fixture cards

Player cards

Statistics cards

Cards should have comfortable spacing between them.

---

# Visual Hierarchy

Each screen should have a clear reading order.

Large title

↓

Important information

↓

Supporting information

↓

Actions

The most important information should always be visible without searching.

---

# Icons and Images

Use official competition logos whenever available.

Use club badges whenever available.

Use country flags where appropriate.

Images should help users recognise information quickly rather than decorate the interface.

---

# Lists

Avoid long, unstructured lists.

Prefer grouping items into logical sections.

Example:

Scotland

LEAGUES

• Premiership

• Championship

DOMESTIC CUPS

• Scottish Cup

• League Cup

---

# Spacing

Whitespace is an important part of the design.

Screens should never feel crowded.

Comfortable spacing improves readability more than adding separators.

---

# Status Indicators

Use small status chips where appropriate.

Examples:

LIVE

FINAL

HALF TIME

SCHEDULED

POSTPONED

Status should be recognisable at a glance.

---

# Screen-Driven Development

Design the screen first.

Identify the data required.

Only then modify the backend if additional data is needed.

The user experience drives development.

---

# Version 1.0 Principles

FootballApp v1.0 focuses on quality rather than quantity.

Existing screens should be refined before introducing new features.

The objective is to build an application that football fans enjoy using rather than exposing every available API endpoint.

Future features such as lineups, transfers, injuries and historical seasons belong to later versions unless required for Version 1.0.

# Recognition before reading

Users should recognise information before they read it.

Examples:

Club badge before club name.
Competition logo before competition name.
Country flag before country name.
Status chip before status text.

# Components are UI-only

# A component should never know about:

Retrofit
REST
ViewModels
Repositories
Navigation
API models

# Compose components should accept UI models rather than individual primitive values whenever they represent a domain object (Competition, Team, Player, Fixture).

This gives us a consistent rule:

CompetitionRow → CompetitionUiModel
TeamRow → TeamUiModel
PlayerRow → PlayerUiModel
FixtureRow → FixtureUiModel