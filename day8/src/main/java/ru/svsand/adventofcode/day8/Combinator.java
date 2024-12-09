package ru.svsand.adventofcode.day8;

import lombok.Getter;

/**
 * @author sand <sve.snd@gmail.com>
 * @since 08.12.2024
 */

public class Combinator {
    private int countOfElements;
    @Getter
    private int countOfCombinations;
    @Getter
    private int[][] combinations;

    public Combinator(int countOfElementsInCollection) {
        countOfElements = countOfElementsInCollection;
        combinations = new int[calculateCombinationCount(countOfElements)][2];
        countOfCombinations = 0;
        fillCombinations(0);
    }

    private void fillCombinations(int position) {
        for (int index = position + 1; index < countOfElements; index++, countOfCombinations++) {
            combinations[countOfCombinations][0] = position;
            combinations[countOfCombinations][1] = index;
        }

        if (position < countOfElements)
            fillCombinations(position + 1);
    }

    private int calculateCombinationCount(int n) {
        if (n <= 1)
            return 0;
        return (n - 1) + calculateCombinationCount(n - 1);
    }
}
