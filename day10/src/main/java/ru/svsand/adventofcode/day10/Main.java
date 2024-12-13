package ru.svsand.adventofcode.day10;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Advent of code 2024");
        System.out.println("Day 10: Hoof It");

        String fileName = args[0];
        FileParser parser = new FileParser();
        int[][] topographicMap = parser.read(fileName);
        TrailsCounter counter = new TrailsCounter(topographicMap);
        counter.findAllTrails();

        System.out.println("Sum of the scores all trailheads: " + counter.getTrailCount());
    }
}