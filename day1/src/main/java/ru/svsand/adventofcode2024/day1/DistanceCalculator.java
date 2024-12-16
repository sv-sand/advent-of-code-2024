package ru.svsand.adventofcode2024.day1;

import java.util.ArrayList;

/**
 * @author sand <sve.snd@gmail.com>
 * @since 02.12.2024
 */

public class DistanceCalculator implements Calculator {

    private final ArrayList<Integer> list1 = new ArrayList<>();
    private final ArrayList<Integer> list2 = new ArrayList<>();

    public void addPointPair(String point1, String point2) {
        addPointPair(Integer.parseInt(point1), Integer.parseInt(point2));
    }

    public void addPointPair(int point1, int point2) {
        list1.add(point1);
        list2.add(point2);
    }

    public long calculate() {
        list1.sort(null);
        list2.sort(null);

        long fullDistance = 0;
        for (int i = 0; i < list1.size(); i++) {
            int distance =  list1.get(i) - list2.get(i);
            fullDistance += Math.max(distance, -distance);
        }

        return fullDistance;
    }
}
