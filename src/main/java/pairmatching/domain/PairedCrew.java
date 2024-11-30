package pairmatching.domain;

import java.util.Objects;

public class PairedCrew {
    private static final String NAME_SEPARATOR = " : ";

    private final String firstCrew;
    private final String secondCrew;

    public PairedCrew(final String firstCrew, final String secondCrew) {
        this.firstCrew = firstCrew;
        this.secondCrew = secondCrew;
    }

    public boolean isEqualCrews(String firstCrew, String secondCrew) {
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

    @Override
    public String toString() {
        return firstCrew + NAME_SEPARATOR + secondCrew;
    }
}
