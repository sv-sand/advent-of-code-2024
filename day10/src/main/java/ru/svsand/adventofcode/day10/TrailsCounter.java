package ru.svsand.adventofcode.day10;

import lombok.Getter;

/**
 * @author sand <sve.snd@gmail.com>
 * @since 12.12.2024
 */

public class TrailsCounter {
    private final int[][] map;
    private final int rowsCount;
    private final int columnCount;
    @Getter
    private int trailCount;

    public TrailsCounter(int[][] topographicMap) {
        this.map = topographicMap;
        this.rowsCount = map.length;
        if (rowsCount > 0)
            this.columnCount = map[0].length;
        else
            this.columnCount = 0;
    }

    public void findAllTrails() {
        for (int row = 0; row < rowsCount; row++)
            for (int column = 0; column < rowsCount; column++)
                if (map[row][column] == 0) {
                    int[][] workingMap = matrixCopy(map);
                    findTrails(workingMap, row, column);
                }
    }

    private void findTrails(int[][] workingMap, int row, int column) {
        if (workingMap[row][column] == 9) {
            trailCount++;
            workingMap[row][column] = -1;
            return;
        }
        int estimated = workingMap[row][column] + 1;

        if (row+1 < rowsCount && estimated == workingMap[row+1][column])
            findTrails(workingMap, row+1, column);
        if (row-1 >= 0 && estimated == workingMap[row-1][column])
            findTrails(workingMap, row-1, column);
        if (column+1 < columnCount && estimated == workingMap[row][column+1])
            findTrails(workingMap, row, column+1);
        if (column-1 >= 0 && estimated == workingMap[row][column-1])
            findTrails(workingMap, row, column-1);
    }

    private int[][] matrixCopy(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return new int[0][0];

        int rCount = matrix.length;
        int cCount = matrix[0].length;
        int[][] copy = new int[rCount][cCount];

        for (int row = 0; row < rowsCount; row++)
            copy[row] = matrix[row].clone();

        return copy;
    }
}
