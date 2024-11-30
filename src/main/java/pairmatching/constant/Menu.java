package pairmatching.constant;

public enum Menu {

    DO_PAIR_MATCHING("1", "페어 매칭"),
    GET_PAIR_MATCHING("2", "페어 조회"),
    INIT_PAIR_MATCHING("3", "페어 초기화"),
    QUIT("Q", "종료");

    private final String number;
    private final String name;

    Menu(String number, String name) {
        this.number = number;
        this.name = name;
    }

    @Override
    public String toString() {
        return number + ". " + name;
    }
}
