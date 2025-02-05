package ru.svsand.adventofcode2024.day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sand <sve.snd@gmail.com>
 * @since 04.02.2025
 */

public class Counter {

    private final HashMap<Integer, List<Integer>> orderingRules;
    private final List<List<Integer>> updates;

    public Counter(List<String> rulesData, List<String> updatesData) {
        this.orderingRules = orderingRules(rulesData);
        this.updates = readUpdates(updatesData);
    }

    public long countSaveReports() {
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

        return sum;
    }

    private HashMap<Integer, List<Integer>> orderingRules(List<String> strings) {
        HashMap<Integer, List<Integer>> rules = new HashMap<>();
        for (String string: strings) {
            String[] arr = string.split("\\|");
            int key = Integer.parseInt(arr[0]);
            int value = Integer.parseInt(arr[1]);

            List<Integer> list = rules.get(key);
            if (list != null) {
                list.add(value);
            }
            else {
                List<Integer> newList = new ArrayList<>();
                newList.add(value);
                rules.put(key, newList);
            }
        }
        return rules;
    }

    private List<List<Integer>> readUpdates(List<String> strings) {
        return strings.stream()
                .map(
                        string -> Arrays.stream(string.split(","))
                                .map(Integer::parseInt)
                                .collect(Collectors.toList())
                ).collect(Collectors.toList());
    }
}
