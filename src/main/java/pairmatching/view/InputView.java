package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.constant.Menu;
import pairmatching.dto.SelectionDto;
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

    public static SelectionDto getSelectionDto() {
        SelectionDto dto = null;
        while (dto == null) {
            System.out.println("과정, 레벨, 미션을 선택하세요.\nex) 백엔드, 레벨1, 자동차경주");
            dto = enterSelection();
        }
        return dto;
    }

    private static SelectionDto enterSelection() {
        try {
            return SelectionDto.from(Console.readLine());
        } catch (CustomException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


}
