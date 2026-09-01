package org.footballapp.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
public class CacheConfig {

    // Tier 1: Static (24 Hours)
    public static final String CACHE_COUNTRIES = "countries";
    public static final String CACHE_LEAGUES = "leagues";
    public static final String CACHE_TEAMS = "teams";
    public static final String CACHE_COACHES = "coaches";

    // Tier 2: Semi-Static (1 Hour)
    public static final String CACHE_STANDINGS = "standings";
    public static final String CACHE_SQUADS = "squads";
    public static final String CACHE_STATS = "stats";
    public static final String CACHE_PLAYERS = "players";

    // Tier 3: Dynamic (15 Seconds)
    public static final String CACHE_FIXTURES = "fixtures";
    public static final String CACHE_ROUNDS = "rounds";
    public static final String CACHE_LINEUPS = "lineups";
    public static final String CACHE_EVENTS = "events";

    @Bean
    public CacheManager cacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();

        // Tier 1: 24 Hour Tiers
        Caffeine<Object, Object> staticBuilder = Caffeine.newBuilder()
                .expireAfterWrite(24, TimeUnit.HOURS)
                .maximumSize(500);

        // Tier 2: 12 Hour Tiers (Was 1 hour)
        Caffeine<Object, Object> semiStaticBuilder = Caffeine.newBuilder()
                .expireAfterWrite(12, TimeUnit.HOURS)
                .maximumSize(1000);

        // Tier 3: 2 Minute Tiers (Was 15 seconds)
        Caffeine<Object, Object> dynamicBuilder = Caffeine.newBuilder()
                .expireAfterWrite(2, TimeUnit.MINUTES)
                .maximumSize(1000);

        cacheManager.registerCustomCache(CACHE_COUNTRIES, staticBuilder.build());
        cacheManager.registerCustomCache(CACHE_LEAGUES, staticBuilder.build());
        cacheManager.registerCustomCache(CACHE_TEAMS, staticBuilder.build());
        cacheManager.registerCustomCache(CACHE_COACHES, staticBuilder.build());

        cacheManager.registerCustomCache(CACHE_STANDINGS, semiStaticBuilder.build());
        cacheManager.registerCustomCache(CACHE_SQUADS, semiStaticBuilder.build());
        cacheManager.registerCustomCache(CACHE_STATS, semiStaticBuilder.build());
        cacheManager.registerCustomCache(CACHE_PLAYERS, semiStaticBuilder.build());

        cacheManager.registerCustomCache(CACHE_FIXTURES, dynamicBuilder.build());
        cacheManager.registerCustomCache(CACHE_ROUNDS, dynamicBuilder.build());
        cacheManager.registerCustomCache(CACHE_LINEUPS, dynamicBuilder.build());
        cacheManager.registerCustomCache(CACHE_EVENTS, dynamicBuilder.build());

        return cacheManager;
    }
}
