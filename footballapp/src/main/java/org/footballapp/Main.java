package org.footballapp;

import org.footballapp.api.ApiFootballClient;
import org.footballapp.config.AppConfig;

public class Main {

    public static void main(String[] args) throws Exception {

//        try {
//
//            String apiKey =
//                    System.getenv("API_FOOTBALL_KEY");
//
//            ApiFootballClient apiClient =
//                    new ApiFootballClient(apiKey);
//
//            String url =
//                    "https://v3.football.api-sports.io/players"
//                            + "?team=257"
//                            + "&season=2024";
//
//            String json =
//                    apiClient.get(url);
//
//            System.out.println(json);
//
//        } catch (Exception ex) {
//
//            ex.printStackTrace();
//        }
        AppConfig config =
                new AppConfig();

        config.getPlayerImportService()
                .importPlayers(
                        257,
                        2024
                );
    } // End of main method.
} // End of Main Class.