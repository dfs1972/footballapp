package org.footballapp;

import org.footballapp.model.teamstatistics.TeamStatisticsApiResponse;
import org.footballapp.tools.ApiTester;

public class Main {

    public static void main(String[] args)
            throws Exception {

            ApiTester tester =
                    new ApiTester();

//        tester.print(
//                "teams/statistics?league=179&season=2024&team=257"
//        );
        tester.validate(

                "teams/statistics?league=179&season=2024&team=257",

                TeamStatisticsApiResponse.class);
        } // End of main()

//        /**
//         * Save to file
//         */
//        ApiTester tester =
//                new ApiTester();
//
//        tester.saveToFile(
//                "teams/statistics?league=179&season=2024&team=257"
//        );
//
//        /**
//         * Save to file and print
//         */
//        ApiTester tester_print =
//                new ApiTester();
//
//        tester_print.saveAndPrint(
//                "teams/statistics?league=179&season=2024&team=257"
//        );
} // End of Main Class.