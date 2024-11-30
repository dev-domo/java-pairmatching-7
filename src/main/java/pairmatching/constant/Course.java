package pairmatching.constant;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

public enum Course {

    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private final String name;

    Course(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public static String getCourses() {
        return Arrays.stream(values())
                .map(Course::toString)
                .collect(Collectors.joining(" | "));
    }

    public static Optional<Course> findByName(String name) {
        return Arrays.stream(values())
                .filter(course -> course.name.equals(name))
                .findAny();
    }
}
