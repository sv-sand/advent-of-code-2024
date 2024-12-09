package ru.svsand.adventofcode.day8;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Advent of code 2024");
        System.out.println("Day 8: Resonant Collinearity");

        String fileName = args[0];
        FileParser parser = new FileParser();
        char[][] map = parser.read(fileName);
        ImpactOfSignalCalculator calculator = new ImpactOfSignalCalculator(map);
        calculator.findAntennas();
        calculator.setAntinodes();

        System.out.println("Unique locations count: " + calculator.getCountAntinodes());
    }
}