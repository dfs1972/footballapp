package com.example.footballapp.ui.previews

import com.example.footballapp.ui.model.ClubDetailsUiModel
import com.example.footballapp.ui.model.CompetitionGroupUiModel
import com.example.footballapp.ui.model.CompetitionUiModel
import com.example.footballapp.ui.model.LeagueTableRowUiModel
import com.example.footballapp.ui.model.QualificationType
import com.example.footballapp.ui.model.StandingUiModel
import com.example.footballapp.ui.model.FixtureStatus
import com.example.footballapp.ui.model.FixtureUiModel
import com.example.footballapp.ui.model.FixtureDayUiModel
import com.example.footballapp.ui.model.ClubUiModel
import com.example.footballapp.ui.model.PlayerUiModel
import com.example.footballapp.ui.model.PlayerDetailsUiModel
import com.example.footballapp.ui.design.AppConstants

object PreviewData {

    // -------------------------------------------------------------------------
    // Scotland - Leagues
    // -------------------------------------------------------------------------

    val ScottishPremiership = CompetitionUiModel(
        id = AppConstants.DEVELOPMENT_LEAGUE,
        name = "Scottish Premiership",
        country = "Scotland",
        //season = "2024/25",
        logoUrl = ""
    )

    val ScottishChampionship = CompetitionUiModel(
        id = 180,
        name = "Scottish Championship",
        country = "Scotland",
        //season = "2025/26",
        logoUrl = ""
    )

    val ScottishLeagueOne = CompetitionUiModel(
        id = 181,
        name = "Scottish League One",
        country = "Scotland",
        //season = "2025/26",
        logoUrl = ""
    )

    val ScottishLeagueTwo = CompetitionUiModel(
        id = 182,
        name = "Scottish League Two",
        country = "Scotland",
        //season = "2025/26",
        logoUrl = ""
    )

    // -------------------------------------------------------------------------
    // Scotland - Domestic Cups
    // -------------------------------------------------------------------------

    val ScottishCup = CompetitionUiModel(
        id = 183,
        name = "Scottish Cup",
        country = "Scotland",
        //season = "2025/26",
        logoUrl = ""
    )

    val LeagueCup = CompetitionUiModel(
        id = 184,
        name = "League Cup",
        country = "Scotland",
        //season = "2025/26",
        logoUrl = ""
    )

    // -------------------------------------------------------------------------
    // Competition Groups
    // -------------------------------------------------------------------------

    val Scotland = CompetitionGroupUiModel(

        displayOrder = 1,

        title = "Scotland",

        headerIcon = "🏴",

        leagues = listOf(
            ScottishPremiership,
            ScottishChampionship,
            ScottishLeagueOne,
            ScottishLeagueTwo
        ),

        domesticCups = listOf(
            ScottishCup,
            LeagueCup
        )

    )

    // ---------------------------------------------------------------------
    // Standings
    // ---------------------------------------------------------------------
    val ScottishPremiershipStandings = listOf(

        StandingUiModel(
            position = 1,
            teamId = 1,
            teamName = "Celtic",
            points = 86
        ),

        StandingUiModel(
            position = 2,
            teamId = 2,
            teamName = "Rangers",
            points = 82
        ),

        StandingUiModel(
            position = 3,
            teamId = 3,
            teamName = "Hibernian",
            points = 68
        ),

        StandingUiModel(
            position = 4,
            teamId = 4,
            teamName = "Aberdeen",
            points = 61
        ),

        StandingUiModel(
            position = 5,
            teamId = 5,
            teamName = "Hearts",
            points = 59
        ),

        StandingUiModel(
            position = 6,
            teamId = 11,
            teamName = "Ross County",
            points = 33
        ),

        StandingUiModel(
            position = 7,
            teamId = 12,
            teamName = "St Johnstone",
            points = 29
        )

    )

// -----------------------------------------------------------------------------
// League Table Preview Data
// -----------------------------------------------------------------------------

