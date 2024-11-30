package pairmatching.view;

import java.util.Arrays;
import pairmatching.constant.Menu;

public class OutputView {

    private OutputView() {}

    public static void printMenus() {
        Arrays.stream(Menu.values()).forEach(System.out::println);
    }
}
