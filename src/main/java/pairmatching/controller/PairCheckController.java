package pairmatching.controller;

import pairmatching.domain.Mission;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairCheckController {

    private final InputView inputView;
    private final OutputView outputView;

    public PairCheckController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        outputView.promptForChoiceCourse();
        String answer = inputView.inputAnswer();
        String[] answers = answer.split(",");

        outputView.showPairMatchingResult(Mission.valueOf(answers[2]).getPairedCrews());
    }
}
