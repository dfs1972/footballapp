package org.footballapp.service.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
public class JsonLoader {

    private final ObjectMapper mapper;

    public JsonLoader(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public <T> T load(
            String filename,
            Class<T> clazz
    ) throws IOException {

        ClassPathResource resource =
                new ClassPathResource(
                        "mockapi/" + filename
                );

        try (InputStream inputStream =
                     resource.getInputStream()) {

            return mapper.readValue(
                    inputStream,
                    clazz
            );
        }
    }

}