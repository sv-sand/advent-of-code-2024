package ru.svsand.adventofcode2024.day1;

import lombok.Getter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author sand <sve.snd@gmail.com>
 * @since 02.12.2024
 */

public class FileParser {
    private final String SPLITTER = "   ";
    private final BufferedReader bufferedReader;

    @Getter
    private String value1;
    @Getter
    private String value2;

    public FileParser(String fileName) throws FileNotFoundException {
        FileReader fileReader = new FileReader(fileName);
        bufferedReader = new BufferedReader(fileReader);
    }

    public boolean readLine() throws IOException {
        String line = bufferedReader.readLine();
        if (line == null)
            return false;

        String[] arr = line.split(SPLITTER);
        value1 = arr[0];
        value2 = arr[1];

        return true;
    }


}
