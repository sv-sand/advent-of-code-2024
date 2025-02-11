package ru.svsand.adventofcode2024.day4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WordCounterTest {

    private final char[][] matrix = {
            {'M','M','M','S','X','X','M','A','S','M'},
            {'M','S','A','M','X','M','S','M','S','A'},
            {'A','M','X','S','X','M','A','A','M','M'},
            {'M','S','A','M','A','S','M','S','M','X'},
            {'X','M','A','S','A','M','X','A','M','M'},
            {'X','X','A','M','M','X','X','A','M','A'},
            {'S','M','S','M','S','A','S','X','S','S'},
            {'S','A','X','A','M','A','S','A','A','A'},
            {'M','A','M','M','M','X','M','M','M','M'},
            {'M','X','M','X','A','X','M','A','S','X'}
    };
    private final WordCounter counter = new WordCounter(matrix);

    @Test
    void calculateXmas() {
        Assertions.assertEquals(18, counter.calculateXmas());
    }

    @Test
    void calculateXMas() {
        Assertions.assertEquals(9, counter.calculateXXMas());
    }
}