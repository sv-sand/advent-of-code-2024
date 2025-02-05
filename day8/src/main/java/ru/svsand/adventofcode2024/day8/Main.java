package ru.svsand.adventofcode2024.day8;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Advent of code 2024");
        System.out.println("Day 8: Resonant Collinearity");

        String fileName = args[0];
        List<String> strings = Reader.readFile(fileName);
        char[][] map = Parser.parse(strings);

        ImpactCalculator calculator1 = new ImpactCalculator(map);
        System.out.println("Unique locations count: " + calculator1.setAntinodes(1));

//        ImpactOfSignalCalculator calculator2 = new ImpactOfSignalCalculator(map);
//        System.out.println("Unique locations count (part2): " + calculator2.setAntinodes(1000));

    }
}