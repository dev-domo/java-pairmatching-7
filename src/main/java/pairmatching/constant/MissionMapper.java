package pairmatching.constant;

import java.util.HashMap;
import java.util.Map;
import pairmatching.PairMatching;

public class MissionMapper {

    private static final Map<Level, String> map = new HashMap<>();

    static {
        map.put(Level.LEVEL1, "자동차경주");
        map.put(Level.LEVEL1, "로또");
        map.put(Level.LEVEL1, "숫자야구게임");

        map.put(Level.LEVEL2, "장바구니");
        map.put(Level.LEVEL2, "결제");
        map.put(Level.LEVEL2, "지하철노선도");

        map.put(Level.LEVEL4, "성능개선");
        map.put(Level.LEVEL4, "배포");
    }
}
