package ru.svsand.adventofcode2024.day5;

import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Advent of code 2024");
        System.out.println("Day 5: Print Queue");

        String fileNameRules = args[0];
        String fileNameUpdates = args[1];

        FileParser parser = new FileParser();
        HashMap<Integer, List<Integer>> orderingRules = parser.orderingRules(fileNameRules);
        List<List<Integer>> updates = parser.readUpdates(fileNameUpdates);

        long sum = 0;
        for (List<Integer> row: updates) {
            boolean isCorrect = true;

            for (int columnIndex = 1; columnIndex < row.size(); columnIndex++) {
                int objectiveValue = row.get(columnIndex);
                List<Integer> orderingRule = orderingRules.get(objectiveValue);
                if (orderingRule == null)
                    continue;

                for (int inspectedColumnIndex = 0; inspectedColumnIndex < columnIndex; inspectedColumnIndex++) {
                    int inspectedValue = row.get(inspectedColumnIndex);
                    if (orderingRule.contains(inspectedValue))
                        isCorrect = false;
                }
            }

            if (isCorrect) {
                int middle = row.size() / 2;
                sum += row.get(middle);
            }
        }

        System.out.println("Count safe reports: " + sum);
    }
}