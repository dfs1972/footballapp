package org.footballapp.api;

import java.net.http.HttpHeaders;

public class ApiRateLimiter {

    private static final int PAUSE_THRESHOLD = 10;
    public static final int MAX_REQUESTS_PER_MINUTE = 240;

    public void processHeaders(
            HttpHeaders headers
    ) throws InterruptedException {

        int minuteLimit =
                getHeader(headers, "X-RateLimit-Limit");

        int minuteRemaining =
                getHeader(headers, "X-RateLimit-Remaining");

        int dayLimit =
                getHeader(headers, "x-ratelimit-requests-limit");

        int dayRemaining =
                getHeader(headers, "x-ratelimit-requests-remaining");

        System.out.printf(
                "Rate Limit: %d/%d minute   %d/%d day%n",
                minuteRemaining,
                minuteLimit,
                dayRemaining,
                dayLimit
        );

        if (minuteRemaining > 0 &&
                minuteRemaining <= PAUSE_THRESHOLD) {

            System.out.println(
                    "Approaching API rate limit. Waiting 60 seconds..."
            );

            Thread.sleep(60_000);
        }
    }

    private int getHeader(
            HttpHeaders headers,
            String name
    ) {

        return headers.firstValue(name)
                .map(Integer::parseInt)
                .orElse(-1);
    }
}