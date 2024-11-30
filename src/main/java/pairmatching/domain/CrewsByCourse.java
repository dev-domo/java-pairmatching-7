package pairmatching.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import pairmatching.constants.Course;
import pairmatching.domain.helper.PairMemberMather;
import pairmatching.domain.pair.PairMember;
import pairmatching.domain.pair.PairResult;
import pairmatching.domain.reader.BackendReader;
import pairmatching.domain.reader.FrontendReader;

public class CrewsByCourse {
    private final List<Crew> backend;
    private final List<Crew> frontEnd;

    public CrewsByCourse(BackendReader backendReader, FrontendReader frontendReader) {
        List<Crew> backend = backendReader.read();
        List<Crew> frontEnd = frontendReader.read();
        validateDuplicates(backend, frontEnd);
        this.backend = backend;
        this.frontEnd = frontEnd;
    }

    public void matchCrewPair(PairResult pairResult, PairMemberMather pairMemberMather){
        List<Crew> crews = findCrewByCourse(pairResult);
        List<PairMember> backendResult = pairMemberMather.match(crews);
        pairResult.addPairMember(backendResult);
    }

    private List<Crew> findCrewByCourse(PairResult pairResult){
        if(pairResult.getCourse().equals(Course.BACKEND)){
            return backend;
        }else if(pairResult.getCourse().equals(Course.FRONTEND)){
            return frontEnd;
        }
        return null;
    }

    public void matchFrontPair(){

    }


    public static void validateDuplicates(List<Crew> backends, List<Crew> frontEnds) {
        Set<Crew> back = new HashSet<>();
        for (Crew backend : backends) {
            if (!back.add(backend)) {
                throw new IllegalArgumentException("중복된 백엔드 크루가 있어요.");
            }
        }
        Set<Crew> front = new HashSet<>();
        for (Crew fontend : frontEnds) {
            if (!front.add(fontend)) {
                throw new IllegalArgumentException("중복된 프론트 크루가 있어요.");
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Crew crew : backend) {
            builder.append(crew.toString()).append("\n");
        }
        for (Crew crew : frontEnd) {
            builder.append(crew.toString()).append("\n");
        }
        return builder.toString();
    }


}
