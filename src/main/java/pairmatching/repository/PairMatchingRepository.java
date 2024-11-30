package pairmatching.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pairmatching.dto.PairMatchingResult;
import pairmatching.dto.SelectionDto;

public enum PairMatchingRepository {

    PAIR_MATCHING_REPOSITORY_REPOSITORY;

    private static final Map<SelectionDto, List<PairMatchingResult>> MATCHINGS = new HashMap<>();

    public static PairMatchingRepository getInstance() {
        return PAIR_MATCHING_REPOSITORY_REPOSITORY;
    }

    public void save(SelectionDto selectionDto, List<PairMatchingResult> pairMatchingResults) {
        MATCHINGS.put(selectionDto, pairMatchingResults);
    }

    public List<PairMatchingResult> get(SelectionDto selectionDto) {
        return MATCHINGS.get(selectionDto);
    }

    public void clear() {
        MATCHINGS.clear();
    }
}
