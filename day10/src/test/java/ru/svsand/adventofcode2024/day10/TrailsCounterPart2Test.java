package ru.svsand.adventofcode2024.day10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TrailsCounterPart2Test {

    private TrailsCounterPart2 counter;
    private final List<String> strings = Arrays.asList(
            "89010123",
            "78121874",
            "87430965",
            "96549874",
            "45678903",
            "32019012",
            "01329801",
            "10456732"
    );

    @BeforeEach
    void setUp() {
        int[][] topographicMap = Parser.read(strings);
        counter = new TrailsCounterPart2(topographicMap);
        counter.findAllTrails();
    }

    @Test
    void getTrailCount() {
        assertEquals(81, counter.getTrailCount());
    }
}