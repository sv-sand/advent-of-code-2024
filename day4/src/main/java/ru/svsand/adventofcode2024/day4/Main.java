package ru.svsand.adventofcode2024.day4;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Advent of code 2024");
        System.out.println("Day 4: Ceres Search");

        String fileName = args[0];
        FileParser parser = new FileParser(fileName);
        char[][] matrix = parser.read();

        WordCounter counter = new WordCounter(matrix);

        System.out.println("XMAS count: " + counter.calculateXmas());
        System.out.println("X-MAS count: " + counter.calculateXMas());
    }
}