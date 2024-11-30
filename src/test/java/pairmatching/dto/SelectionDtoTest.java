package pairmatching.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pairmatching.constant.Course;
import pairmatching.constant.Level;

class SelectionDtoTest {

    @DisplayName("선택 사항 입력값을 기반으로 객체를 파싱한다.")
    @Test
    void test() {
        // given
        String input = "백엔드, 레벨1, 자동차경주";
        // when
        SelectionDto dto = SelectionDto.from(input);
        // then
        assertThat(dto)
                .hasFieldOrPropertyWithValue("course", Course.BACKEND)
                .hasFieldOrPropertyWithValue("level", Level.LEVEL1)
                .hasFieldOrPropertyWithValue("missionName", "자동차경주");
    }

}