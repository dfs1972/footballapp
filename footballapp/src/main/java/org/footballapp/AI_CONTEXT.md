FootballApp Architecture

Backend

- Java 25
- Spring Boot
- PostgreSQL

Database is the primary source of data.

API-Football is used ONLY to import/update data.

Android NEVER connects directly to API-Football.

-------------------------------------

Layers

API-Football

↓

ApiFootballService

↓

Import Services

↓

Repositories

↓

PostgreSQL

↓

LeagueDataService

↓

REST Controllers

↓

Android Repository

↓

Compose UI

-------------------------------------

Repository Pattern

One repository per table.

Repositories never call the API.

Repositories only access PostgreSQL.

-------------------------------------

Import Pattern

One import service per endpoint.

Import services call ApiFootballService.

Import services save via repositories.

-------------------------------------

REST Pattern

Controllers never access repositories directly.

Controllers always call LeagueDataService.

-------------------------------------

Android Pattern

Android never calls API-Football.

Android only calls the Spring REST API.

Android contains:

Model

Repository

ViewModel

Compose Screen

-------------------------------------

Naming Conventions

Repository

...Repository

Import Service

...ImportService

Controller

...Controller

Android Model

Same as backend REST model.

-------------------------------------

Development Workflow

1. Explore endpoint with ApiTester.

2. Create API model.

3. Import service.

4. Repository.

5. LeagueDataService.

6. REST Controller.

7. Android model.

8. Android repository.

9. ViewModel.

10. Compose UI.

## REST API Conventions

* Android communicates only with the FootballApp Spring REST API.
* Android never communicates directly with API-Football.
* API-Football is used exclusively by the backend import services.
* REST controllers expose backend data from PostgreSQL.
* Controllers call `LeagueDataService`; they do not access repositories directly.
* Each controller is responsible for a single feature area (Leagues, Teams, Fixtures, Players, Team Statistics, etc.).
* Follow the existing URL conventions already established in the project when creating new endpoints.

## UI First Principle

FootballApp v1.0 is developed from the user's perspective. Screens are designed first, data requirements are identified second, and backend changes are made only when the UI genuinely needs additional data.

## Backend as Translation Layer

The backend is responsible for transforming API-Football data into models that best suit the FootballApp UI. Android should consume application-specific models and should not contain logic to reorganise or reinterpret API data.

Screen-Driven Development

FootballApp development begins with the user interface.

For every new feature:

1. Design the screen.

2. Identify the data required.

3. Use existing backend services whenever possible.

4. Only extend the backend if the UI genuinely requires additional data.

The goal is to minimise unnecessary backend work while maximising user value.
