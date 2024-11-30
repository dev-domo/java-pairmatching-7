package pairmatching.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class PairedCrewTest {
    @Test
    void 페어된_크루_생성() {
        PairedCrew pairedCrew = new PairedCrew("포비", "승준");

        assertThat(pairedCrew).isEqualTo(new PairedCrew("포비", "승준"));
    }
}
