package pairmatching.enums;

public enum ExceptionMessage {
    NOT_FOUND_FILE("[ERROR] 파일을 찾을 수 없습니다.");

    private String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String valueOf() {
        return message;
    }
}
