package ru.svsand.adventofcode2024.day2;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author sand <sve.snd@gmail.com>
 * @since 02.12.2024
 */

public class Main {
    public static void main(String[] args) throws IOException {
        Logger logger = LoggerFactory.getLogger(Main.class);

        logger.info("Welcome to Advent of code 2024");
        logger.info("Day 2: Red-Nosed Reports");

        int countSafeReports = 0;
        int countSafeReportsWithOneError = 0;
        ReportAnalyzer analyzer = new ReportAnalyzer();

        FileParser parser = new FileParser(args[0]);
        while (parser.readLine()) {
            analyzer.loadReport(parser.getData());
            if (analyzer.isReportSafe())
                countSafeReports++;
            if (analyzer.isReportSafeWithOneError())
                countSafeReportsWithOneError++;
        }

        logger.info("Count safe reports: " + countSafeReports);
        logger.info("Count safe reports with one error: " + countSafeReportsWithOneError);
    }
}
