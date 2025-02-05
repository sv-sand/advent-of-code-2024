package ru.svsand.adventofcode2024.day7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sand <sve.snd@gmail.com>
 * @since 05.12.2024
 */

public class Reader {

    public static List<String> readFile(String fileName) {
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
