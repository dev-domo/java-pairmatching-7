package pairmatching.controller;

import pairmatching.domain.Course;
import pairmatching.domain.Crews;
import pairmatching.domain.factory.CrewFactory;
import pairmatching.enums.FeatureOptions;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;
import pairmatching.view.ResourceReader;

public class MainController {
    private static final String BACKEND_FILE_PATH = "src/main/resources/backend-crew.md";
    private static final String FRONTEND_FILE_PATH = "src/main/resources/frontend-crew.md";

    private final InputView inputView;
    private final OutputView outputView;
    private final PairMatchingController pairMatchingController;
    private final PairCheckController pairCheckController;
    private final PairResetController pairResetController;

    public MainController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.pairMatchingController = new PairMatchingController(inputView, outputView);
        this.pairCheckController = new PairCheckController(inputView, outputView);
        this.pairResetController = new PairResetController(inputView, outputView);
    }

    public void start() {
        String answer;
        ResourceReader resourceReader = new ResourceReader();
        Crews backendCrews = CrewFactory.createCrews(resourceReader.read(BACKEND_FILE_PATH), Course.BACKEND);
        Crews frontendCrews = CrewFactory.createCrews(resourceReader.read(FRONTEND_FILE_PATH), Course.FRONTEND);

        do {
            answer = choiceFeature();
            if (answer.equals("1")) {
                pairMatchingController.start(backendCrews, frontendCrews);
            }
            if (answer.equals("2")) {
                pairCheckController.start();
            }
            if (answer.equals("3")) {
                pairResetController.start();
            }
        } while (answer.equals("Q"));
    }

    private String choiceFeature() {
        String answer;
        while (true) {
            try {
                outputView.promptForChoiceFeature();
                answer = FeatureOptions.validate(inputView.inputAnswer());
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
        return answer;
    }
}
