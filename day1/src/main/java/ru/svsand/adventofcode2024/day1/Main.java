package ru.svsand.adventofcode2024.day1;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Advent of code 2024");
        System.out.println("Day 1: Historian Hysteria");

        Calculator distanceCalculator = new DistanceCalculator();
        Calculator scoreCalculator = new ScoreCalculator();

        FileParser parser = new FileParser(args[0]);
        while (parser.readLine()) {
            distanceCalculator.addPointPair(parser.getValue1(), parser.getValue2());
            scoreCalculator.addPointPair(parser.getValue1(), parser.getValue2());
        }

        System.out.println("Full distance: " + distanceCalculator.calculate());
        System.out.println("Similarity score: " + scoreCalculator.calculate());
    }
}