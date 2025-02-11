package ru.svsand.adventofcode2024.day6;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Main.class);

        logger.info("Welcome to Advent of code 2024");
        logger.info("Day 6: Guard Gallivant");

        String fileName = args[0];
        List<String> strings = Reader.readFile(fileName);
        char[][] map = Parser.map(strings);
        Game game = new Game(map);
        game.start();

        logger.info("Steps count: " + game.countWay());
    }
}