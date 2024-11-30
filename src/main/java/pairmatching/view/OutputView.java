package pairmatching.view;

import java.util.List;
import pairmatching.constant.Course;
import pairmatching.constant.Menu;
import pairmatching.constant.MissionMapper;
import pairmatching.dto.PairMatchingResult;

public class OutputView {

    private OutputView() {
    }

    public static void printMenus() {
        System.out.println("\n기능을 선택하세요.");
        System.out.println(Menu.getMenus());
    }

    public static void printMatchingSelections() {
        System.out.println("\n#############################################");
        System.out.println("과정: " + Course.getCourses());
        System.out.println("미션:\n" + MissionMapper.getMissions());
        System.out.println("#############################################");
    }

    public static void printMatchingResult(List<PairMatchingResult> results) {
        System.out.println("\n페어 매칭 결과입니다.");
        results.forEach(result -> System.out.println(result.toString()));
    }

    public static void printMatchingClearComplete() {
        System.out.println("초기화 되었습니다.");
    }
}
