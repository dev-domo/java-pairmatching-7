package pairmatching.manager.service;

import java.util.List;
import pairmatching.dto.PairMatchingResult;
import pairmatching.dto.SelectionDto;
import pairmatching.exception.CustomException;
import pairmatching.exception.ErrorMessage;
import pairmatching.repository.PairMatchingRepository;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class GetPairMatchingService implements PairMatchingService {

    @Override
    public void doService() {
        OutputView.printMatchingSelections();
        SelectionDto selectionDto = InputView.getSelectionDto();

        List<PairMatchingResult> savedMatching = PairMatchingRepository.getInstance().get(selectionDto);
        if (savedMatching == null) {
            throw new CustomException(ErrorMessage.NOT_FOUND_PAIR_MATCHING);
        }
        OutputView.printMatchingResult(savedMatching);
    }
}
