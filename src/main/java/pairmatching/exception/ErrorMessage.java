package pairmatching.exception;

public enum ErrorMessage {

    INVALID_CREW_NAME("크루 이름이 유효하지 않습니다."),
    NOT_FOUND_PAIR_MATCHING("매칭 이력이 없습니다."),
    INVALID_MENU("존재하지 않는 메뉴입니다. 다시 입력해주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
