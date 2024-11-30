package pairmatching.manager.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import pairmatching.domain.Crew;
import pairmatching.dto.PairMatchingResult;
import pairmatching.dto.SelectionDto;
import pairmatching.repository.CrewRepository;
import pairmatching.repository.PairMatchingRepository;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class DoPairMatchingService implements PairMatchingService {

    @Override
    public void doService() {
        OutputView.printMatchingSelections();
        SelectionDto selectionDto = InputView.getSelectionDto();

        List<PairMatchingResult> savedMatching = PairMatchingRepository.getInstance().get(selectionDto);
        if (savedMatching != null) {
            boolean reMatchingAnswer = InputView.getReMatchingAnswer();
            if (!reMatchingAnswer) {
                return;
            }
        }

        List<Crew> crews = CrewRepository.getInstance().get(selectionDto.course());
        List<Crew> shuffledCrews = Randoms.shuffle(crews);

        List<PairMatchingResult> results = new ArrayList<>();
        for (int i = 2; i <= shuffledCrews.size(); i += 2) {
            PairMatchingResult result = new PairMatchingResult(new ArrayList<>(shuffledCrews.subList(i - 2, i)));
            results.add(result);
        }
        if (shuffledCrews.size() % 2 != 0) {
            results.getLast().add(shuffledCrews.getLast());
        }
        PairMatchingRepository.getInstance().save(selectionDto, results);
        OutputView.printMatchingResult(results);
    }
}
