package pairmatching;

import pairmatching.controller.MainController;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class Application {
    public static void main(String[] args) {
        MainController controller = new MainController(new InputView(), new OutputView());
        controller.start();
    }
}
