package ru.svsand.adventofcode2024.day10;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Main.class);

        logger.info("Welcome to Advent of code 2024");
        logger.info("Day 10: Hoof It");

        String fileName = args[0];
        List<String> strings = Reader.readFile(fileName);
        int[][] topographicMap = Parser.read(strings);

        TrailsCounterPart1 counter1 = new TrailsCounterPart1(topographicMap);
        counter1.findAllTrails();
        logger.info("Sum of the scores all trailheads (part 1): " + counter1.getTrailCount());

        TrailsCounterPart2 counter2 = new TrailsCounterPart2(topographicMap);
        counter2.findAllTrails();
        logger.info("Sum of the scores all trailheads (part 2): " + counter2.getTrailCount());
    }
}