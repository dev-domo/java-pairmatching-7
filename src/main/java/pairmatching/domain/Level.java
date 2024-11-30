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
    private final List<PairedCrew> pairedCrews;

    Level(String name, List<Mission> missions) {
        this.name = name;
        this.missions = missions;
        this.pairedCrews = new ArrayList<>();
    }


}
