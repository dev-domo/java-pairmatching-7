package pairmatching.domain.pair;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import pairmatching.constants.Course;
import pairmatching.constants.Level;
import pairmatching.domain.Crew;

class PairResultTest {

    @Test
    void haveSamePairCrew(){
        Crew crew1 = new Crew(Course.BACKEND,"가");
        Crew crew2 = new Crew(Course.BACKEND,"나");
        Crew crew3 = new Crew(Course.BACKEND,"다");
        Crew crew4 = new Crew(Course.BACKEND,"라");
        Crew crew5 = new Crew(Course.BACKEND,"마");

        List<Crew> crews1 = new ArrayList<>();
        crews1.add(crew1);
        crews1.add(crew2);
        List<Crew> crews2 = new ArrayList<>();
        crews2.add(crew3);
        crews2.add(crew4);
        crews2.add(crew5);
        List<Crew> crews3 = new ArrayList<>();
        crews3.add(crew1);
        crews3.add(crew2);
        crews3.add(crew3);

        List<PairMember> pairMembers1 = new ArrayList<>();
        pairMembers1.add(new PairMember(crews1));
        pairMembers1.add(new PairMember(crews2));
        List<PairMember> pairMembers2 = new ArrayList<>();
        pairMembers2.add(new PairMember(crews2));
        pairMembers2.add(new PairMember(crews3));

        PairResult pairResult1 = new PairResult(
                Course.BACKEND,
                Level.LEVEL1,
                "자동차 경주"
        );

        PairResult pairResult2 = new PairResult(
                Course.BACKEND,
                Level.LEVEL1,
                "로또"
        );
        pairResult1.addPairMember(pairMembers1);
        pairResult2.addPairMember(pairMembers2);

        assertTrue(pairResult2.haveSamePairCrew(pairResult1));
    }

}