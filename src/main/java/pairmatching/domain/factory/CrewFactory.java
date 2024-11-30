package pairmatching.domain.factory;

import java.util.ArrayList;
import java.util.List;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.Crews;

public class CrewFactory {

    public static Crews createCrews(List<String> crewNames, Course course) {
        List<Crew> crews = new ArrayList<>();
        for (String name : crewNames) {
            crews.add(new Crew(course, name));
        }
        return new Crews(crews);
    }
}
