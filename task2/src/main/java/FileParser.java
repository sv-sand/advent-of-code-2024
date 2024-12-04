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
    private final String SPLITTER = " ";
    private BufferedReader bufferedReader;

    @Getter
    private String[] data;

    public FileParser(String fileName) throws FileNotFoundException {
        FileReader fileReader = new FileReader(fileName);
        bufferedReader = new BufferedReader(fileReader);
    }

    public boolean readLine() throws IOException {
        String line = bufferedReader.readLine();
        if (line == null)
            return false;

        data = line.split(SPLITTER);
        return true;
    }
}
