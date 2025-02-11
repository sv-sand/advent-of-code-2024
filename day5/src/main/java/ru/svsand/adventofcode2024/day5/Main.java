package ru.svsand.adventofcode2024.day5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Main.class);

        logger.info("Welcome to Advent of code 2024");
        logger.info("Day 5: Print Queue");

        String fileNameRules = args[0];
        String fileNameUpdates = args[1];

        Counter counter = new Counter(
                Reader.readFile(fileNameRules),
                Reader.readFile(fileNameUpdates)
        );

        logger.info("Count safe reports: " + counter.countSaveReports());
    }
}