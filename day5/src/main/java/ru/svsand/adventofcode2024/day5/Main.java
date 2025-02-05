package ru.svsand.adventofcode2024.day5;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Advent of code 2024");
        System.out.println("Day 5: Print Queue");

        String fileNameRules = args[0];
        String fileNameUpdates = args[1];

        Counter counter = new Counter(
                Reader.readFile(fileNameRules),
                Reader.readFile(fileNameUpdates)
        );

        System.out.println("Count safe reports: " + counter.countSaveReports());
    }
}