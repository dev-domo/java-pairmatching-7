package pairmatching.constant;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuTest {

    @DisplayName("메뉴 리스트를 형식에 맞는 문자열로 나열한다.")
    @Test
    void test() {
        // given & when
        String menus = Menu.getMenus();
        // then
        assertThat(menus)
                .isEqualTo("1. 페어 매칭\n"
                        + "2. 페어 조회\n"
                        + "3. 페어 초기화\n"
                        + "Q. 종료");
    }
}