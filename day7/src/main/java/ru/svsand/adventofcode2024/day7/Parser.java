package ru.svsand.adventofcode2024.day7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sand <sve.snd@gmail.com>
 * @since 04.12.2024
 */

public class Parser {

    public static ArrayList<Equation> read(List<String> strings) {
        ArrayList<Equation> equations = new ArrayList<>();

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

}
