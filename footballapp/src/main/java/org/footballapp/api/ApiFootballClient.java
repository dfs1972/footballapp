package org.footballapp.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.*;

/*
 * Handles all HTTP communication with API-Football.
 *
 * Sends requests to API-Football endpoints and returns
 * the raw JSON response to the service layer.
 */

public class ApiFootballClient {

    private final String apiKey;
    private final HttpClient client;

    public ApiFootballClient(String apiKey) {
        this.apiKey = apiKey;
        this.client = HttpClient.newHttpClient();
    }

    /*
     * Sends a GET request to the specified API-Football endpoint
     * and returns the response body as a JSON string.
     */

    public String get(String url) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("x-apisports-key", apiKey)
                .header("x-rapidapi-host", "v3.football.api-sports.io")
                .GET()
                .build();

        HttpResponse<String> response = client.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );

        return response.body();
    }
}