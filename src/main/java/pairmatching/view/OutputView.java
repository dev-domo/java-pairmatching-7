package pairmatching.view;

import java.util.List;
import pairmatching.domain.PairedCrew;
import pairmatching.enums.FeatureOptions;
import pairmatching.enums.OutputMessage;

public class OutputView {
    public void promptForChoiceFeature() {
        System.out.println(OutputMessage.CHOICE_FEATURE.valueOf());
        System.out.println(FeatureOptions.PAIR_MATCHING.valueOf());
        System.out.println(FeatureOptions.PAIR_CHECK.valueOf());
        System.out.println(FeatureOptions.PAIR_RESET.valueOf());
        System.out.println(FeatureOptions.QUIT.valueOf());
    }

    public void promptForChoiceCourse() {
        System.out.println(OutputMessage.SEPARATOR.valueOf());
        System.out.println(OutputMessage.INTRODUCE_COURSE.valueOf());
        System.out.println(OutputMessage.INTRODUCE_MISSION.valueOf());
        System.out.println(OutputMessage.INTRODUCE_LEVELS.valueOf());
        System.out.println(OutputMessage.SEPARATOR.valueOf());
        System.out.println(OutputMessage.CHOICE_COURSE.valueOf());
    }

    public void promptForRematching() {
        System.out.println(OutputMessage.REMATCH.valueOf());
    }

    public void showPairMatchingResult(List<PairedCrew> pairedCrews) {
        for (PairedCrew pairedCrew : pairedCrews) {
            System.out.println(pairedCrew.toString());
        }
    }

    public void promptForReset() {
        System.out.println(OutputMessage.COMPLETE_REMATCH.valueOf());
    }
}
