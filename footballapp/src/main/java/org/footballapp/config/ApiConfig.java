package org.footballapp.config;

import org.footballapp.api.ApiFootballClient;
import org.footballapp.api.ApiFootballService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
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
            ApiFootballClient apiFootballClient
    ) {

        return new ApiFootballService(
                apiFootballClient
        );

    }

}

