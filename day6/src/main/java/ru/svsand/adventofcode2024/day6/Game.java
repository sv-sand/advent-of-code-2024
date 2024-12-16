package ru.svsand.adventofcode2024.day6;

import lombok.Getter;

/**
 * @author sand <sve.snd@gmail.com>
 * @since 06.12.2024
 */

public class Game {
    @Getter
    private int x;
    @Getter
    private int y;

    private final char[][] map;

    public Game(char[][] initialMap) {
        map = initialMap;
        findInitialPosition();
    }

    public void start () {
        go();
        while (!isFinished()) {
            turnRight();
            go();
        }
    }

    private void findInitialPosition() {
        for (int row = 0; row < map.length; row++)
            for (int column = 0; column < map.length; column++)
                if (map[row][column] == '^') {
                    x = row;
                    y = column;
                }
    }

    private boolean isFinished() {
        return x-1 < 0 || y-1 < 0 || x+1 >= map.length || y+1 >= map[0].length;
    }

    private void go() {
        if (map[x][y] == '^')
            goUp();

        if (map[x][y] == '>')
            goRight();

        if (map[x][y] == 'v')
            goDown();

        if (map[x][y] == '<')
            goLeft();
    }

    private void goUp() {
        for (int row = x - 1; row >= 0; row--) {
            if (map[row][y] == '#')
                break;
            map[x][y] = 'X';
            x = row;
            map[x][y] = '^';
        }
    }

    private void goDown() {
        for (int row = x + 1; row < map.length; row++) {
            if (map[row][y] == '#')
                break;
            map[x][y] = 'X';
            x = row;
            map[x][y] = 'v';
        }
    }

    private void goRight() {
        for (int column = y + 1; column < map[0].length; column++) {
            if (map[x][column] == '#')
                break;
            map[x][y] = 'X';
            y = column;
            map[x][y] = '>';
        }
    }

    private void goLeft() {
        for (int column = y - 1; column >= 0; column--) {
            if (map[x][column] == '#')
                break;
            map[x][y] = 'X';
            y = column;
            map[x][y] = '<';
        }
    }

    private void turnRight() {
        if (map[x][y] == '^')
            map[x][y] = '>';

        else if (map[x][y] == '>')
            map[x][y] = 'v';

        else if (map[x][y] == 'v')
            map[x][y] = '<';

        else if (map[x][y] == '<')
            map[x][y] = '^';
    }

    public long countWay() {
        long way = 0;

        for (int row = 0; row < map.length; row++)
            for (int column = 0; column < map.length; column++)
                if (map[row][column] == 'X' || map[row][column] == '^' || map[row][column] == 'v' || map[row][column] == '<' || map[row][column] == '>')
                    way++;

        return way;
    }

}
