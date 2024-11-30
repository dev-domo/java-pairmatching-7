package pairmatching.manager;

import pairmatching.constant.Menu;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingRunner {

    public PairMatchingRunner() {
        new PairMatchingCreator().initCrews();
    }

    public void run() {
        while (true) {
            OutputView.printMenus();
            Menu menu = InputView.getMenu();
            if (menu == Menu.QUIT) {
                break;
            }
            ServiceMapper.doService(menu);
        }
    }
}
