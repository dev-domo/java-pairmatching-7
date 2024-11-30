package pairmatching.domain.helper;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import pairmatching.constants.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.pair.PairMember;

class PairMemberMatherTest {
    private PairMemberMather pairMemberMather = new PairMemberMather();

    @Test
    void 짝수_매칭_출력_확인(){
        List<Crew> crews = new ArrayList<>();
        crews.add(new Crew(Course.BACKEND,"가"));
        crews.add(new Crew(Course.BACKEND,"나"));
        crews.add(new Crew(Course.BACKEND,"라"));
        crews.add(new Crew(Course.BACKEND,"다"));

        List<PairMember> pairMembers = pairMemberMather.match(crews);

        for (PairMember pairMember : pairMembers) {
            System.out.println(pairMember);
        }
    }

    @Test
    void 홀수_매칭_출력_확인(){
        List<Crew> crews = new ArrayList<>();
        crews.add(new Crew(Course.BACKEND,"가"));
        crews.add(new Crew(Course.BACKEND,"나"));
        crews.add(new Crew(Course.BACKEND,"라"));
        crews.add(new Crew(Course.BACKEND,"다"));
        crews.add(new Crew(Course.BACKEND,"마"));

        List<PairMember> pairMembers = pairMemberMather.match(crews);

        for (PairMember pairMember : pairMembers) {
            System.out.println(pairMember);
        }
    }

}