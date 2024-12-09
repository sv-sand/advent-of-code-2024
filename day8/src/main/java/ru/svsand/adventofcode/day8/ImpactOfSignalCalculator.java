package ru.svsand.adventofcode.day8;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sand <sve.snd@gmail.com>
 * @since 08.12.2024
 */

public class ImpactOfSignalCalculator {
    private char[][] map;
    private int rowsCount;
    private int columnsCount;
    private HashMap<Character, ArrayList<Coordinate>> groupAntennas = new HashMap<>();

    @Getter
    private int countAntinodes = 0;

    @AllArgsConstructor
    public class Coordinate {
        @Getter
        private int x;
        @Getter
        private int y;
    }

    public ImpactOfSignalCalculator(char[][] mapOfAntennas) {
        map = mapOfAntennas;
        rowsCount = map.length;

        if (rowsCount == 0)
            columnsCount = 0;
        else
            columnsCount = map[0].length;
    }

    public void findAntennas() {
        for (int row = 0; row < rowsCount; row++)
            for (int column = 0; column < columnsCount; column++)
                if (map[row][column] != '.') {
                    char key = map[row][column];
                    if (groupAntennas.get(key) == null)
                        groupAntennas.put(key, new ArrayList<Coordinate>());
                    groupAntennas.get(key).add(new Coordinate(column, row));
                }
    }

    public void setAntinodes() {
        for (Map.Entry<Character, ArrayList <Coordinate>> entry: groupAntennas.entrySet()) {
            Combinator combinator = new Combinator(entry.getValue().size());
            int[][] combinations = combinator.getCombinations();
            for (int[] combination: combinations) {
                Coordinate antenna1 = groupAntennas.get(entry.getKey()).get(combination[0]);
                Coordinate antenna2 = groupAntennas.get(entry.getKey()).get(combination[1]);
                placeAntinode(antenna1, antenna2);
            }
        }
    }

    private void placeAntinode(Coordinate antenna1, Coordinate antenna2) {
        Coordinate antinode1 = new Coordinate(
                antenna1.getX() - (antenna2.getX() - antenna1.getX()),
                antenna1.getY() - (antenna2.getY() - antenna1.getY())
        );

        Coordinate antinode2 = new Coordinate(
                antenna2.getX() + (antenna2.getX() - antenna1.getX()),
                antenna2.getY() + (antenna2.getY() - antenna1.getY())
        );

        if (antinode1.getX() >= 0 && antinode1.getX() < columnsCount && antinode1.getY() >= 0 && antinode1.getY() < rowsCount) {
            if (map[antinode1.getY()][antinode1.getX()] != '#')
                countAntinodes++;

            if (map[antinode1.getY()][antinode1.getX()] == '.')
                map[antinode1.getY()][antinode1.getX()] = '#';

        }

        if (antinode2.getX() >= 0 && antinode2.getX() < columnsCount && antinode2.getY() >= 0 && antinode2.getY() < rowsCount) {
            if (map[antinode2.getY()][antinode2.getX()] != '#')
                countAntinodes++;

            if (map[antinode2.getY()][antinode2.getX()] == '.')
                map[antinode2.getY()][antinode2.getX()] = '#';
        }
    }
}
