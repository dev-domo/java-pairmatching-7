package pairmatching.view;

import java.util.Scanner;
import pairmatching.constant.Menu;
import pairmatching.dto.SelectionDto;
import pairmatching.exception.CustomException;
import pairmatching.exception.ErrorMessage;

public class InputView {

    private static final Scanner SCAN = new Scanner(System.in);

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
            return Menu.get(SCAN.nextLine())
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
            return SelectionDto.from(SCAN.nextLine());
        } catch (CustomException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static boolean getReMatchingAnswer() {
        Boolean yesOrNo = null;
        while (yesOrNo == null) {
            System.out.println("매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n네 | 아니오");
            yesOrNo = getYesOrNo();
        }
        return yesOrNo;
    }

    private static Boolean getYesOrNo() {
        try {
            return enterYesOrNo();
        } catch (CustomException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private static boolean enterYesOrNo() {
        String answer = SCAN.nextLine();
        if (!(answer.equals("네") || answer.equals("아니오"))) {
            throw new CustomException(ErrorMessage.INVALID_YES_OR_NO);
        }
        return answer.equals("네");
    }
}
