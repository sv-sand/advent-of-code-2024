package ru.svsand.adventofcode.day10;

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

    public int[][] read(String fileName) {
        List<String> strings = readFile(fileName);
        if(strings.size() == 0)
            return new int[0][0];

        int[][] data = new int[strings.size()][strings.get(0).length()];
        for (int row = 0; row < strings.size(); row++) {
            String string = strings.get(row);
            for (int column = 0; column < string.length(); column++) {
                String symbol = string.substring(column, column + 1);
                if (symbol.equals("."))
                    data[row][column] = -2;
                else
                    data[row][column] = Integer.parseInt(symbol);
            }
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
