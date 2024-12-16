package ru.svsand.adventofcode2024.day8;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.*;

/**
 * @author sand <sve.snd@gmail.com>
 * @since 08.12.2024
 */

public class ImpactOfSignalCalculator {
    private final char[][] map;
    private final int rowsCount;
    private final int columnsCount;
    private final HashMap<Character, ArrayList<Coordinate>> groupAntennas = new HashMap<>();

    @Getter
    private final HashSet<Coordinate> antinodes = new HashSet<>();

    @AllArgsConstructor
    public class Coordinate {
        @Getter
        private int x;
        @Getter
        private int y;

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;

            if (obj == null || getClass() != obj.getClass())
                return false;

            Coordinate object = (Coordinate) obj;

            return x == object.getX() && y == object.getY();
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return x + " - " + y;
        }
    }

    public ImpactOfSignalCalculator(char[][] mapOfAntennas) {
        map = mapOfAntennas;
        rowsCount = map.length;

        if (rowsCount == 0)
            columnsCount = 0;
        else
            columnsCount = map[0].length;
    }

    public int setAntinodes(int maxCount) {
        findAntennas();
        placeAntinodes(maxCount);
        return getAntinodes().size();
    }

    private void findAntennas() {
        for (int row = 0; row < rowsCount; row++)
            for (int column = 0; column < columnsCount; column++)
                if (map[row][column] != '.') {
                    char key = map[row][column];
                    if (groupAntennas.get(key) == null)
                        groupAntennas.put(key, new ArrayList<>());
                    groupAntennas.get(key).add(new Coordinate(column, row));
                }
    }

    private void placeAntinodes(int maxCount) {
        for (Map.Entry<Character, ArrayList <Coordinate>> entry: groupAntennas.entrySet()) {
            Combinator combinator = new Combinator(entry.getValue().size());
            int[][] combinations = combinator.getCombinations();

            for (int[] combination: combinations) {
                Coordinate antenna1 = groupAntennas.get(entry.getKey()).get(combination[0]);
                Coordinate antenna2 = groupAntennas.get(entry.getKey()).get(combination[1]);

                int dx = antenna2.getX() - antenna1.getX();
                int dy = antenna2.getY() - antenna1.getY();

                for (int i = 1; i <= maxCount ; i++) {
                    Coordinate antinode = new Coordinate(antenna1.getX() - dx*i, antenna1.getY() - dy*i);
                    if (!antinodeInBounds(antinode))
                        break;
                    placeAntinode(antinode);
                }

                for (int i = 1; i <= maxCount; i++) {
                    Coordinate antinode = new Coordinate(antenna2.getX() + dx*i, antenna2.getY() + dy*i);
                    if (!antinodeInBounds(antinode))
                        break;
                    placeAntinode(antinode);
                }
            }
        }
    }

    private boolean antinodeInBounds(Coordinate antinode) {
        return  antinode.getX() >= 0 && antinode.getX() < columnsCount &&
                antinode.getY() >= 0 && antinode.getY() < rowsCount;
    }

    private void placeAntinode(Coordinate antinode) {
        antinodes.add(antinode);

        if (map[antinode.getY()][antinode.getX()] == '.')
            map[antinode.getY()][antinode.getX()] = '#';
    }
}
