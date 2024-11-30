package pairmatching.constant;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

public enum Menu {

    DO_PAIR_MATCHING("1", "페어 매칭"),
    GET_PAIR_MATCHING("2", "페어 조회"),
    CLEAR_PAIR_MATCHING("3", "페어 초기화"),
    QUIT("Q", "종료");

    private final String number;
    private final String name;

    Menu(String number, String name) {
        this.number = number;
        this.name = name;
    }

    public static Optional<Menu> get(String number) {
        return Arrays.stream(values())
                .filter(menu -> menu.number.equals(number))
                .findAny();
    }

    @Override
    public String toString() {
        return number + ". " + name;
    }

    public static String getMenus() {
        return Arrays.stream(values())
                .map(Menu::toString)
                .collect(Collectors.joining("\n"));
    }
}
