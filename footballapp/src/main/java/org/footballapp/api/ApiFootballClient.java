package org.footballapp.api;

import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.net.URI;
import java.net.http.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * Handles all HTTP communication with API-Football.
 *
 * Sends requests to API-Football endpoints and returns
 * the raw JSON response to the service layer.
 */

public class ApiFootballClient {

    private final String apiKey;
    private final HttpClient client;
    private final ApiRateLimiter rateLimiter;

    private static final AtomicInteger requestCount =
            new AtomicInteger();

    private static final long CACHE_TTL_MS = 3000;
    private final Map<String, CachedResponse> cache = new ConcurrentHashMap<>();

    private record CachedResponse(String body, long timestamp) {}

    public ApiFootballClient(
            String apiKey,
            ApiRateLimiter rateLimiter
    ) {
        this.apiKey = apiKey;
        this.rateLimiter = rateLimiter;
        this.client = HttpClient.newHttpClient();
    }

    /*
     * Sends a GET request to the specified API-Football endpoint
     * and returns the response body as a JSON string.
     */

    public String get(String url) throws IOException, InterruptedException {

        CachedResponse cached = cache.get(url);
        if (cached != null && (System.currentTimeMillis() - cached.timestamp < CACHE_TTL_MS)) {
            System.out.printf("[CACHE] %s%n", url);
            return cached.body;
        }

        System.out.printf(
                "[%03d] %s%n",
                requestCount.incrementAndGet(),
                url
        );

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("x-apisports-key", apiKey)
                .header("x-rapidapi-host", "v3.football.api-sports.io")
                .GET()
                .build();

        while (true) {

            HttpResponse<String> response =
                    client.send(
                            request,
                            HttpResponse.BodyHandlers.ofString()
                    );

            rateLimiter.processHeaders(
                    response.headers()
            );

            String body =
                    response.body();

            /**  TEST PRINT ****/
            System.out.println(body);

            if (!body.contains("\"rateLimit\"")) {
                cache.put(url, new CachedResponse(body, System.currentTimeMillis()));
                return body;
            }

            System.out.println();
            System.out.println("API rate limit reached.");
            System.out.println("Waiting 60 seconds before retry...");
            System.out.println();

            Thread.sleep(60_000);
        }}

    @Bean
    public ApiFootballClient apiFootballClient(
            ApiRateLimiter apiRateLimiter
    ) {

        String apiKey =
                System.getenv("API_FOOTBALL_KEY");

        if (apiKey == null || apiKey.isBlank()) {

            throw new IllegalStateException(
                    "API_FOOTBALL_KEY environment variable is not configured."
            );
        }

        return new ApiFootballClient(
                apiKey,
                apiRateLimiter
        );
    }
}