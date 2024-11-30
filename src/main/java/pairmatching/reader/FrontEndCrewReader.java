package pairmatching.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.domain.Crew;
import pairmatching.constant.Course;

public class FrontEndCrewReader {

    private final static String FILENAME = "src/main/resources/frontend-crew.md";

    public List<Crew> read() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(FILENAME));
            return br.lines()
                    .map(name -> new Crew(name, Course.FRONTEND))
                    .collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
