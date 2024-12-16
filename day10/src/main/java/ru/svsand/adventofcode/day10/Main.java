package ru.svsand.adventofcode.day10;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Advent of code 2024");
        System.out.println("Day 10: Hoof It");

        String fileName = args[0];
        FileParser parser = new FileParser();
        int[][] topographicMap = parser.read(fileName);

        TrailsCounterPart1 counter1 = new TrailsCounterPart1(topographicMap);
        counter1.findAllTrails();
        System.out.println("Sum of the scores all trailheads (part 1): " + counter1.getTrailCount());

        TrailsCounterPart2 counter2 = new TrailsCounterPart2(topographicMap);
        counter2.findAllTrails();
        System.out.println("Sum of the scores all trailheads (part 2): " + counter2.getTrailCount());

    }
}