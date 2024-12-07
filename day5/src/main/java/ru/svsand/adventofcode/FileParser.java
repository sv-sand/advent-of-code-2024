package ru.svsand.adventofcode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sand <sve.snd@gmail.com>
 * @since 05.12.2024
 */

public class FileParser {

    public HashMap<Integer, List<Integer>> orderingRules(String fileName) {
        List<String> strings = readFile(fileName);

        HashMap<Integer, List<Integer>> rules = new HashMap<Integer, List<Integer>>();
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

    public List<List<Integer>> readUpdates(String fileName) {
        List<String> strings = readFile(fileName);

        return strings.stream()
                .map(
                        string -> Arrays.stream(string.split(","))
                                .map(Integer::parseInt)
                                .collect(Collectors.toList())
                ).collect(Collectors.toList());
    }

    private List<String> readFile(String fileName) {
        List<String> strings;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            strings = br.lines()
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return strings;
    }

}
