package ru.svsand.adventofcode2024.day6;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Advent of code 2024");
        System.out.println("Day 6: Guard Gallivant");

        String fileName = args[0];
        List<String> strings = Reader.readFile(fileName);
        char[][] map = Parser.map(strings);
        Game game = new Game(map);
        game.start();

        System.out.println("Steps count: " + game.countWay());
    }
}