package pairmatching.domain;

import java.util.List;
import pairmatching.enums.ExceptionMessage;

public class PairMatchingMachine {
    private static final int MAX_TRY_COUNT = 3;

    private final Crews crews;

    public PairMatchingMachine(final Crews crews) {
        this.crews = crews;
    }

    public void match(Level level, String missionName) {
        List<String> shuffledCrews = doMatch(level);
        int crewSize = shuffledCrews.size();

        for (int i = 0; i < shuffledCrews.size() - 1; i += 2) {
            if (i == crewSize - 3) {
                level.savePairedCrew(shuffledCrews.get(i), shuffledCrews.get(i + 1), shuffledCrews.get(i + 2),
                        missionName);
            }
            level.savePairedCrew(shuffledCrews.get(i), shuffledCrews.get(i + 1), missionName);
        }
    }

    private List<String> doMatch(Level level) {
        List<String> shuffledCrews;
        int count = 0;
        do {
            shuffledCrews = crews.shuffleCrews();
            count++;
        } while (!isPossibleMatch(level, shuffledCrews) && count < MAX_TRY_COUNT);

        checkMatchCount(count);
        return shuffledCrews;
    }

    public boolean isPossibleMatch(Level level, List<String> shuffledCrews) {
        int crewSize = shuffledCrews.size();

        for (int i = 0; i < shuffledCrews.size() - 1; i += 2) {
            if (caseThreePair(level, shuffledCrews, i, crewSize)) {
                return false;
            }
            if (level.checkAlreadyPaired(shuffledCrews.get(i), shuffledCrews.get(i + 1))) {
                return false;
            }
        }
        return true;
    }

    private boolean caseThreePair(Level level, List<String> shuffledCrews, int i, int crewSize) {
        if (i == crewSize - 3) {
            return level.checkAlreadyPaired(shuffledCrews.get(i), shuffledCrews.get(i + 1),
                    shuffledCrews.get(i + 2));
        }
        return false;
    }

    private void checkMatchCount(int count) {
        if (count == MAX_TRY_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.IMPOSSIBLE_MATCHING_CREW.valueOf());
        }
    }
}
