package org.footballapp.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FlagCacheService {

    private static final String CACHE_DIRECTORY =
            "cached-images/flags";

    private final HttpClient httpClient =
            HttpClient.newHttpClient();

    /**
     * Returns the cached flag file for the supplied country code.
     *
     * If the flag does not exist locally and a source URL is supplied,
     * the flag is downloaded and cached first.
     */
    public Path getOrCacheFlag(
            String countryCode,
            String sourceUrl
    ) throws Exception {

        if (countryCode == null
                || countryCode.isBlank()) {

            throw new IllegalArgumentException(
                    "Country code is required."
            );
        }

        String filename =
                countryCode.toLowerCase() + ".svg";

        Path cacheDirectory =
                Paths.get(CACHE_DIRECTORY);

        Files.createDirectories(
                cacheDirectory
        );

        Path cachedFile =
                cacheDirectory.resolve(filename);

        /*
         * Already cached.
         */
        if (Files.exists(cachedFile)) {

            return cachedFile;
        }

        /*
         * No source image available.
         */
        if (sourceUrl == null
                || sourceUrl.isBlank()) {

            return null;
        }

        /*
         * Download the flag.
         */
        HttpRequest request =
                HttpRequest.newBuilder()
                        .uri(URI.create(sourceUrl))
                        .GET()
                        .build();

        HttpResponse<byte[]> response =
                httpClient.send(
                        request,
                        HttpResponse.BodyHandlers.ofByteArray()
                );

        if (response.statusCode() < 200
                || response.statusCode() >= 300) {

            throw new IOException(
                    "Failed to download flag: HTTP "
                            + response.statusCode()
            );
        }

        Files.write(
                cachedFile,
                response.body()
        );

        return cachedFile;
    }
    public Path getCachedFlag(
            String countryCode
    ) {

        if (countryCode == null
                || countryCode.isBlank()) {

            return null;
        }

        Path cachedFile =
                Paths.get(
                        CACHE_DIRECTORY,
                        countryCode.toLowerCase() + ".svg"
                );

        if (!Files.exists(cachedFile)) {

            return null;
        }

        return cachedFile;
    }

}