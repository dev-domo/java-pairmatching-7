package pairmatching.view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import pairmatching.enums.ExceptionMessage;

public class ResourceReader {
    public List<String> read(String path) {
        List<String> names = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            addName(bufferedReader, names);
        } catch (IOException exception) {
            System.out.println(ExceptionMessage.NOT_FOUND_FILE.valueOf());
        }
        return names;
    }

    private void addName(BufferedReader bufferedReader, List<String> names) throws IOException {
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            names.add(line);
        }
    }
}
