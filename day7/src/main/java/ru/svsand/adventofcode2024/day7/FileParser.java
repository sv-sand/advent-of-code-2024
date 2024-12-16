package ru.svsand.adventofcode2024.day7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sand <sve.snd@gmail.com>
 * @since 04.12.2024
 */

public class FileParser {

    public ArrayList<Equation> read(String fileName) {
        ArrayList<Equation> equations = new ArrayList<>();
        List<String> strings = readFile(fileName);

        for (String string: strings) {
            Equation equation = new Equation();
            String[] arr = string.split(":");
            equation.setResult(Long.parseLong(arr[0]));

            Arrays.stream(arr[1].trim().split(" "))
                    .forEach(
                            item -> equation.getValues().add(Integer.parseInt(item))
                    );
            equations.add(equation);
        }
        return equations;
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
