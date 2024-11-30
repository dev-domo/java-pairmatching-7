package pairmatching.exception;

public enum ErrorMessage {

    INVALID_CREW_NAME("크루 이름이 유효하지 않습니다."),
    NOT_FOUND_PAIR_MATCHING("매칭 이력이 없습니다."),
    INVALID_MENU("존재하지 않는 메뉴입니다. 다시 입력해주세요."),
    INVALID_COURSE_OF_SELECTION("존재하지 않는 코스입니다. 다시 입력해주세요."),
    INVALID_LEVEL_OF_SELECTION("존재하지 않는 레벨입니다. 다시 입력해주세요."),
    INVALID_MISSION_OF_SELECTION("존재하지 않는 미션입니다. 다시 입력해주세요."),
    INVALID_MATCHING_SIZE("페어 매칭은 최대 3명까지 가능합니다."),
    INVALID_YES_OR_NO("네 혹은 아니오로 입력해주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
