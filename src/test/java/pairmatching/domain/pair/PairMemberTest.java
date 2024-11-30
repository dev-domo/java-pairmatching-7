package pairmatching.domain.pair;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import pairmatching.constants.Course;
import pairmatching.domain.Crew;

class PairMemberTest {

    @Test
    void 동일한_매칭_결과_확인(){
        Crew crew1= new Crew(Course.BACKEND,"크루1");
        Crew crew3= new Crew(Course.BACKEND,"크루1");
        Crew crew2= new Crew(Course.BACKEND,"크루2");

        List<Crew> crews1 = new ArrayList<>();
        List<Crew> crews2 = new ArrayList<>();
        crews1.add(crew1);
        crews1.add(crew2);

        crews2.add(crew1);
        crews2.add(crew2);


        PairMember pairMember1 = new PairMember(crews1);
        PairMember pairMember2 = new PairMember(crews2);

        //assertTrue(pairMember1.isSame(pairMember2));
        assertEquals(pairMember1,pairMember2);
    }

}