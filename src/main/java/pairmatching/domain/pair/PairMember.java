package pairmatching.domain.pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import pairmatching.domain.Crew;

public class PairMember {
    private final List<Crew> crews;

    public PairMember(List<Crew> crews) {
        validateSize(crews);
        this.crews = crews;
    }


    public void validateSize(List<Crew> crews){
        if(crews.size() != 2 && crews.size() != 3){
            throw new IllegalArgumentException("패어 매칭 인원 오류");
        }
    }

    //todo 동일한 리스트인지 확인
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PairMember pairMember = (PairMember) o;
        int count = 0;
        for(Crew crew : crews) {
            if(pairMember.crews.contains(crew)) {
                count ++;
            }
        }
        return count == crews.size();
    }
    @Override
    public int hashCode() {
        return Objects.hash(crews);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        List<String> crewName = new ArrayList<>(crews.size());
        for(Crew crew : crews) {
            crewName.add(crew.toString());
        }
        builder.append(String.join(" | ",crewName));
        return builder.toString();
    }

}
