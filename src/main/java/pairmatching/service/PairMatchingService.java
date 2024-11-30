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

public class PairMatchingService {
    private final PairMatchingHistory pairMatchingHistory;
    private final CrewsByCourse crewsByCourse; //note 밖?
    private final MissionByLevel missions; //note 밖
    private final MissionMatcher missionMatcher;
    private final PairMemberMather pairMemberMather;

    public PairMatchingService(PairMatchingHistory pairMatchingHistory, CrewsByCourse crewsByCourse, MissionByLevel missions) {
        this.pairMatchingHistory = pairMatchingHistory;
        this.crewsByCourse = crewsByCourse;
        this.missions = missions;

        this.missionMatcher = new MissionMatcher();
        this.pairMemberMather = new PairMemberMather();
    }


    /**
     * 한번에 입력받기 때문에 예외처리를 서비스에서 한번에 해주는게 낫다.
     * 만약 같은 미션이 있으면 출력하기
     */

    //note 둘 다 쓰일 수 있음, 등록하고 출력
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
        //다시 입력받기
    }

    /**
     * 다시 매칭 = 다시먀칭
     * 아니오면 처음부터 다시 입력받기
     */

    public void matching(PairResult newPairResult,boolean isAgain){
        /**
         * true = 만약 중복이 된 미션이라 중복이면 해당 PairResult을 찾아서 인원만 업데이트해야하낟.
         * false = 아예 히스토리에 새롭게 추가한다.
         */
        /**
         * 1. 같은 레벨에 중복되는 매칭이 있는지?
         * crewsByCourse에 matcher, pairResult 집어넣기
         * 그 다음 업데ㅣ트된 pairResult를 history에서 중복되는 크루가 존재하는지 확인하기
         */

        /**
         * 매칭이 중복되지 않았는지 확인해야됨
         */
        int count = 3;
        while (count > 0) {
            matchByCourse(newPairResult,isAgain);
            if(!pairMatchingHistory.haveDuplicateCrewPairAtSameLevel(newPairResult)){
                return;
            }
            count --;
        }
        throw new IllegalArgumentException("매칭 가능한 경우의 수가 없습니다.?????");
    }

    private void matchByCourse(PairResult newPairResult, boolean isAgain) {
        if(isAgain){
            Optional<PairResult> sameHistory = pairMatchingHistory.findByPairResult(newPairResult);
            //note 초기화 해줘야ㅎ됨
            if(sameHistory.isPresent()){
                PairResult sameHistoryResult = sameHistory.get();
                sameHistoryResult.clearPairCrews();
                crewsByCourse.matchCrewPair(sameHistoryResult,pairMemberMather);
            }
            return;
        }
        crewsByCourse.matchCrewPair(newPairResult,pairMemberMather);
    }


    ////////////


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
