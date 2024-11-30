package pairmatching.domain;

import java.util.List;
import pairmatching.domain.reader.BackendReader;
import pairmatching.domain.reader.FrontendReader;

public class CrewsByCourse {
    private final List<Crew> backend;
    private final List<Crew> frontEnd;

    public CrewsByCourse(BackendReader backendReader, FrontendReader frontendReader) {
        backend = backendReader.read();
        frontEnd = frontendReader.read();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Crew crew : backend) {
            builder.append(crew.toString()).append("\n");
        }
        for (Crew crew : frontEnd) {
            builder.append(crew.toString()).append("\n");
        }
        return builder.toString();
    }


}
