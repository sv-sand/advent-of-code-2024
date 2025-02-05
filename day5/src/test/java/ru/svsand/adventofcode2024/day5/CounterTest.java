package ru.svsand.adventofcode2024.day5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class CounterTest {
    private final List<String> rulesData = Arrays.asList(
            "47|53",
            "97|13",
            "97|61",
            "97|47",
            "75|29",
            "61|13",
            "75|53",
            "29|13",
            "97|29",
            "53|29",
            "61|53",
            "97|53",
            "61|29",
            "47|13",
            "75|47",
            "97|75",
            "47|61",
            "75|61",
            "47|29",
            "75|13",
            "53|13"
    );
    private final List<String> updatesData = Arrays.asList(
            "75,47,61,53,29",
            "97,61,53,29,13",
            "75,29,13",
            "75,97,47,61,53",
            "61,13,29",
            "97,13,75,29,47"
    );
    private final Counter counter = new Counter(rulesData, updatesData);

    @Test
    void countSaveReports() {
        Assertions.assertEquals(143, counter.countSaveReports());
    }
}