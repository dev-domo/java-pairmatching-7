package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import pairmatching.enums.ExceptionMessage;

public enum Mission {
    CAR_RACING("자동차경주"),
    LOTTO("로또"),
    NUMBER_BASEBALL("숫자야구게임"),
    CART("장바구니"),
    PAYMENT("결제"),
    SUBWAY_LINES("지하철노선도"),
    IMPROVE_FEATURE("성능개선"),
    DISTRIBUTION("배포");

    private final String name;
    private final List<PairedCrew> pairedCrews;

    Mission(final String name) {
        this.name = name;
        this.pairedCrews = new ArrayList<>();
    }

    public void savePairedCrew(PairedCrew pairedCrew) {
        pairedCrews.add(pairedCrew);
    }

    public List<PairedCrew> getPairedCrews() {
        if (pairedCrews.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.IS_EMPTY_MATCHING.valueOf());
        }
        return pairedCrews;
    }

    public static void resetPairedCrew() {
        for (Mission mission : Mission.values()) {
            mission.pairedCrews.clear();
        }
    }
}
