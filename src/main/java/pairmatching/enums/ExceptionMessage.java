package pairmatching.enums;

public enum ExceptionMessage {
    NOT_FOUND_FILE("[ERROR] 파일을 찾을 수 없습니다."),
    INVALID_ANSWER("[ERROR] 잘못된 입력입니다.");

    private final String message;

    ExceptionMessage(final String message) {
        this.message = message;
    }

    public String valueOf() {
        return message;
    }
}
