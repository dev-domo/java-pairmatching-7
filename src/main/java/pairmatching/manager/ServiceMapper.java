package pairmatching.manager;

import java.util.HashMap;
import java.util.Map;
import pairmatching.constant.Menu;
import pairmatching.manager.service.ClearPairMatchingService;
import pairmatching.manager.service.DoPairMatchingService;
import pairmatching.manager.service.GetPairMatchingService;
import pairmatching.manager.service.PairMatchingService;

public class ServiceMapper {

    private static final Map<Menu, PairMatchingService> MAPPER = new HashMap<>();

    static {
        MAPPER.put(Menu.DO_PAIR_MATCHING, new DoPairMatchingService());
        MAPPER.put(Menu.GET_PAIR_MATCHING, new GetPairMatchingService());
        MAPPER.put(Menu.CLEAR_PAIR_MATCHING, new ClearPairMatchingService());
    }

    public static void doService(Menu menu) {
        MAPPER.get(menu).doService();
    }
}
