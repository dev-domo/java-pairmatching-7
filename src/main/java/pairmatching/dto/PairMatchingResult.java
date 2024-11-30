package pairmatching.dto;

import java.util.List;
import pairmatching.exception.CustomException;
import pairmatching.exception.ErrorMessage;

public record PairMatchingResult(List<String> crews) {

    public PairMatchingResult(List<String> crews) {
        validateSize(crews);
        this.crews = crews;
    }

    private static void validateSize(List<String> crew) {
        if (crew.size() > 3) {
            throw new CustomException(ErrorMessage.INVALID_MATCHING_SIZE);
        }
    }

    @Override
    public String toString() {
        return String.join(" : ", crews);
    }

    public void add(String crew) {
        crews.add(crew);
    }
}
