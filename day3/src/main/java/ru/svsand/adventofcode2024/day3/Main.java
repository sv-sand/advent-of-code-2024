package ru.svsand.adventofcode2024.day3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Main.class);
        
        logger.info("Welcome to Advent of code 2024");
        logger.info("Day 3: Mull It Over");

        String fileName = args[0];
        String text = Reader.readFile(fileName).get(0);

        InstructionMultiplier multiplier = new InstructionMultiplier(text);

        logger.info("Result of instructions: " + multiplier.multiply());
        logger.info("Result of enabled instructions: " + multiplier.multiplyEnabled());
    }
}
