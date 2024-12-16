package ru.svsand.adventofcode2024.day1;

import lombok.Getter;

import java.util.ArrayList;

/**
 * @author sand <sve.snd@gmail.com>
 * @since 02.12.2024
 */

public class ScoreCalculator implements Calculator {

    private final ArrayList<Integer> list1 = new ArrayList<>();
    private final ArrayList<Integer> list2 = new ArrayList<>();

    @Getter
    private long similarityScore;

    public void addPointPair(String point1, String point2) {
        addPointPair(Integer.parseInt(point1), Integer.parseInt(point2));
    }

    public void addPointPair(int point1, int point2) {
        list1.add(point1);
        list2.add(point2);
    }

    public long calculate() {
        for (int value: list1) {
            long score = list2.stream()
                    .filter(i -> i.equals(value))
                    .toArray()
                    .length;
            similarityScore += value * score;
        }

        return similarityScore;
    }
}
