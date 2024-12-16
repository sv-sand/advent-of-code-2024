package ru.svsand.adventofcode2024.day6;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Advent of code 2024");
        System.out.println("Day 6: Guard Gallivant");

        String fileName = args[0];
        FileParser parser = new FileParser();
        char[][] map = parser.read(fileName);

        Game game = new Game(map);
        game.start();

        System.out.println("Steps count: " + game.countWay());
    }
}