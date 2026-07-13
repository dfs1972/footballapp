package org.footballapp.model.player;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Root API-Football response for player requests.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayersApiResponse {

    private Paging paging;

    private List<PlayerResponse> response;

    public PlayersApiResponse() {
    }

    public Paging getPaging() {
        return paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }

    public List<PlayerResponse> getResponse() {
        return response;
    }

    public void setResponse(
            List<PlayerResponse> response
    ) {
        this.response = response;
    }
}