    val ScottishPremiershipTable = listOf(

        LeagueTableRowUiModel(
            position = 1,
            teamId = 1,
            teamName = "Celtic",
            played = 38,
            wins = 29,
            draws = 4,
            losses = 5,
            goalDifference = 42,
            points = 91,
            qualification = QualificationType.SAFE
        ),

        LeagueTableRowUiModel(
            position = 2,
            teamId = 2,
            teamName = "Rangers",
            played = 38,
            wins = 27,
            draws = 3,
            losses = 8,
            goalDifference = 42,
            points = 84,
            qualification = QualificationType.SAFE
        ),

        LeagueTableRowUiModel(
            position = 3,
            teamId = 3,
            teamName = "Hibernian",
            played = 38,
            wins = 18,
            draws = 11,
            losses = 9,
            goalDifference = 42,
            points = 65,
            qualification = QualificationType.SAFE
        ),

        LeagueTableRowUiModel(
            position = 4,
            teamId = 4,
            teamName = "Aberdeen",
            played = 38,
            wins = 17,
            draws = 10,
            losses = 11,
            goalDifference = 42,
            points = 61,
            qualification = QualificationType.SAFE
        ),

        LeagueTableRowUiModel(
            position = 5,
            teamId = 5,
            teamName = "Hearts",
            played = 38,
            wins = 16,
            draws = 8,
            losses = 14,
            goalDifference = 42,
            points = 56,
            qualification = QualificationType.SAFE
        ),

        LeagueTableRowUiModel(
            position = 6,
            teamId = 6,
            teamName = "Motherwell",
            played = 38,
            wins = 15,
            draws = 9,
            losses = 14,
            goalDifference = 42,
            points = 54,
            qualification = QualificationType.SAFE
        ),

        LeagueTableRowUiModel(
            position = 7,
            teamId = 7,
            teamName = "St Mirren",
            played = 38,
            wins = 13,
            draws = 11,
            losses = 14,
            goalDifference = 42,
            points = 50,
            qualification = QualificationType.SAFE
        ),

        LeagueTableRowUiModel(
            position = 8,
            teamId = 8,
            teamName = "Dundee United",
            played = 38,
            wins = 13,
            draws = 9,
            losses = 16,
            goalDifference = 42,
            points = 48,
            qualification = QualificationType.SAFE
        ),

        LeagueTableRowUiModel(
            position = 9,
            teamId = 9,
            teamName = "Kilmarnock",
            played = 38,
            wins = 11,
            draws = 10,
            losses = 17,
            goalDifference = 42,
            points = 43,
            qualification = QualificationType.SAFE
        ),

        LeagueTableRowUiModel(
            position = 10,
            teamId = 10,
            teamName = "Dundee",
            played = 38,
            wins = 10,
            draws = 8,
            losses = 20,
            goalDifference = 42,
            points = 38,
            qualification = QualificationType.SAFE
        ),

        LeagueTableRowUiModel(
            position = 11,
            teamId = 11,
            teamName = "Ross County",
            played = 38,
            wins = 8,
            draws = 9,
            losses = 21,
            goalDifference = 42,
            points = 33,
            qualification = QualificationType.RELEGATION
        ),

        LeagueTableRowUiModel(
            position = 12,
            teamId = 12,
            teamName = "St Johnstone",
            played = 38,
            wins = 7,
            draws = 8,
            losses = 23,
            goalDifference = 42,
            points = 29,
            qualification = QualificationType.RELEGATION
        )

    )

    // -----------------------------------------------------------------------------
// Fixture Preview Data
// -----------------------------------------------------------------------------

    val CelticVsRangers = FixtureUiModel(

        fixtureId = 1001L,

        fixtureDate = "Sat 03 Aug 2024",

        homeTeamId = 1,
        homeTeamName = "Celtic",
        homeTeamLogo = null,

        awayTeamId = 2,
        awayTeamName = "Rangers",
        awayTeamLogo = null,

        kickOff = "15:00",

        status = FixtureStatus.SCHEDULED

    )

    val HeartsVsAberdeen = FixtureUiModel(

        fixtureId = 1002L,

        fixtureDate = "Sat 03 Aug 2024",

        homeTeamId = 5,
        homeTeamName = "Hearts",
        homeTeamLogo = null,

        awayTeamId = 4,
        awayTeamName = "Aberdeen",
        awayTeamLogo = null,

        kickOff = "15:00",

        status = FixtureStatus.SCHEDULED

    )

    val HibernianVsDundeeUnited = FixtureUiModel(

        fixtureId = 1003L,

        fixtureDate = "Sat 03 Aug 2024",

        homeTeamId = 3,
        homeTeamName = "Hibernian",
        homeTeamLogo = null,

        awayTeamId = 8,
        awayTeamName = "Dundee United",
        awayTeamLogo = null,

        kickOff = "17:30",

        status = FixtureStatus.SCHEDULED

    )

    /**
     * Postponed Game
     */
    val RossCountyVsStJohnstone = FixtureUiModel(

        fixtureId = 4,

        fixtureDate = "Sat 03 Aug 2024",

        homeTeamId = 11,
        homeTeamName = "Ross County",

        awayTeamId = 12,
        awayTeamName = "St Johnstone",

        kickOff = "19:45",

        status = FixtureStatus.POSTPONED

    )

