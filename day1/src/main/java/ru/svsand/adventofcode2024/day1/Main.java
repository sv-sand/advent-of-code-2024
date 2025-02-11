package ru.svsand.adventofcode2024.day1;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    public static void main(String[] args) throws IOException {
        Logger logger = LoggerFactory.getLogger(Main.class);

        logger.info("Welcome to Advent of code 2024");
        logger.info("Day 1: Historian Hysteria");

        Calculator distanceCalculator = new DistanceCalculator();
        Calculator scoreCalculator = new ScoreCalculator();

        FileParser parser = new FileParser(args[0]);
        while (parser.readLine()) {
            distanceCalculator.addPointPair(parser.getValue1(), parser.getValue2());
            scoreCalculator.addPointPair(parser.getValue1(), parser.getValue2());
        }

        logger.info("Full distance: " + distanceCalculator.calculate());
        logger.info("Similarity score: " + scoreCalculator.calculate());
    }
}