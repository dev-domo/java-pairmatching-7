package pairmatching.constant;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MissionMapperTest {

    @DisplayName("미션 리스트를 형식에 맞는 문자열로 나열한다.")
    @Test
    void test() {
        // given
        String result = "미션:\n";
        // when
        result += MissionMapper.getMissions();
        // then
        assertThat(result)
                .isEqualTo("미션:\n"
                        + "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n"
                        + "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n"
                        + "  - 레벨3: \n"
                        + "  - 레벨4: 성능개선 | 배포\n"
                        + "  - 레벨5: ");
    }
}