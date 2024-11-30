package pairmatching.controller;

import pairmatching.domain.Course;
import pairmatching.domain.Crews;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.domain.PairMatchingMachine;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {

    private final InputView inputView;
    private final OutputView outputView;

    public PairMatchingController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start(Crews backendCrews, Crews frontendCrews) {
        outputView.promptForChoiceCourse();
        String answer = inputView.inputAnswer();
        String[] answers = answer.split(",");
        PairMatchingMachine pairMatchingMachine;

        Level level = Level.matchLevel(answers[1]);
        if (answers[0].equals(Course.FRONTEND.getName())) {
            pairMatchingMachine = new PairMatchingMachine(backendCrews);
            pairMatchingMachine.match(level, answers[2]);
            return;
        }
        pairMatchingMachine = new PairMatchingMachine(frontendCrews);
        pairMatchingMachine.match(level, answers[2]);

        outputView.showPairMatchingResult(Mission.matchMission(answers[2]).getPairedCrews());
    }
}
