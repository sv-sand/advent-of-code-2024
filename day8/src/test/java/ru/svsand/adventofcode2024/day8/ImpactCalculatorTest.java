package ru.svsand.adventofcode2024.day8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class ImpactCalculatorTest {
    private ImpactCalculator calculator;
    private final List<String> strings = Arrays.asList(
            "............",
            "........0...",
            ".....0......",
            ".......0....",
            "....0.......",
            "......A.....",
            "............",
            "............",
            "........A...",
            ".........A..",
            "............",
            "............"
    );

    @BeforeEach
    void setUp() {
        char[][] map = Parser.parse(strings);
        calculator = new ImpactCalculator(map);
    }

    @Test
    void setAntinodes() {
        Assertions.assertEquals(14, calculator.setAntinodes(1));
    }
}