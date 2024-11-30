package pairmatching.constant;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CourseTest {

    @DisplayName("코스 리스트를 형식에 맞는 문자열로 나열한다.")
    @Test
    void test() {
        // given
        String result = "과정: ";
        // when
        result += Course.getCourses();
        // then
        assertThat(result)
                .isEqualTo("과정: 백엔드 | 프론트엔드");
    }
}