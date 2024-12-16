package ru.svsand.adventofcode2024.day8;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Advent of code 2024");
        System.out.println("Day 8: Resonant Collinearity");

        String fileName = args[0];
        FileParser parser = new FileParser();
        char[][] map = parser.read(fileName);

//        ImpactOfSignalCalculator calculator1 = new ImpactOfSignalCalculator(map);
//        System.out.println("Unique locations count: " + calculator1.setAntinodes(1));

        ImpactOfSignalCalculator calculator2 = new ImpactOfSignalCalculator(map);
        System.out.println("Unique locations count (part2): " + calculator2.setAntinodes(1000));

    }
}