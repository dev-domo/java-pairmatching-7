package pairmatching.domain.helper;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import pairmatching.domain.Crew;
import pairmatching.domain.pair.PairMember;
import pairmatching.domain.pair.PairResult;

/**
 * 매칭은 하지만 이전 히스토리를 고려하여 매칭하지는 않는다.
 */
public class PairMemberMather {

    public List<PairMember> match(List<Crew> crews){
        List<PairMember> result = new ArrayList<>();

        Randoms.shuffle(crews);

        for(int i = crews.size() - 1; i >= 0; i--){
            List<Crew> paired = new ArrayList<>();

            paired.add(crews.get(i));
            paired.add(crews.get(i-1));
            i--;
            if(i == 3){
                paired.add(crews.get(i-2));
                i--;
            }
            result.add(new PairMember(paired));

        }
        return result;
    }
}
