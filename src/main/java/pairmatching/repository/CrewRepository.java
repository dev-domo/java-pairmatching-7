package pairmatching.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pairmatching.constant.Course;

public enum CrewRepository {

    CREW_REPOSITORY;

    private static final Map<Course, List<String>> CREWS = new HashMap<>();

    static {
        Arrays.stream(Course.values())
                .forEach(course -> CREWS.put(course, new ArrayList<>()));
    }

    public static CrewRepository getInstance() {
        return CREW_REPOSITORY;
    }

    public void save(Course course, List<String> crews) {
        CREWS.put(course, crews);
    }

    public List<String> get(Course course) {
        return CREWS.get(course);
    }

    public void clear() {
        CREWS.clear();
    }
}
