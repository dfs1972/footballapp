DEVELOPMENT_TOOLKIT.md
FootballApp Development Toolkit
Purpose

The Development Toolkit provides a fast and repeatable way to explore API-Football endpoints without requiring database imports or Android integration.

Its primary goals are to:

Download API responses for development.
Archive real JSON responses.
Build DTOs from actual API data.
Create PreviewData for Compose screens.
Develop and test UI independently of the backend.
Reduce unnecessary API requests during development.

The toolkit complements the production backend—it does not replace it.

Architecture

The FootballApp project now consists of three independent layers.

Production Backend

Controller
↓
Service
↓
Repository
↓
PostgreSQL
Development Toolkit

ApiExplorerRunner
↓
ApiExplorerService
↓
API-Football
↓
docs/api/
Android Application

JSON / Retrofit
↓
DTO
↓
UI Model
↓
Jetpack Compose

Each layer has a different responsibility and can evolve independently.

Package Structure
org.footballapp.tools.development

Current classes:

ApiExplorerRunner
ApiExplorerService
ApiExplorerRunner

The runner provides repeatable development downloads.

Example:

apiExplorerService.downloadLeagueData();

apiExplorerService.downloadClubData();

apiExplorerService.downloadFixtureData();

Downloads are controlled using:

private static final boolean DOWNLOAD_ENABLED = false;

This allows the runner to remain in the project without executing automatically.

ApiExplorerService

The service is organised into three logical layers.

1. Generic Download Engine

Responsible for:

Building requests
Calling API-Football
Formatting JSON
Saving JSON
Saving request URLs
Console output

Core method:

download(...)
2. Individual Endpoint Methods

Each API endpoint has a dedicated download method.

League
downloadStandings()

downloadFixtures()

downloadTeams()
Club
downloadClubDetails()

downloadPlayers()

downloadTeamStatistics()
Fixture
downloadFixtureEvents()

downloadFixtureLineups()

downloadFixtureStatistics()
3. Composite Download Methods

Composite methods group related endpoint downloads into development tasks.

League
downloadLeagueData()

Downloads:

Standings
Fixtures
Teams
Club
downloadClubData()

Downloads:

Club Details
Players
Team Statistics
Fixture
downloadFixtureData()

Downloads:

Fixture Events
Fixture Lineups
Fixture Statistics
Console Helpers

The service contains helper methods for consistent console output.

printSectionHeader(...)

printSectionFooter(...)

These remove duplicated code and provide consistent progress messages.

Development Constants

The toolkit uses centralised constants from:

org.footballapp.tools.AppConstants

Current constants:

DEVELOPMENT_LEAGUE

DEVELOPMENT_SEASON

DEVELOPMENT_TEAM

DEVELOPMENT_FIXTURE

These act as the default development dataset.

Download Structure

Downloaded JSON is archived under:

docs/api/

Current structure:

docs/api/

league/
fixtures/
standings/
teams/

club/
details/
players/
statistics/

fixture/
events/
lineups/
statistics/

Where practical, filenames include identifiers to prevent overwriting.

Examples:

team_257_2024.json

fixture_1220118.json

league_179_2024.json
Development Workflow

The recommended workflow is:

Discover Endpoint
↓
Download JSON
↓
Study Response
↓
Create DTO
↓
Create UI Model
↓
Create PreviewData
↓
Build Compose Screen
↓
Integrate Retrofit

This allows UI development to proceed independently of backend implementation.

Design Principles

The Development Toolkit follows several guiding principles.

Single Responsibility

Each method performs one task.

Generic download logic belongs in download().
Endpoint methods represent one API endpoint.
Composite methods represent one development task.
Reusability

Composite methods should reuse endpoint methods.

Example:

downloadLeagueData()

        ↓

downloadStandings()

downloadFixtures()

downloadTeams()
Consistency

New endpoints should follow the existing naming conventions.

Examples:

downloadPlayerStatistics()

downloadPlayerTransfers()

downloadCoachDetails()

Composite methods should continue the same pattern.

Examples:

downloadPlayerData()

downloadSeasonData()

downloadCompetitionData()
Separation of Concerns

The toolkit is not responsible for:

Database persistence
Repository logic
Android networking
Business logic

Its sole responsibility is to obtain and archive API responses for development.

Future Enhancements

Potential future improvements include:

Parameterised download methods
Batch season downloads
Automatic API catalogue generation
Download summaries
Response validation
Endpoint health checks
Cached download detection
API version comparison
Summary

The Development Toolkit provides a lightweight development layer that accelerates API exploration and Android UI development while remaining independent of the production backend.

It is intended to become the primary environment for investigating new API-Football endpoints before integrating them into the backend or Android application.