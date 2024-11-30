package pairmatching.domain;

import java.util.List;
import pairmatching.enums.ExceptionMessage;

public class PairMatchingMachine {
    private final Crews crews;

    public PairMatchingMachine(final Crews crews) {
        this.crews = crews;
    }

    public void match() {
        List<String> shuffledCrews;
        int count = 0;
        do {
            shuffledCrews = crews.shuffleCrews();
            count++;
        } while (!isPossibleMatch(shuffledCrews) && count < 3);

        if (count == 3) {
            throw new IllegalArgumentException(ExceptionMessage.IMPOSSIBLE_MATCHING_CREW.valueOf());
        }

        for (int i = 0; i < shuffledCrews.size(); i += 2) {
            String firstCrew = shuffledCrews.get(i);
            String secondCrew = shuffledCrews.get(i + 1);

            Level.savePairedCrew(firstCrew, secondCrew);
        }
    }

    public boolean isPossibleMatch(List<String> shuffledCrews) {
        for (int i = 0; i < shuffledCrews.size(); i += 2) {
            String firstCrew = shuffledCrews.get(i);
            String secondCrew = shuffledCrews.get(i + 1);

            if (Level.checkAlreadyPaired(firstCrew, secondCrew)) {
                return false;
            }
        }
        return true;
    }
}
