package ru.svsand.adventofcode2024.day4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Main.class);

        logger.info("Welcome to Advent of code 2024");
        logger.info("Day 4: Ceres Search");

        String fileName = args[0];
        FileParser parser = new FileParser(fileName);
        char[][] matrix = parser.read();

        WordCounter counter = new WordCounter(matrix);

        logger.info("XMAS count: " + counter.calculateXmas());
        logger.info("X-MAS count: " + counter.calculateXXMas());
    }
}