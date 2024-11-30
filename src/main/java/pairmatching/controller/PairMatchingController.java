package pairmatching.controller;

import java.util.ArrayList;
import java.util.List;
import pairmatching.constants.Answer;
import pairmatching.constants.Function;
import pairmatching.constants.Level;
import pairmatching.domain.mission.MissionByLevel;
import pairmatching.domain.mission.Missions;
import pairmatching.domain.pair.PairResult;
import pairmatching.service.PairMatchingService;
import pairmatching.view.Input;
import pairmatching.view.Output;

public class PairMatchingController {
    private PairMatchingService pairMatchingService;

    public void run(){
        MissionByLevel missionByLevel = new MissionByLevel();
        loadMission(missionByLevel);
        pairMatchingService = new PairMatchingService(missionByLevel);
        System.out.println(missionByLevel);

        while(true){
            Output.printFunction();
            Function type = inputfunction();
            if(type.equals(Function.QUIT)){
                break;
            }
            try {
                function(type);
            } catch (IllegalArgumentException e) {
                Output.printError(e.getMessage());
            }
        }
    }

    public void function(Function type){
        if(type.equals(Function.PAIR_MATCHING)){
            PairResult newPairResult = createPairResult();
            if(pairMatchingService.isDuplicateMission(newPairResult)){
                Answer answer = inputAnswer();
                pairMatchingService.handleDuplicateMission(answer, newPairResult);

                if(answer.isYes()){
                    Output.printPairMatchingResult(newPairResult); //??????/
                }
                return;
            }
            pairMatchingService.matching(newPairResult,false);
            Output.printPairMatchingResult(newPairResult);
        } else if (type.equals(Function.PAIR_PRINT)) {
            PairResult newPairResult = createPairResult();
            PairResult foundPairResult = pairMatchingService.printMatching(newPairResult);
            Output.printPairMatchingResult(foundPairResult);
        } else if (type.equals(Function.PAIR_RESET)) {
            pairMatchingService.resetMatchingHistory();
        }
    }

    public PairResult createPairResult(){
        while (true){
            try{
                String input = Input.inputPairMissionInfo();
                String[] tokens = input.split(",");
                List<String> trimToken = new ArrayList<>();
                if(tokens.length != 3){
                    throw new IllegalArgumentException("과정, 레벨, 미션 3가지를 입력해주세요");
                }
                for (String token : tokens) {
                    trimToken.add(token.trim());
                }

                String course = trimToken.get(0);
                String level = trimToken.get(1);
                String mission = trimToken.get(2);

                return pairMatchingService.makePairResult(course, level, mission);
            }catch (IllegalArgumentException e){
                Output.printError(e.getMessage());
            }
        }
    }

    public Answer inputAnswer(){
        while (true){
            try{
                return Answer.find(Input.inputAnswer());
            }catch (IllegalArgumentException e){
                Output.printError(e.getMessage());
            }
        }
    }


    public Function inputfunction(){
        while (true){
            try{
                return Function.find(Input.inputFunctionType());
            }catch (IllegalArgumentException e){
                Output.printError(e.getMessage());
            }
        }
    }


    public void loadMission(MissionByLevel missionByLevel){
        Missions level1 = new Missions(new ArrayList<>(List.of(
                "자동차경주","로또","숫자야구게임")));
        Missions level2 = new Missions(new ArrayList<>(List.of(
                "장바구니","결제","지하철노선도")));
        Missions level3 = new Missions(new ArrayList<>());
        Missions level4 = new Missions(new ArrayList<>(List.of(
                "성능개선","베포")));
        Missions level5 = new Missions(new ArrayList<>());

        missionByLevel.addLevelAndMission(Level.LEVEL1,level1);
        missionByLevel.addLevelAndMission(Level.LEVEL2,level2);
        missionByLevel.addLevelAndMission(Level.LEVEL3,level3);
        missionByLevel.addLevelAndMission(Level.LEVEL4,level4);
        missionByLevel.addLevelAndMission(Level.LEVEL5,level5);
    }

}
