package pairmatching.domain;

import java.util.Objects;

public class PairedCrew {
    private final Crew firstCrew;
    private final Crew secondCrew;

    public PairedCrew(final Crew firstCrew, final Crew secondCrew) {
        this.firstCrew = firstCrew;
        this.secondCrew = secondCrew;
    }

    public boolean isEqualCrews(Crew firstCrew, Crew secondCrew) {
        return Objects.equals(this.firstCrew, firstCrew) && Objects.equals(this.secondCrew, secondCrew);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof PairedCrew that)) {
            return false;
        }
        return Objects.equals(firstCrew, that.firstCrew) && Objects.equals(secondCrew, that.secondCrew);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstCrew, secondCrew);
    }
}
