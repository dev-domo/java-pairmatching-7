package pairmatching.view;

import pairmatching.constant.Course;
import pairmatching.constant.Menu;
import pairmatching.constant.MissionMapper;

public class OutputView {

    private OutputView() {
    }

    public static void printMenus() {
        System.out.println(Menu.getMenus());
    }

    public static void printMatchingSelections() {
        System.out.println("#############################################");
        System.out.println("과정: " + Course.getCourses());
        System.out.println("미션:\n" + MissionMapper.getMissions());
        System.out.println("#############################################");
    }
}
