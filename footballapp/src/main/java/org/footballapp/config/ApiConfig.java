package org.footballapp.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.footballapp.api.ApiFootballClient;
import org.footballapp.api.ApiFootballService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("live")
public class ApiConfig {

    @Bean
    public ApiFootballClient apiFootballClient() {

        String apiKey =
                System.getenv("API_FOOTBALL_KEY");

        if (apiKey == null || apiKey.isBlank()) {

            throw new IllegalStateException(
                    "API_FOOTBALL_KEY environment variable is not configured."
            );

        }

        return new ApiFootballClient(apiKey);

    }

    @Bean
    public ApiFootballService apiFootballService(
            ApiFootballClient apiFootballClient,
            ObjectMapper objectMapper
    ) {

        return new ApiFootballService(
                apiFootballClient,
                objectMapper
        );

    }

}

