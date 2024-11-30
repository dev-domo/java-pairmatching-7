package pairmatching.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CrewTest {
    @Test
    void 크루_생성() {
        Crew crew = new Crew(Course.BACKEND, "포비");

        assertThat(crew).isEqualTo(new Crew(Course.BACKEND, "포비"));
    }
}