    // Fixtures Heading
    val ScottishPremiershipFixtures = FixtureDayUiModel(

        heading = "Today - Saturday 20th June",

        fixtures = listOf(

            CelticVsRangers,

            HeartsVsAberdeen,

            HibernianVsDundeeUnited,

            RossCountyVsStJohnstone

        )

    )

    /**
     * Today's Fixtures
     */
    val TodayFixtures = FixtureDayUiModel(

        heading = "Today • Saturday 20th June",

        fixtures = listOf(

            HeartsVsAberdeen,        // LIVE

            HibernianVsDundeeUnited  // FT

        )

    )

    /**
     * Tomorrow's Fixtures
     */
    val TomorrowFixtures = FixtureDayUiModel(

        heading = "Tomorrow • Sunday 21st June",

        fixtures = listOf(

            CelticVsRangers,

            RossCountyVsStJohnstone

        )

    )

    /**
     * Live Game
     */
    val CelticVsRangersLive = FixtureUiModel(

        fixtureId = 1004L,

        fixtureDate = "Sat 03 Aug 2024",

        homeTeamId = 1,
        homeTeamName = "Celtic",

        awayTeamId = 2,
        awayTeamName = "Rangers",

        kickOff = "15:00",

        status = FixtureStatus.LIVE,

        homeScore = 2,

        awayScore = 1

    )

    /**
     * Scheduled Game
     */
    val CelticVRangers = FixtureUiModel(

        fixtureId = 1,

        fixtureDate = "Sat 03 Aug 2024",

        homeTeamId = 1,
        homeTeamName = "Celtic",

        awayTeamId = 2,
        awayTeamName = "Rangers",

        kickOff = "15:00",

        status = FixtureStatus.SCHEDULED

    )

    /**
     * Finished Game
     */
    val CelticVsRangersFinished = FixtureUiModel(

        fixtureId = 1005L,

        fixtureDate = "Sat 03 Aug 2024",

        homeTeamId = 1,
        homeTeamName = "Celtic",

        awayTeamId = 2,
        awayTeamName = "Rangers",

        kickOff = "15:00",

        status = FixtureStatus.FINISHED,

        homeScore = 3,

        awayScore = 0

    )

    /**
     * Penalty Shoot-out
     */
    val ScottishCupFinal = FixtureUiModel(

        fixtureId = 5,

        fixtureDate = "Sat 03 Aug 2024",

        homeTeamId = 1,
        homeTeamName = "Celtic",

        awayTeamId = 2,
        awayTeamName = "Rangers",

        kickOff = "15:00",

        status = FixtureStatus.PENALTIES,

        homeScore = 4,

        awayScore = 4

    )

    /**
     * Initialise Clubs
     */
    val Celtic = ClubUiModel(

        clubId = 1,

        name = "Celtic",

        shortName = "Celtic",

        badgeUrl = null,

        stadium = "Celtic Park"

    )

    val Rangers = ClubUiModel(

        clubId = 2,

        name = "Rangers",

        shortName = "Rangers",

        badgeUrl = null,

        stadium = "Ibrox Stadium"

    )

    val Hibernian = ClubUiModel(

        clubId = 3,

        name = "Hibernian",

        shortName = "Hibernian",

        badgeUrl = null,

        stadium = "Easter Road"

    )

    val Hearts = ClubUiModel(

        clubId = 4,

        name = "Heart of Midlothian",

        shortName = "Hearts",

        badgeUrl = null,

        stadium = "Tynecastle Park"

    )

    val Aberdeen = ClubUiModel(

        clubId = 5,

        name = "Aberdeen",

        shortName = "Aberdeen",

        badgeUrl = null,

        stadium = "Pittodrie Stadium"

    )

    /**
     * Clubs List
     * Initialised above.
     */
    val ScottishPremiershipClubList = listOf(

        Celtic,

        Rangers,

        Hibernian,

        Hearts,

        Aberdeen

    )

    /**
     * Club Details
     */
    val CelticDetails = ClubDetailsUiModel(

        clubId = 1,

        name = "Celtic",

        badgeUrl = null,

        league = "Scottish Premiership",

        founded = 1887,

        stadium = "Celtic Park",

        capacity = 60411,

        manager = "Brendan Rodgers"

    )

