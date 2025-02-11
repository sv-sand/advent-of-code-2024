package ru.svsand.adventofcode2024.day8;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Main.class);

        logger.info("Welcome to Advent of code 2024");
        logger.info("Day 8: Resonant Collinearity");

        String fileName = args[0];
        List<String> strings = Reader.readFile(fileName);
        char[][] map = Parser.parse(strings);

        ImpactCalculator calculator1 = new ImpactCalculator(map);
        logger.info("Unique locations count: " + calculator1.setAntinodes(1));

//        ImpactOfSignalCalculator calculator2 = new ImpactOfSignalCalculator(map);
//        logger.info("Unique locations count (part2): " + calculator2.setAntinodes(1000));

    }
}