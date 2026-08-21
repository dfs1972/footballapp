package org.footballapp.controller;

import org.footballapp.service.FlagCacheService;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;

@RestController
@RequestMapping("/images/flags")
public class FlagController {

    private final FlagCacheService flagCacheService;

    public FlagController(
            FlagCacheService flagCacheService
    ) {
        this.flagCacheService =
                flagCacheService;
    }

    /**
     * Returns a cached country flag.
     *
     * Example:
     *
     * GET /images/flags/al
     */
    @GetMapping("/{countryCode}")
    public ResponseEntity<Resource> getFlag(
            @PathVariable String countryCode
    ) throws Exception {

        String sourceUrl =
                "https://media.api-sports.io/flags/"
                        + countryCode.toLowerCase()
                        + ".svg";

        Path flag =
                flagCacheService.getOrCacheFlag(
                        countryCode,
                        sourceUrl
                );

        if (flag == null) {

            return ResponseEntity.notFound()
                    .build();
        }

        return ResponseEntity.ok()
                .contentType(
                        MediaType.parseMediaType(
                                "image/svg+xml"
                        )
                )
                .body(
                        new FileSystemResource(flag)
                );
    }

}