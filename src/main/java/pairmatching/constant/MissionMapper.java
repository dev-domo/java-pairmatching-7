package pairmatching.constant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MissionMapper {

    private static final Map<Level, List<String>> MAPPER = new HashMap<>();

    static {
        Arrays.stream(Level.values())
                .forEach(level -> MAPPER.put(level, new ArrayList<>()));

        MAPPER.get(Level.LEVEL1).add("자동차경주");
        MAPPER.get(Level.LEVEL1).add("로또");
        MAPPER.get(Level.LEVEL1).add("숫자야구게임");

        MAPPER.get(Level.LEVEL2).add("장바구니");
        MAPPER.get(Level.LEVEL2).add("결제");
        MAPPER.get(Level.LEVEL2).add("지하철노선도");

        MAPPER.get(Level.LEVEL4).add("성능개선");
        MAPPER.get(Level.LEVEL4).add("배포");
    }

    public static String getMissions() {
        return Arrays.stream(Level.values())
                .map(MissionMapper::getMissions).collect(Collectors.joining("\n"));
    }

    private static String getMissions(Level level) {
        return "  - " + level.toString() + ": " +
                String.join(" | ", MAPPER.get(level));
    }
}
