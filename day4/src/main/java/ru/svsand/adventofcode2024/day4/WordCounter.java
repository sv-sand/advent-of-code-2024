package ru.svsand.adventofcode2024.day4;

/**
 * @author sand <sve.snd@gmail.com>
 * @since 04.12.2024
 */

public class WordCounter {
    private final char[][] matrix;
    private final int width;
    private final int height;

    public WordCounter(char[][] matrixWithWords) {
        matrix = matrixWithWords;
        height = matrix.length;
        width = matrix[0].length;
    }

    public int calculateXmas() {
        int count = 0;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                if (x+3 < width  && matrix[y][x] == 'X' && matrix[y][x+1] == 'M' && matrix[y][x+2] == 'A' && matrix[y][x+3] == 'S') count++;
                if (x-3 >= 0     && matrix[y][x] == 'X' && matrix[y][x-1] == 'M' && matrix[y][x-2] == 'A' && matrix[y][x-3] == 'S') count++;
                if (y+3 < height && matrix[y][x] == 'X' && matrix[y+1][x] == 'M' && matrix[y+2][x] == 'A' && matrix[y+3][x] == 'S') count++;
                if (y-3 >= 0     && matrix[y][x] == 'X' && matrix[y-1][x] == 'M' && matrix[y-2][x] == 'A' && matrix[y-3][x] == 'S') count++;

                if (x+3 < width    && y+3 < height    && matrix[y][x] == 'X' && matrix[y+1][x+1] == 'M' && matrix[y+2][x+2] == 'A' && matrix[y+3][x+3] == 'S') count++;
                if (x-3 >= 0       && y+3 < height    && matrix[y][x] == 'X' && matrix[y+1][x-1] == 'M' && matrix[y+2][x-2] == 'A' && matrix[y+3][x-3] == 'S') count++;
                if (x+3 < width    && y-3 >= 0         && matrix[y][x] == 'X' && matrix[y-1][x+1] == 'M' && matrix[y-2][x+2] == 'A' && matrix[y-3][x+3] == 'S') count++;
                if (x-3 >= 0       && y-3 >= 0         && matrix[y][x] == 'X' && matrix[y-1][x-1] == 'M' && matrix[y-2][x-2] == 'A' && matrix[y-3][x-3] == 'S') count++;
            }
        }
        return count;
    }

    public int calculateXMas() {
        int count = 0;

        for (int y = 0; y < height - 2; y++) {
            for (int x = 0; x < width - 2; x++) {

                if (matrix[y][x] == 'M' && matrix[y+1][x+1] == 'A' && matrix[y+2][x+2] == 'S'   && matrix[y][x+2] == 'M' && matrix[y+1][x+1] == 'A' && matrix[y+2][x] == 'S') count++;
                if (matrix[y][x] == 'M' && matrix[y+1][x+1] == 'A' && matrix[y+2][x+2] == 'S'   && matrix[y][x+2] == 'S' && matrix[y+1][x+1] == 'A' && matrix[y+2][x] == 'M') count++;
                if (matrix[y][x] == 'S' && matrix[y+1][x+1] == 'A' && matrix[y+2][x+2] == 'M'   && matrix[y][x+2] == 'M' && matrix[y+1][x+1] == 'A' && matrix[y+2][x] == 'S') count++;
                if (matrix[y][x] == 'S' && matrix[y+1][x+1] == 'A' && matrix[y+2][x+2] == 'M'   && matrix[y][x+2] == 'S' && matrix[y+1][x+1] == 'A' && matrix[y+2][x] == 'M') count++;

            }
        }
        return count;
    }
}
