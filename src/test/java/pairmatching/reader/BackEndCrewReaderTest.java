package pairmatching.reader;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pairmatching.constant.Course;
import pairmatching.domain.Crew;

class BackEndCrewReaderTest {

    @DisplayName("파일을 읽어 리스트에 크루 정보를 저장한다.")
    @Test
    void test1() {
        // given
        BackEndCrewReader reader = new BackEndCrewReader();
        // when
        List<Crew> crews = reader.read();
        // then
        assertThat(crews)
                .size().isEqualTo(20);
    }

    @DisplayName("각 크루의 정보는 객체에 파싱되어 저장된다.")
    @Test
    void test2() {
        // given
        BackEndCrewReader reader = new BackEndCrewReader();
        // when
        List<Crew> crews = reader.read();
        // then
        assertThat(crews.get(0))
                .hasFieldOrPropertyWithValue("name", "백호")
                .hasFieldOrPropertyWithValue("course", Course.BACKEND);
    }
}