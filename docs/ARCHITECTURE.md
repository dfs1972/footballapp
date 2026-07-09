# FootballApp Architecture

## Overview

FootballApp is a full-stack football application consisting of three
major parts:

```
                API-Football
                      │
                      ▼
              Spring Boot Backend
                      │
                      ▼
             PostgreSQL Database
                      │
                      ▼
             REST API (JSON)
                      │
                      ▼
          Android Application (Compose)
```

The backend is responsible for data collection, storage and business
logic.

The Android application is responsible for presentation, navigation
and user interaction.

---

# Android Architecture

The Android application follows a layered architecture.

```
MainActivity
      │
      ▼
FootballNavHost
      │
      ▼
Screens
      │
      ▼
Reusable Components
```

Future versions will introduce ViewModels between the screens and the
repository layer.

```
Screen
   │
   ▼
ViewModel
   │
   ▼
Repository
   │
   ▼
REST API
```

---

# UI Package Structure

```
ui/

components/
navigation/
model/
previews/
screens/
theme/
```

Each screen is organised into its own package.

Example:

```
screens/

competitions/
league/
fixtures/
clubs/
club/
squad/
player/
```

---

# Navigation

The application uses Navigation Compose.

Current navigation flow:

```
Competitions
      │
      ▼
League Overview
 ┌────┼────┐
 ▼    ▼    ▼
Table Fixtures Clubs
                  │
                  ▼
             Club Details
                  │
                  ▼
                Squad
                  │
                  ▼
           Player Details
```

---

# UI Design Principles

The application is built around reusable Compose components.

Examples include:

- ScreenScaffold
- SectionCard
- NavigationCard
- ClubBadge
- PlayerRow
- InfoRow
- SectionHeading

Screen composables should remain lightweight by composing reusable
building blocks.

---

# Preview-Driven Development

Every reusable component includes a Preview where practical.

PreviewData supplies realistic sample data allowing screens to be
developed independently of the backend.

Demo Mode provides complete application navigation using PreviewData.

---

# Backend (Planned Integration)

The Android application will consume a Spring Boot REST API.

```
Compose Screen
      │
ViewModel
      │
Repository
      │
REST API
      │
Spring Boot
      │
PostgreSQL
```

PreviewData will gradually be replaced by ViewModels backed by the REST
API.

---

# Design Goals

- Clean Architecture
- Reusable UI Components
- Preview-driven development
- Offline-friendly historical data
- Responsive navigation
- Scalable backend