package ru.adventofcode2024;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.svsand.adventofcode2024.day1.DistanceCalculator;

import static org.junit.jupiter.api.Assertions.*;

class DistanceCalculatorTest {

    @Test
    void addPointPair() {
        DistanceCalculator calculator = new DistanceCalculator();

        Assertions.assertDoesNotThrow(
                () -> calculator.addPointPair("1", "1")
        );

        Assertions.assertDoesNotThrow(
                () -> calculator.addPointPair(0, -1)
        );

        Assertions.assertThrows(NumberFormatException.class,
                () -> calculator.addPointPair("1", "q")
        );
        Assertions.assertThrows(NumberFormatException.class,
                () -> calculator.addPointPair("q", "1")
        );
    }

    @Test
    void calculate() {
        DistanceCalculator calculator = new DistanceCalculator();
        calculator.addPointPair(3, 4);
        calculator.addPointPair(4, 3);
        calculator.addPointPair(2, 5);
        calculator.addPointPair(1, 3);
        calculator.addPointPair(3, 9);
        calculator.addPointPair(3, 3);
        assertEquals(11, calculator.calculate());
    }

}