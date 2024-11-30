package pairmatching;

import pairmatching.exception.CustomException;
import pairmatching.manager.PairMatchingRunner;

public class Application {
    public static void main(String[] args) {
        try {
            PairMatchingRunner runner = new PairMatchingRunner();
            runner.run();
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
    }
}
