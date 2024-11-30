package pairmatching.domain;

import java.util.Objects;

public class ThreePairedCrew extends PairedCrew {
    private final String thirdCrew;

    public ThreePairedCrew(final String firstCrew, final String secondCrew, final String thirdCrew) {
        super(firstCrew, secondCrew);
        this.thirdCrew = thirdCrew;
    }

    @Override
    public boolean isEqualCrews(String firstCrew, String secondCrew, String thirdCrew) {
        return Objects.equals(this.firstCrew, firstCrew) &&
                Objects.equals(this.secondCrew, secondCrew) &&
                Objects.equals(this.thirdCrew, thirdCrew);
    }

    @Override
    public String toString() {
        return super.toString() + " : " + thirdCrew;
    }
}
