package pairmatching.constant;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MenuTest {

    @DisplayName("메뉴 리스트를 형식에 맞는 문자열로 나열한다.")
    @ParameterizedTest
    @CsvSource(value = {"0:1. 페어 매칭", "1:2. 페어 조회", "2:3. 페어 초기화", "3:Q. 종료"}, delimiter = ':')
    void test(int idx, String expectedMenuString) {
        // given
        Menu[] values = Menu.values();
        // when
        List<String> menus = Arrays.stream(values).map(Menu::toString).collect(Collectors.toList());
        // then
        assertThat(menus.get(idx))
                .isEqualTo(expectedMenuString);
    }
}