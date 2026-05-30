package org.footballapp.model.teams;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/** returns the full "response" json of teams in Scottish Premiership,
 *  for specified season.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamsApiResponse {

    private List<TeamResponse> response;

    public TeamsApiResponse() {
    }

    public List<TeamResponse> getResponse() {
        return response;
    }

    public void setResponse(List<TeamResponse> response) {
        this.response = response;
    }
}