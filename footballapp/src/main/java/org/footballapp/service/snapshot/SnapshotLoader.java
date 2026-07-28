package org.footballapp.service.snapshot;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class SnapshotLoader {

    private static final String SNAPSHOT_DIRECTORY =
            "mockapi/";

    private final ObjectMapper objectMapper;

    public SnapshotLoader(
            ObjectMapper objectMapper
    ) {
        this.objectMapper =
                objectMapper;
    }

    public <T> T load(
            String filename,
            Class<T> clazz
    ) throws IOException {

        Path path =
                Path.of(
                        SNAPSHOT_DIRECTORY,
                        filename
                );

        return objectMapper.readValue(
                Files.newInputStream(path),
                clazz
        );
    }
}