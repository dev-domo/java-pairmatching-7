package pairmatching.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CrewsTest {
    @Test
    void Crews_생성() {
        Crews crews = new Crews(List.of(new Crew(Course.BACKEND, "포비"), new Crew(Course.BACKEND, "승준")));

        assertThat(crews).isEqualTo(new Crews(List.of(new Crew(Course.BACKEND, "포비"), new Crew(Course.BACKEND, "승준"))));
    }
}
