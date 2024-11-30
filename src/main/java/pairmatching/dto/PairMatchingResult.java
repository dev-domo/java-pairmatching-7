package pairmatching.dto;

import java.util.List;
import java.util.stream.Collectors;
import pairmatching.domain.Crew;
import pairmatching.exception.CustomException;
import pairmatching.exception.ErrorMessage;

public record PairMatchingResult(List<Crew> crews) {

    public PairMatchingResult(List<Crew> crews) {
        validateSize(crews);
        this.crews = crews;
    }

    private static void validateSize(List<Crew> crew) {
        if (crew.size() > 3) {
            throw new CustomException(ErrorMessage.INVALID_MATCHING_SIZE);
        }
    }

    @Override
    public String toString() {
        return crews.stream().map(Crew::toString).collect(Collectors.joining(" : "));
    }

    public void add(Crew crew) {
        crews.add(crew);
    }
}
