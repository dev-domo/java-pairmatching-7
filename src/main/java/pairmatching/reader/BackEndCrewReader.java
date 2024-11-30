package pairmatching.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

public class BackEndCrewReader {

    private final static String FILENAME = "src/main/resources/backend-crew.md";

    public List<String> read() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(FILENAME));
            return br.lines()
                    .collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
