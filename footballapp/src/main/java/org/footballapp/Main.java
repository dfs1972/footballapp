package org.footballapp;

import org.footballapp.api.ApiFootballClient;
import org.footballapp.api.ApiFootballService;
import org.footballapp.config.AppConfig;

public class Main {

    public static void main(String[] args)
            throws Exception {

        AppConfig config =
                new AppConfig();

        ApiFootballService apiFootballService =
                config.getApiFootballService();

        String json =
                apiFootballService.getPlayerJson(
                        306979,
                        179,
                        2024
                );

        System.out.println(json);

    } // End of main method.
} // End of Main Class.