package org.footballapp.tools;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.footballapp.api.ApiFootballClient;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Developer utility for inspecting API-Football endpoints.
 *
 * ApiTester allows endpoints to be tested independently
 * of the import services and repositories.
 *
 * Version 1.0
 */
public class ApiTester {

    /**
     * API base URL.
     */
    private static final String BASE_URL =
            "https://v3.football.api-sports.io/";

    /**
     * Console separator.
     */
    private static final String SEPARATOR =
            "============================================================";

    /**
     * API client.
     */
    private final ApiFootballClient client;

    /**
     * Jackson mapper used for pretty-printing JSON.
     */
    private final ObjectMapper mapper;

    /**
     * Creates a new ApiTester instance.
     */
    public ApiTester() {

        String apiKey =
                System.getenv("API_FOOTBALL_KEY");

        client =
                new ApiFootballClient(apiKey);

        mapper =
                new ObjectMapper();

        mapper.enable(
                SerializationFeature.INDENT_OUTPUT
        );
    }

    /**
     * Downloads raw JSON from an endpoint.
     *
     * @param endpoint API endpoint
     * @return Raw JSON
     */
    protected String getJson(
            String endpoint
    ) throws Exception {

        String url =
                BASE_URL + endpoint;

        return client.get(url);
    }

    /**
     * Prints the ApiTester banner.
     */
    protected void printBanner() {

        System.out.println();
        System.out.println(SEPARATOR);
        System.out.println("FootballApp API Tester");
        System.out.println(SEPARATOR);
    }

    /**
     * Prints a separator.
     */
    protected void printSeparator() {

        System.out.println(SEPARATOR);
    }

    /**
     * Returns the current timestamp.
     */
    protected String getTimestamp() {

        return LocalDateTime.now()
                .format(
                        DateTimeFormatter.ofPattern(
                                "yyyy-MM-dd HH:mm:ss"
                        )
                );
    }

}