    val RangersDetails = ClubDetailsUiModel(

        clubId = 2,

        name = "Rangers",

        badgeUrl = null,

        league = "Scottish Premiership",

        founded = 1872,

        stadium = "Ibrox Stadium",

        capacity = 50817,

        manager = "Russell Martin"

    )

    /**
     * Rangers Squad
     */
    val RangersSquad = listOf(

        // Goalkeepers

        PlayerUiModel(
            playerId = 1,
            shirtNumber = 1,
            name = "Jack Butland",
            position = "Goalkeeper"
        ),

        PlayerUiModel(
            playerId = 2,
            shirtNumber = 31,
            name = "Liam Kelly",
            position = "Goalkeeper"
        ),

        // Defenders

        PlayerUiModel(
            playerId = 3,
            shirtNumber = 2,
            name = "James Tavernier",
            position = "Defender"
        ),

        PlayerUiModel(
            playerId = 4,
            shirtNumber = 4,
            name = "Robin Pröpper",
            position = "Defender"
        ),

        PlayerUiModel(
            playerId = 5,
            shirtNumber = 5,
            name = "John Souttar",
            position = "Defender"
        ),

        PlayerUiModel(
            playerId = 6,
            shirtNumber = 19,
            name = "Clinton Nsiala",
            position = "Defender"
        ),

        PlayerUiModel(
            playerId = 7,
            shirtNumber = 22,
            name = "Jefte",
            position = "Defender"
        ),

        PlayerUiModel(
            playerId = 8,
            shirtNumber = 27,
            name = "Dujon Sterling",
            position = "Defender"
        ),

        PlayerUiModel(
            playerId = 9,
            shirtNumber = 33,
            name = "Ridvan Yılmaz",
            position = "Defender"
        ),

        PlayerUiModel(
            playerId = 10,
            shirtNumber = 45,
            name = "Leon King",
            position = "Defender"
        ),

        // Midfielders

        PlayerUiModel(
            playerId = 11,
            shirtNumber = 8,
            name = "Mohamed Diomande",
            position = "Midfielder"
        ),

        PlayerUiModel(
            playerId = 12,
            shirtNumber = 10,
            name = "Nicolas Raskin",
            position = "Midfielder"
        ),

        PlayerUiModel(
            playerId = 13,
            shirtNumber = 43,
            name = "Connor Barron",
            position = "Midfielder"
        ),

        PlayerUiModel(
            playerId = 14,
            shirtNumber = 49,
            name = "Bailey Rice",
            position = "Midfielder"
        ),

        PlayerUiModel(
            playerId = 15,
            shirtNumber = 52,
            name = "Findlay Curtis",
            position = "Midfielder"
        ),

        // Forwards

        PlayerUiModel(
            playerId = 16,
            shirtNumber = 9,
            name = "Cyriel Dessers",
            position = "Attacker"
        ),

        PlayerUiModel(
            playerId = 17,
            shirtNumber = 11,
            name = "Oscar Cortés",
            position = "Attacker"
        ),

        PlayerUiModel(
            playerId = 18,
            shirtNumber = 18,
            name = "Vaclav Cerny",
            position = "Attacker"
        ),

        PlayerUiModel(
            playerId = 19,
            shirtNumber = 29,
            name = "Hamza Igamane",
            position = "Attacker"
        ),

        PlayerUiModel(
            playerId = 20,
            shirtNumber = 99,
            name = "Danilo",
            position = "Attacker"
        )

    )

    /**
     * Player Details
     */
    val JamesTavernierDetails = PlayerDetailsUiModel(

        playerId = 1,

        name = "James Tavernier",

        photoUrl = null,

        shirtNumber = 2,

        position = "Defender",

        nationality = "England",

        dateOfBirth = "31 October 1991",

        age = 34,

        height = "182 cm",

        weight = "76 kg",

        preferredFoot = "Right",

        captain = true,

        appearances = 36,

        starts = 36,

        goals = 5,

        assists = 8,

        yellowCards = 4,

        redCards = 0,

        minutesPlayed = 3142

    )

    val JackButlandDetails = PlayerDetailsUiModel(

        playerId = 2,

        name = "Jack Butland",

        photoUrl = null,

        shirtNumber = 1,

        position = "Goalkeeper",

        nationality = "England",

        dateOfBirth = "10 March 1993",

        age = 33,

        height = "196 cm",

        weight = "95 kg",

        preferredFoot = "Right",

        captain = false,

        appearances = 34,

        starts = 34,

        goals = 0,

        assists = 0,

        yellowCards = 1,

        redCards = 0,

        minutesPlayed = 3060

    )


}























