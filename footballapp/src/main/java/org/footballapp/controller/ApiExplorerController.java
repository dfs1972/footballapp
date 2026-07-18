package org.footballapp.controller;

import org.footballapp.tools.development.ApiExplorerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiExplorerController {

    private final ApiExplorerService explorer;

    public ApiExplorerController(
            ApiExplorerService explorer
    ) {
        this.explorer = explorer;
    }

    @GetMapping("/tools/explore")
    public String explore(

            @RequestParam String endpoint,

            @RequestParam(required = false)
            String query,

            @RequestParam String output

    ) throws Exception {

        explorer.download(

                endpoint,

                query,

                output

        );

        return "Download complete.";

    }

}