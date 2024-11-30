package pairmatching.service;

import java.util.Optional;
import pairmatching.constants.Answer;
import pairmatching.constants.Course;
import pairmatching.constants.Level;
import pairmatching.domain.CrewsByCourse;
import pairmatching.domain.helper.MissionMatcher;
import pairmatching.domain.helper.PairMemberMather;
import pairmatching.domain.mission.MissionByLevel;
import pairmatching.domain.pair.PairMatchingHistory;
import pairmatching.domain.pair.PairResult;
import pairmatching.domain.reader.BackendReader;
import pairmatching.domain.reader.FrontendReader;

public class PairMatchingService {
    private final PairMatchingHistory pairMatchingHistory;
    private final CrewsByCourse crewsByCourse; //note 밖?
    private final MissionByLevel missions; //note 밖
    private final MissionMatcher missionMatcher;
    private final PairMemberMather pairMemberMather;

    public PairMatchingService(MissionByLevel missions) {
        this.pairMatchingHistory = new PairMatchingHistory();
        this.crewsByCourse = new CrewsByCourse(
                new BackendReader(),
                new FrontendReader()
        );
        this.missions = missions;

        this.missionMatcher = new MissionMatcher();
        this.pairMemberMather = new PairMemberMather();
    }


    public PairResult makePairResult(String inputCourse, String inputLevel, String inputMission){
        Course course = Course.find(inputCourse);
        Level level = Level.find(inputLevel);
        String mission = missions.findMission(inputMission);

        return new PairResult(course, level, mission);
    }

    public boolean isDuplicateMission(PairResult newPairResult){
        return pairMatchingHistory.isContainSameMissionType(newPairResult);
    }

    public void handleDuplicateMission(Answer answer,PairResult newPairResult){
        if(answer.isYes()){
            //note 다시 매칭
            matching(newPairResult,true);
        }
    }

    public void matching(PairResult newPairResult,boolean isAgain){
        int count = 3;
        while (count > 0) {
            matchByCourse(newPairResult,isAgain);
            if(!pairMatchingHistory.haveDuplicateCrewPairAtSameLevel(newPairResult)){
                pairMatchingHistory.addPairMissionType(newPairResult);
                return;
            }
            count --;
        }
        throw new IllegalArgumentException("매칭 가능한 경우의 수가 없습니다.?????");
    }

    private void matchByCourse(PairResult newPairResult, boolean isAgain) {
        if(isAgain){
            Optional<PairResult> sameHistory = pairMatchingHistory.findByPairResult(newPairResult);
            if(sameHistory.isPresent()){
                PairResult sameHistoryResult = sameHistory.get();
                sameHistoryResult.clearPairCrews();
                crewsByCourse.matchCrewPair(sameHistoryResult,pairMemberMather);
            }
            return;
        }
        crewsByCourse.matchCrewPair(newPairResult,pairMemberMather);
    }


    public PairResult printMatching(PairResult newPairResult){
        Optional<PairResult> sameHistory = pairMatchingHistory.findByPairResult(newPairResult);
        if(sameHistory.isPresent()){
            return sameHistory.get();
        }
        throw new IllegalArgumentException("매칭 이력이 없습니다.");
    }

    public void resetMatchingHistory(){
        pairMatchingHistory.allClearHistory();
    }

}
