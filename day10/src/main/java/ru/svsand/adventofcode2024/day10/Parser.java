package ru.svsand.adventofcode2024.day10;

import java.util.List;

/**
 * @author sand <sve.snd@gmail.com>
 * @since 04.12.2024
 */

public class Parser {

    public static int[][] read(List<String> strings) {
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

}
