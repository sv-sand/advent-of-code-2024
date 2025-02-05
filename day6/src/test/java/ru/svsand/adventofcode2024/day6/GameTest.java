package ru.svsand.adventofcode2024.day6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class GameTest {
    private Game game;
    private final List<String> strings = Arrays.asList(
            "....#.....",
            ".........#",
            "..........",
            "..#.......",
            ".......#..",
            "..........",
            ".#..^.....",
            "........#.",
            "#.........",
            "......#..."
    );

    @BeforeEach
    void setUp() {
        char[][] map = Parser.map(strings);
        game = new Game(map);
        game.start();
    }

    @Test
    void countWay() {
        Assertions.assertEquals(41, game.countWay());
    }
}