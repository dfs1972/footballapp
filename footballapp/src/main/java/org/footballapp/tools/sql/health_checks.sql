-- ============================================================
-- FootballApp Database Health Checks
-- ============================================================



-- ------------------------------------------------------------
-- Fixtures referencing unknown venues
-- (venue_id = 0 is ignored)
-- ------------------------------------------------------------

-- Invalid Venue References

SELECT DISTINCT
    f.venue_id
FROM fixtures f
         LEFT JOIN venues v
                   ON v.id = f.venue_id
WHERE f.venue_id <> 0
  AND v.id IS NULL;


-- Invalid Team References

SELECT DISTINCT
    home_team_id
FROM fixtures f
         LEFT JOIN teams t
                   ON t.id = f.home_team_id
WHERE t.id IS NULL;

SELECT DISTINCT
    away_team_id
FROM fixtures f
         LEFT JOIN teams t
                   ON t.id = f.away_team_id
WHERE t.id IS NULL;


-- Invalid League References

SELECT DISTINCT
    league_id
FROM fixtures f
         LEFT JOIN leagues l
                   ON l.league_id = f.league_id
WHERE l.league_id IS NULL;


-- Teams With Invalid Venue

SELECT
    t.id,
    t.name,
    t.venue_id
FROM teams t
         LEFT JOIN venues v
                   ON v.id = t.venue_id
WHERE v.id IS NULL;


-- Duplicate Fixtures

SELECT
    fixture_id,
    COUNT(*)
FROM fixtures
GROUP BY fixture_id
HAVING COUNT(*) > 1;


-- Duplicate Teams

SELECT
    id,
    COUNT(*)
FROM teams
GROUP BY id
HAVING COUNT(*) > 1;


-- Duplicate Players

SELECT
    player_id,
    COUNT(*)
FROM players
GROUP BY player_id
HAVING COUNT(*) > 1;


-- Standings Without Teams

SELECT
    s.team_id
FROM standings s
         LEFT JOIN teams t
                   ON t.id = s.team_id
WHERE t.id IS NULL;


-- Player Statistics Without Player

SELECT
    ps.player_id
FROM player_statistics ps
         LEFT JOIN players p
                   ON p.player_id = ps.player_id
WHERE p.player_id IS NULL;


-- Fixture Date Check

SELECT
    fixture_id,
    fixture_date
FROM fixtures
WHERE fixture_date IS NULL
   OR fixture_date = '';


-- Team Name Duplicates

SELECT
    name,
    COUNT(*)
FROM teams
GROUP BY name
HAVING COUNT(*) > 1;


-- Venue Name Duplicates

SELECT
    name,
    COUNT(*)
FROM venues
GROUP BY name
HAVING COUNT(*) > 1;


-- League Duplicates

SELECT
    league_id,
    season,
    COUNT(*)
FROM leagues
GROUP BY league_id, season
HAVING COUNT(*) > 1;


-- Fixture Counts Per Team

SELECT

    t.name,

    COUNT(*) AS fixtures

FROM teams t

         LEFT JOIN fixtures f

                   ON t.id IN (
                               f.home_team_id,
                               f.away_team_id
                       )

GROUP BY t.name

ORDER BY fixtures DESC;


-- Record Counts

SELECT COUNT(*) FROM leagues;

SELECT COUNT(*) FROM teams;

SELECT COUNT(*) FROM venues;

SELECT COUNT(*) FROM players;

SELECT COUNT(*) FROM fixtures;

SELECT COUNT(*) FROM standings;

SELECT COUNT(*) FROM player_statistics;




