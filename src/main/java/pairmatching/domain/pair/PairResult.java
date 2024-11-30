package pairmatching.domain.pair;

import java.util.ArrayList;
import java.util.List;
import pairmatching.constants.Course;
import pairmatching.constants.Level;

public class PairResult {
    private final Course course;
    private final Level level;
    private final String mission;
    private final List<PairMember> pairCrews;


    public PairResult(Course course, Level level, String mission) {
        this.course = course;
        this.level = level;
        this.mission = mission;
        this.pairCrews = new ArrayList<>();
    }

    public Course getCourse() {
        return course;
    }


    public boolean isSameLevel(PairResult other) {
        return this.level == other.level;
    }

    public boolean haveSamePairCrew(PairResult other) {
        for(PairMember pairCrew: this.pairCrews) {
            if(other.pairCrews.contains(pairCrew)) {
                return true;
            }
        }
        return false;
    }

    public void addPairMember(List<PairMember> pairMembers) {
        this.pairCrews.addAll(pairMembers);
    }

    public boolean isSameMissionType(PairResult pairResult){
        return this.course.equals(pairResult.course) &&
         this.level.equals(pairResult.level) &&
         this.mission.equals(pairResult.mission);
    }

    public void clearPairCrews(){
        this.pairCrews.clear();
    }

    @Override
    public String toString() {
        StringBuilder printout = new StringBuilder();
        for(PairMember pairMember: this.pairCrews) {
            printout.append(pairMember);
            printout.append("\n");
        }
        return printout.toString();
    }




}
