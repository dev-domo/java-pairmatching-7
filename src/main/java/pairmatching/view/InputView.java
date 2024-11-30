package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.constant.Menu;
import pairmatching.exception.CustomException;
import pairmatching.exception.ErrorMessage;

public class InputView {

    private InputView() {
    }

    public static Menu getMenu() {
        Menu menu = null;
        while (menu == null) {
            menu = enterMenu();
        }
        return menu;
    }

    private static Menu enterMenu() {
        try {
            return Menu.get(Console.readLine())
                    .orElseThrow(() -> new CustomException(ErrorMessage.INVALID_MENU));
        } catch (CustomException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


}
