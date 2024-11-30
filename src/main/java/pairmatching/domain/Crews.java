package pairmatching.domain;

import java.util.List;
import java.util.Objects;

public class Crews {
    private final List<Crew> crews;

    public Crews(final List<Crew> crews) {
        this.crews = crews;
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
