package pairmatching.reader;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FrontEndCrewReaderTest {

    @DisplayName("파일을 읽어 리스트에 크루 정보를 저장한다.")
    @Test
    void test1() {
        // given
        FrontEndCrewReader reader = new FrontEndCrewReader();
        // when
        List<String> crews = reader.read();
        // then
        assertThat(crews)
                .size().isEqualTo(15);
    }

    @DisplayName("각 크루의 정보는 객체에 파싱되어 저장된다.")
    @Test
    void test2() {
        // given
        FrontEndCrewReader reader = new FrontEndCrewReader();
        // when
        List<String> crews = reader.read();
        // then
        assertThat(crews)
                .contains("보노", "라라");
    }
}