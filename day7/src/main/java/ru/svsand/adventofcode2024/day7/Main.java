package ru.svsand.adventofcode2024.day7;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Advent of code 2024");
        System.out.println("Day 7: Bridge Repair");

        String fileName = args[0];
        List<String> strings = Reader.readFile(fileName);
        ArrayList<Equation> equations = Parser.read(strings);
        EquationCounter counter = new EquationCounter(equations);

        System.out.println("Sum valid equations: " + counter.sumOfValid());
        System.out.println("Sum valid equations with concatenation: " + counter.sumOfValidWithConcatenation());
    }
}