package ru.svsand.adventofcode2024.day9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sand <sve.snd@gmail.com>
 * @since 10.12.2024
 */

public class FileParser {

    public ArrayList<Integer> read(String fileName) {
        List<String> strings = readFile(fileName);
        ArrayList<Integer> diskMap = new ArrayList<>();

        for (String string: strings)
            for (char symbol: string.toCharArray())
                diskMap.add(Integer.parseInt(String.valueOf(symbol)));

        return diskMap;
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
