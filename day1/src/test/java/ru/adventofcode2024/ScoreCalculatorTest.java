package ru.adventofcode2024;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.svsand.adventofcode2024.ScoreCalculator;

import static org.junit.jupiter.api.Assertions.*;

class ScoreCalculatorTest {

    @Test
    void addPointPair() {
        ScoreCalculator calculator = new ScoreCalculator();

        Assertions.assertDoesNotThrow(
                () -> calculator.addPointPair(0, -1)
        );
        Assertions.assertDoesNotThrow(
                () -> calculator.addPointPair("1", "1")
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
        ScoreCalculator calculator = new ScoreCalculator();
        calculator.addPointPair(3, 4);
        calculator.addPointPair(4, 3);
        calculator.addPointPair(2, 5);
        calculator.addPointPair(1, 3);
        calculator.addPointPair(3, 9);
        calculator.addPointPair(3, 3);
        assertEquals(31, calculator.calculate());
    }
}