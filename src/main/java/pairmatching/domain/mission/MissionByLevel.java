package pairmatching.domain.mission;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import pairmatching.constants.Level;

public class MissionByLevel {
    private final EnumMap<Level,Missions> missions;

    public MissionByLevel() {
        missions = new EnumMap<>(Level.class);
    }

    public void addMission(Level level, String mission) {
        missions.get(level).addMission(mission);
    }

    public String findMission(String name) {
        for(Map.Entry<Level,Missions> entry : missions.entrySet()) {
            Missions missions = entry.getValue();
            Optional<String> missionName = missions.getMission(name);
            if(missionName.isPresent()) {
                return missionName.get();
            }
        }
        throw new IllegalArgumentException("존재하지 않는 미션입니다.");
    }

}
