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

    public void addLevelAndMission(Level level,Missions missionList){
        missions.put(level,missionList);
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

    @Override
    public String toString() {
        StringBuilder printOut = new StringBuilder();
        printOut.append("#############################################\n");
        printOut.append("과정: 백엔드 | 프론트엔드\n");
        printOut.append("미션:\n");
        for(Map.Entry<Level,Missions> entry : missions.entrySet()) {
            Level level = entry.getKey();
            Missions missions = entry.getValue();
            printOut.append(String.format(
                    "  - %s: %s\n",level.getName(),missions));
        }
        printOut.append("#############################################\n");
        return printOut.toString();
    }

}
