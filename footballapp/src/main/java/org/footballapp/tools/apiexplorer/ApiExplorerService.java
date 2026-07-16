package org.footballapp.tools.apiexplorer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.footballapp.api.ApiFootballClient;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class ApiExplorerService {

    private static final String API_BASE =
            "https://v3.football.api-sports.io/";

    private static final String OUTPUT_DIRECTORY =
            "docs/api/";

    private final ApiFootballClient client;

    private final ObjectMapper objectMapper;

    public ApiExplorerService(

            ApiFootballClient client,

            ObjectMapper objectMapper

    ) {

        this.client = client;
        this.objectMapper = objectMapper;

    }

    /**
     * Downloads an API-Football endpoint and saves
     * the formatted JSON and request information.
     */
    public String download(

            String endpoint,

            String query,

            String outputFile

    ) throws Exception {

        String url =
                API_BASE + endpoint;

        if (query != null &&
                !query.isBlank()) {

            url += "?" + query;

        }

        String json =
                client.get(url);

        saveJson(

                json,

                outputFile

        );

        saveRequest(

                url,

                outputFile

        );

        return "Saved " + outputFile;

    }

    /**
     * Pretty-prints JSON and writes it to disk.
     */
    private void saveJson(

            String json,

            String outputFile

    ) throws Exception {

        Object parsed =
                objectMapper.readValue(

                        json,

                        Object.class

                );

        File file =
                new File(

                        OUTPUT_DIRECTORY,

                        outputFile

                );

        File parent =
                file.getParentFile();

        if (parent != null) {

            parent.mkdirs();

        }

        objectMapper

                .writerWithDefaultPrettyPrinter()

                .writeValue(

                        file,

                        parsed

                );

    }

    /**
     * Saves the request URL used to generate
     * the JSON response.
     */
    private void saveRequest(

            String url,

            String outputFile

    ) throws Exception {

        Path jsonPath =
                Path.of(

                        OUTPUT_DIRECTORY,

                        outputFile

                );

        String fileName =
                jsonPath.getFileName()
                        .toString();

        String requestFileName =
                fileName.replace(

                        ".json",

                        "_request.txt"

                );

        Path requestPath =
                jsonPath.resolveSibling(

                        requestFileName

                );

        Files.createDirectories(

                requestPath.getParent()

        );

        Files.writeString(

                requestPath,

                "GET\n\n" + url

        );

    }

}