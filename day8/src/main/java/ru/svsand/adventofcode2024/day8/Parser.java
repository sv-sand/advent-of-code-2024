package ru.svsand.adventofcode2024.day8;

import java.util.List;

/**
 * @author sand <sve.snd@gmail.com>
 * @since 04.12.2024
 */

public class Parser {

    public static char[][] parse(List<String> strings) {
        if(strings.size() == 0)
            return new char[0][0];

        char[][] data = new char[strings.size()][strings.get(0).length()];
        for (int row = 0; row < strings.size(); row++) {
            data[row] = strings.get(row).toCharArray();
        }
        return data;
    }
}
