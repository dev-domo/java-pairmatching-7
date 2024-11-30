package pairmatching.controller;

import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairResetController {

    private final InputView inputView;
    private final OutputView outputView;

    public PairResetController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        Level.resetPairMatching();
        Mission.resetPairedCrew();
        outputView.promptForReset();
    }
}
