package pairmatching.domain.factory;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.Crews;

public class CrewFactoryTest {
    @Test
    void 크루를_생성() {
        List<String> crewNames = List.of("포비", "승준");

        assertThat(CrewFactory.createCrews(crewNames, Course.BACKEND)).isEqualTo(
                new Crews(List.of(new Crew(Course.BACKEND, "포비"), new Crew(Course.BACKEND, "승준"))));
    }
}
