package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static String inputFunctionType(){
        System.out.println("기능을 선택하세요.");
        return Console.readLine();
    }

    public static String inputPairMissionInfo(){
        System.out.println("과정, 레벨, 미션을 선택하세요.");
        System.out.println("ex) 백엔드, 레벨1, 자동차경주");
        return Console.readLine().trim();
    }

    public static String inputAnswer(){
        System.out.println("매칭 정보가 있습니다. 다시 매칭하시겠습니까?");
        System.out.println("네 | 아니오");
        return Console.readLine();
    }

}
