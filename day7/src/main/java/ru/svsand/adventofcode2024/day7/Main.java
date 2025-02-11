package ru.svsand.adventofcode2024.day7;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Main.class);
        
        logger.info("Welcome to Advent of code 2024");
        logger.info("Day 7: Bridge Repair");

        String fileName = args[0];
        List<String> strings = Reader.readFile(fileName);
        ArrayList<Equation> equations = Parser.read(strings);
        EquationCounter counter = new EquationCounter(equations);

        logger.info("Sum valid equations: " + counter.sumOfValid());
        logger.info("Sum valid equations with concatenation: " + counter.sumOfValidWithConcatenation());
    }
}