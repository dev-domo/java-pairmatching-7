package pairmatching.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import pairmatching.domain.reader.BackendReader;
import pairmatching.domain.reader.FrontendReader;

public class CrewsByCourse {
    private final List<Crew> backend;
    private final List<Crew> frontEnd;

    public CrewsByCourse(BackendReader backendReader, FrontendReader frontendReader) {
        List<Crew> backend = backendReader.read();
        List<Crew> frontEnd = frontendReader.read();
        validateDuplicates(backend, frontEnd);
        this.backend = backend;
        this.frontEnd = frontEnd;
    }




    public static void validateDuplicates(List<Crew> backends, List<Crew> frontEnds) {
        Set<Crew> back = new HashSet<>();
        for (Crew backend : backends) {
            if (!back.add(backend)) {
                throw new IllegalArgumentException("중복된 백엔드 크루가 있어요.");
            }
        }
        Set<Crew> front = new HashSet<>();
        for (Crew fontend : frontEnds) {
            if (!front.add(fontend)) {
                throw new IllegalArgumentException("중복된 프론트 크루가 있어요.");
            }
        }
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
