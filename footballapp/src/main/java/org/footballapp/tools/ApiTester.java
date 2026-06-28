package org.footballapp.tools;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.footballapp.api.ApiFootballClient;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

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
     * Root folder for saved API responses.
     */
    private static final String OUTPUT_FOLDER =
            "api-tests";

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
     * Converts raw JSON into a Java object.
     */
    protected Object readJson(
            String json
    ) throws Exception {

        return mapper.readValue(
                json,
                Object.class
        );
    }

    /**
     * Converts a Java object into
     * formatted JSON.
     */
    protected String formatJson(
            Object jsonObject
    ) throws Exception {

        return mapper.writeValueAsString(
                jsonObject
        );
    }

    /**
     * Returns the response size in bytes.
     */
    protected int getResponseSize(
            String json
    ) {

        return json.getBytes().length;
    }

    /**
     * Prints a response summary.
     */
    protected void printSummary(

            String endpoint,

            long elapsedTime,

            int responseSize

    ) {

        System.out.println();

        System.out.println(
                "Endpoint : " + endpoint
        );

        System.out.println(
                "Time     : "
                        + elapsedTime
                        + " ms"
        );

        System.out.println(
                "Size     : "
                        + responseSize
                        + " bytes"
        );

        printSeparator();
    }

    /**
     * Prints formatted JSON
     * returned by an endpoint.
     */
    /**
     * Prints formatted JSON returned by an endpoint.
     */
    public void print(
            String endpoint
    ) throws Exception {

        ApiTestResult result =
                execute(
                        endpoint
                );

        printBanner();

        printSummary(

                result.getEndpoint(),

                result.getElapsedTime(),

                result.getResponseSize()

        );

        System.out.println();

        System.out.println(
                result.getFormattedJson()
        );

        printSeparator();
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

    /**
     * Executes an API request and returns the result.
     *
     * @param endpoint API endpoint
     * @return Test result
     */
    private ApiTestResult execute(
            String endpoint
    ) throws Exception {

        long start =
                System.currentTimeMillis();

        String json =
                getJson(
                        endpoint
                );

        long elapsed =
                System.currentTimeMillis()
                        - start;

        Object jsonObject =
                readJson(
                        json
                );

        String formatted =
                formatJson(
                        jsonObject
                );

        ApiTestResult result =
                new ApiTestResult();

        result.setEndpoint(
                endpoint
        );

        result.setJson(
                json
        );

        result.setFormattedJson(
                formatted
        );

        result.setElapsedTime(
                elapsed
        );

        result.setResponseSize(
                getResponseSize(
                        json
                )
        );

        result.setTimestamp(
                getTimestamp()
        );

        result.setValid(
                false
        );

        result.setValidationMessage(
                "Not validated"
        );

        return result;
    }

    /**
     * Builds the relative output path.
     */
    private String buildRelativePath(
            String endpoint,
            String filename
    ) {

        String endpointGroup =
                endpoint.split("\\?")[0]
                        .replace("/", "-");

        return "OUTPUT_FOLDER"
                + File.separator
                + endpointGroup
                + File.separator
                + LocalDate.now()
                + File.separator
                + filename;
    }

    /**
     * Creates the output folder for an endpoint.
     *
     * Folder structure:
     *
     * api-tests/
     *      teams/
     *          2026-06-29/
     *
     *      players/
     *          2026-06-29/
     */
    private File buildOutputFolder(
            String endpoint
    ) {

        String endpointGroup =
                endpoint.split("\\?")[0]
                        .replace("/", "-");

        File folder =
                new File(
                        "OUTPUT_FOLDER"
                                + File.separator
                                + endpointGroup
                                + File.separator
                                + LocalDate.now()
                );

        if (!folder.exists()) {

            folder.mkdirs();
        }

        return folder;
    }

    /**
     * Builds a timestamped filename.
     */
    private String buildFilename(
            String endpoint
    ) {

        String timestamp =
                LocalDateTime.now()
                        .format(
                                DateTimeFormatter.ofPattern(
                                        "yyyyMMdd_HHmmss"
                                )
                        );

        String parameters = "";

        if (endpoint.contains("?")) {

            parameters =
                    endpoint.substring(
                                    endpoint.indexOf('?') + 1
                            )
                            .replace("=", "")
                            .replace("&", "_")
                            .replace("/", "_");
        }

        if (!parameters.isEmpty()) {

            return timestamp
                    + "_"
                    + parameters
                    + ".json";
        }

        return timestamp + ".json";
    }

    /**
     * Builds the output file.
     */
    private File buildOutputFile(
            String endpoint
    ) {

        return new File(

                buildOutputFolder(
                        endpoint
                ),

                buildFilename(
                        endpoint
                )
        );
    }

    /**
     * Saves formatted JSON to disk.
     */
    private void saveResult(
            ApiTestResult result
    ) throws Exception {

        File output =
                buildOutputFile(
                        result.getEndpoint()
                );

        mapper.writeValue(

                output,

                readJson(
                        result.getJson()
                )
        );

        result.setOutputFile(

                buildRelativePath(

                        result.getEndpoint(),

                        output.getName()

                )
        );
    }

    /**
     * Saves and prints an endpoint.
     */
    public void saveAndPrint(
            String endpoint
    ) throws Exception {

        ApiTestResult result =
                execute(
                        endpoint
                );

        saveResult(
                result
        );

        printBanner();

        printSummary(

                result.getEndpoint(),

                result.getElapsedTime(),

                result.getResponseSize()

        );

        System.out.println();

        System.out.println(
                result.getFormattedJson()
        );

        System.out.println();

        System.out.println(
                "Saved:"
        );

        System.out.println(
                result.getOutputFile()
        );

        printSeparator();
    }

}