package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public enum Level {
    LEVEL1("레벨1", List.of(Mission.CAR_RACING, Mission.LOTTO, Mission.NUMBER_BASEBALL)),
    LEVEL2("레벨2", List.of(Mission.CART, Mission.PAYMENT, Mission.SUBWAY_LINES)),
    LEVEL3("레벨3", List.of()),
    LEVEL4("레벨4", List.of(Mission.IMPROVE_FEATURE, Mission.DISTRIBUTION)),
    LEVEL5("레벨5", List.of());

    private final String name;
    private final List<Mission> missions;
    private final List<PairedCrew> pairedCrews = new ArrayList<>();

    Level(String name, List<Mission> missions) {
        this.name = name;
        this.missions = missions;
    }

    public void savePairedCrew(String firstCrew, String secondCrew, String missionName) {
        pairedCrews.add(new PairedCrew(firstCrew, secondCrew));
        Mission.valueOf(missionName).savePairedCrew(new PairedCrew(firstCrew, secondCrew));
    }

    public void savePairedCrew(String firstCrew, String secondCrew, String thirdCrew, String missionName) {
        pairedCrews.add(new ThreePairedCrew(firstCrew, secondCrew, thirdCrew));
        Mission.valueOf(missionName).savePairedCrew(new ThreePairedCrew(firstCrew, secondCrew, thirdCrew));
    }

    public boolean checkAlreadyPaired(String firstCrew, String secondCrew) {
        for (PairedCrew pairedCrew : pairedCrews) {
            if (pairedCrew.isEqualCrews(firstCrew, secondCrew)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkAlreadyPaired(String firstCrew, String secondCrew, String thirdCrew) {
        for (PairedCrew pairedCrew : pairedCrews) {
            if (pairedCrew.isEqualCrews(firstCrew, secondCrew, thirdCrew)) {
                return true;
            }
        }
        return false;
    }

    public static void resetPairMatching() {
        for (Level level : Level.values()) {
            level.pairedCrews.clear();
        }
    }
}
