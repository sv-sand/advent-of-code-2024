package ru.svsand.adventofcode2024.day9;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sand <sve.snd@gmail.com>
 * @since 10.12.2024
 */

public class Parser {

    public static ArrayList<Integer> read(List<String> strings) {
        ArrayList<Integer> diskMap = new ArrayList<>();

        for (String string: strings)
            for (char symbol: string.toCharArray())
                diskMap.add(Integer.parseInt(String.valueOf(symbol)));

        return diskMap;
    }
}
