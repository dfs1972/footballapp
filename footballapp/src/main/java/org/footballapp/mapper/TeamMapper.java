package org.footballapp.mapper;

import org.footballapp.model.teams.Team;
import org.footballapp.model.teams.TeamResponse;
import org.footballapp.model.teams.TeamsApiResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TeamMapper {

    public List<Team> toTeams(
            TeamsApiResponse response
    ) {

        List<Team> teams =
                new ArrayList<>();

        if (response == null
                || response.getResponse() == null) {

            return teams;

        }

        for (TeamResponse teamResponse
                : response.getResponse()) {

            if (teamResponse.getTeam() != null) {

                Team team =
                        teamResponse.getTeam();

                if (teamResponse.getVenue() != null) {

                    team.setVenueId(
                            teamResponse
                                    .getVenue()
                                    .getId()
                    );

                }

                teams.add(
                        team
                );

            }

        }

        return teams;

    }

}