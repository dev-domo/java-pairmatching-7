package pairmatching.enums;

public enum AnswerMessage {

    YES("네", true),
    NO("아니오", false);

    private final String message;
    private boolean result;

    AnswerMessage(final String message, boolean result) {
        this.message = message;
        this.result = result;
    }

    public boolean convert(String answer) {
        if (answer.equals(YES.message)) {
            return YES.result;
        }
        if (answer.equals(NO.message)) {
            return NO.result;
        }
        throw new IllegalArgumentException(ExceptionMessage.INVALID_ANSWER.valueOf());
    }
}
