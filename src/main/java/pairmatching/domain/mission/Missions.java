package pairmatching.domain.mission;

import java.util.List;
import java.util.Optional;

public class Missions {
    private final List<String> missions;

    public Missions(List<String> missions) {
        this.missions = missions;
    }

    public void addMission(String mission) {
        missions.add(mission);
    }

    public Optional<String> getMission(String mission) {
        return missions.stream().filter(m -> m.equals(mission)).findFirst();
    }

    @Override
    public String toString() {
        return String.join(" | ", missions);
    }

}
