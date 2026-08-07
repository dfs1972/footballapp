package org.footballapp.mapper;

import org.footballapp.model.coaches.Coach;
import org.footballapp.model.coaches.CoachApiResponse;
import org.footballapp.model.coaches.CoachCareer;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CoachMapper {

    /**
     * Returns the current head coach for a club.
     *
     * Selection rules:
     * - Career belongs to the requested club.
     * - Career has no end date.
     * - Most recent start date wins.
     */
    public Coach getCurrentCoach(
            CoachApiResponse response,
            int teamId
    ) {

        if (response == null
                || response.getResponse() == null
                || response.getResponse().isEmpty()) {

            return null;

        }

        Coach currentCoach = null;

        LocalDate latestStart = LocalDate.MIN;

        for (Coach coach : response.getResponse()) {

            if (coach.getCareer() == null) {
                continue;
            }

            for (CoachCareer career : coach.getCareer()) {

                if (career.getTeam() == null) {
                    continue;
                }

                if (career.getTeam().getId() != teamId) {
                    continue;
                }

                if (career.getEnd() != null) {
                    continue;
                }

                if (career.getStart() == null) {
                    continue;
                }

                LocalDate start =
                        LocalDate.parse(
                                career.getStart()
                        );

                if (start.isAfter(latestStart)) {

                    latestStart = start;

                    currentCoach = coach;

                }

            }

        }

        if (currentCoach != null) {

            System.out.println(
                    "Selected coach = "
                            + currentCoach.getFirstname()
                            + " "
                            + currentCoach.getLastname()
            );

        } else {

            System.out.println(
                    "No current coach found."
            );

        }

        return currentCoach;

    }

}