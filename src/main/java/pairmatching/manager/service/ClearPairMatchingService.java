package pairmatching.manager.service;

import java.util.List;
import pairmatching.dto.PairMatchingResult;
import pairmatching.dto.SelectionDto;
import pairmatching.exception.CustomException;
import pairmatching.exception.ErrorMessage;
import pairmatching.repository.PairMatchingRepository;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class ClearPairMatchingService implements PairMatchingService {

    @Override
    public void doService() {
        PairMatchingRepository.getInstance().clear();
        OutputView.printMatchingClearComplete();
    }
}
