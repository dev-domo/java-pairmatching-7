package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Crews {
    private final List<Crew> crews;

    public Crews(final List<Crew> crews) {
        this.crews = crews;
    }

    public List<String> shuffleCrews() {
        List<Crew> shuffledCrews = Randoms.shuffle(crews);
        return shuffledCrews.stream()
                .map(Crew::getName)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Crews crews1)) {
            return false;
        }
        return Objects.equals(crews, crews1.crews);
    }

    @Override
    public int hashCode() {
        return Objects.hash(crews);
    }
}
