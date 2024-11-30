package pairmatching;

import pairmatching.constant.Course;
import pairmatching.exception.CustomException;
import pairmatching.exception.ErrorMessage;

public class Crew {

    private final String name;
    private final Course course;

    public Crew(String name, Course course) {
        validateName(name);
        this.name = name;
        this.course = course;
    }

    private void validateName(String name) {
        if (name.isEmpty()) {
            throw new CustomException(ErrorMessage.INVALID_CREW_NAME);
        }
    }

    @Override
    public String toString() {
        return "Crew{" +
                "name='" + name + '\'' +
                ", course=" + course +
                '}';
    }
}
