package org.footballapp.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.*;

public class ApiFootballClient {

    private final String apiKey;
    private final HttpClient client;

    public ApiFootballClient(String apiKey) {
        this.apiKey = apiKey;
        this.client = HttpClient.newHttpClient();
    }

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