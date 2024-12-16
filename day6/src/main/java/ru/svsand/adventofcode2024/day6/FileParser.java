package ru.svsand.adventofcode2024.day6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sand <sve.snd@gmail.com>
 * @since 04.12.2024
 */

public class FileParser {

    public char[][] read(String fileName) {
        List<String> strings = readFile(fileName);
        if(strings.size() == 0)
            return new char[0][0];

        char[][] data = new char[strings.size()][strings.get(0).length()];
        for (int row = 0; row < strings.size(); row++) {
            data[row] = strings.get(row).toCharArray();
        }
        return data;
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
