package pairmatching.view;

import pairmatching.constants.Function;
import pairmatching.domain.pair.PairResult;

public class Output {

    public static void printError(String error) {
        System.out.printf("[ERROR] %s\n", error);
    }

    public static void printPairMatchingResult(PairResult pairResult){
        System.out.println("페어 매칭 결과입니다.");
        System.out.println(pairResult);

    }

    public static void printFunction(){
        for(Function function : Function.values()){
            System.out.println(function);
        }
    }
}
