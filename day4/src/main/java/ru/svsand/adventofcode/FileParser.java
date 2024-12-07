package ru.svsand.adventofcode;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author sand <sve.snd@gmail.com>
 * @since 04.12.2024
 */

public class FileParser {
    String fileName;

    public FileParser(String fileName) {
        this.fileName = fileName;
    }

    public char[][] read() {
        char[][] matrix = createMatrix();

        try (FileReader fileReader = new FileReader(fileName)) {
            for (char[] string: matrix) {
                fileReader.read(string);
                fileReader.read();  // read \n
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return matrix;
    }

    private char[][] createMatrix() {
        int height = 0, width = 0;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line = bufferedReader.readLine();
            if (line.length() == 0)
                throw new IOException("File empty");

            width = line.length();
            while (line != null) {
                height++;
                line = bufferedReader.readLine();
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new char[height][width];
    }
}
