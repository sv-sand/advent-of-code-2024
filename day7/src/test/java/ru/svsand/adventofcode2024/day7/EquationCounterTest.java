package ru.svsand.adventofcode2024.day7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class EquationCounterTest {

    List<String> strings = Arrays.asList(
            "190: 10 19",
            "3267: 81 40 27",
            "83: 17 5",
            "156: 15 6",
            "7290: 6 8 6 15",
            "161011: 16 10 13",
            "192: 17 8 14",
            "21037: 9 7 18 13",
            "292: 11 6 16 20"
    );

    EquationCounter counter;

    @BeforeEach
    void setUp() {
        ArrayList<Equation> equations = Parser.read(strings);
        counter = new EquationCounter(equations);
    }

    @Test
    void sumOfValid() {
        Assertions.assertEquals(3749, counter.sumOfValid());
    }

    @Test
    void sumOfValidWithConcatenation() {
        Assertions.assertEquals(11387, counter.sumOfValidWithConcatenation());
    }
}