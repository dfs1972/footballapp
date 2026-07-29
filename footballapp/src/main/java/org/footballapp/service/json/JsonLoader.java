package org.footballapp.service.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class JsonLoader {

    private static final Path MOCK_API_ROOT = Paths.get("mockapi");

    private final ObjectMapper mapper;

    public JsonLoader(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public <T> T load(String filename, Class<T> clazz) throws IOException {

        Path file = MOCK_API_ROOT.resolve(filename);

        try (var inputStream = Files.newInputStream(file)) {
            return mapper.readValue(inputStream, clazz);
        }
    }
}