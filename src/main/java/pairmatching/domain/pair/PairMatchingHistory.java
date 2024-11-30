package pairmatching.domain.pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import pairmatching.constants.Course;
import pairmatching.constants.Level;

public class PairMatchingHistory {
    private final List<PairResult> pairResults;

    public PairMatchingHistory() {
        this.pairResults = new ArrayList<>();
    }

    public void addPairMissionType(PairResult pairResult) {
        this.pairResults.add(pairResult);
    }

    public boolean isContainSameMissionType(PairResult pairResult) {
        for (PairResult result : pairResults) {
            if(result.isSameMissionType(pairResult)){
                return true;
            }
        }
        return false;
    }

    public boolean haveDuplicateCrewPairAtSameLevel(PairResult pairResult) {
        for (PairResult result : pairResults) {
            if(result.isSameLevel(pairResult)){
                if(result.haveSamePairCrew(pairResult)){
                    return true;
                }
            }
        }
        return false;
    }

    public Optional<PairResult> findByPairResult(PairResult ptherPairResult) {
        for (PairResult pairResult : this.pairResults) {
            if(pairResult.isSameMissionType(ptherPairResult)){
                return Optional.of(pairResult);
            }
        }
        return Optional.empty();
    }

    public void allClearHistory(){
        this.pairResults.clear();
    }
}
