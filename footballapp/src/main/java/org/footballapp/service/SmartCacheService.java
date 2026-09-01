package org.footballapp.service;

import org.footballapp.model.fixtures.FixtureResponse;
import org.footballapp.model.fixtures.FixturesApiResponse;
import org.footballapp.api.dto.events.FixtureEventsApiResponse;
import org.footballapp.api.dto.lineups.FixtureLineupsResponse;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

@Service
public class SmartCacheService {

    private record CachedItem(Object value, long expiryInstant) {}

    private final ConcurrentHashMap<String, CachedItem> cache = new ConcurrentHashMap<>();

    private static final long TTL_FINISHED = TimeUnit.HOURS.toSeconds(24);
    private static final long TTL_LIVE = 15;
    private static final long TTL_NEAR_FUTURE = 60;
    private static final long TTL_FUTURE = TimeUnit.HOURS.toSeconds(1);
    private static final long TTL_DEFAULT = 60;

    @SuppressWarnings("unchecked")
    public <T> T get(String key, Class<T> type) {
        CachedItem item = cache.get(key);
        if (item == null) return null;

        if (Instant.now().getEpochSecond() > item.expiryInstant) {
            cache.remove(key);
            return null;
        }

        return (T) item.value;
    }

    public void put(String key, Object value) {
        put(key, value, calculateTtl(value));
    }

    public void put(String key, Object value, long ttl) {
        long expiry = Instant.now().getEpochSecond() + ttl;
        cache.put(key, new CachedItem(value, expiry));

        System.out.printf("[CACHE PUT] %s (TTL: %ds)%n", key, ttl);
    }

    private long calculateTtl(Object value) {
        if (value instanceof FixturesApiResponse resp) {
            return calculateFixturesTtl(resp.getResponse());
        }
        if (value instanceof FixtureEventsApiResponse || value instanceof FixtureLineupsResponse) {
            // For individual match details, we assume the caller wants "Live" granularity 
            // unless we had more context. For now, 15s is safe for these hot endpoints.
            return TTL_LIVE;
        }
        return TTL_DEFAULT;
    }

    private long calculateFixturesTtl(List<FixtureResponse> fixtures) {
        if (fixtures == null || fixtures.isEmpty()) return TTL_FUTURE;

        long minTtl = TTL_FINISHED;

        for (FixtureResponse resp : fixtures) {
            if (resp.getFixture() == null || resp.getFixture().getStatus() == null) continue;

            String status = resp.getFixture().getStatus().getShortStatus();
            long itemTtl = getTtlForStatus(status, resp.getFixture().getDate());
            
            minTtl = Math.min(minTtl, itemTtl);
            
            // If any game is live, we can't do better than 15s
            if (minTtl == TTL_LIVE) break;
        }

        return minTtl;
    }

    public long getTtlForStatus(String status, String dateStr) {
        if (status == null) return TTL_DEFAULT;

        return switch (status.toUpperCase()) {
            case "FT", "AET", "PEN", "AWD", "WO" -> TTL_FINISHED;
            case "1H", "2H", "HT", "ET", "P", "LIVE" -> TTL_LIVE;
            case "NS", "TBD" -> {
                if (dateStr == null) yield TTL_FUTURE;
                try {
                    OffsetDateTime kickoff = OffsetDateTime.parse(dateStr);
                    long secondsToKickoff = kickoff.toEpochSecond() - Instant.now().getEpochSecond();
                    
                    if (secondsToKickoff < TimeUnit.HOURS.toSeconds(2)) {
                        yield TTL_NEAR_FUTURE;
                    } else {
                        yield TTL_FUTURE;
                    }
                } catch (Exception e) {
                    yield TTL_FUTURE;
                }
            }
            default -> TTL_DEFAULT;
        };
    }
}
