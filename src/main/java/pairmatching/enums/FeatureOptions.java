package pairmatching.enums;

public enum FeatureOptions {
    PAIR_MATCHING("1", "1. 페어 매칭\n"),
    PAIR_CHECK("2", "2. 페어 조회\n"),
    PAIR_RESET("3", "3. 페어 초기화\n"),
    QUIT("Q", "종료\n");

    private final String option;
    private final String content;

    FeatureOptions(final String option, final String content) {
        this.option = option;
        this.content = content;
    }

    public String valueOf() {
        return content;
    }

    public void validate(String answer) {
        if (!answer.equals(PAIR_MATCHING) && !answer.equals(PAIR_CHECK) && !answer.equals(PAIR_RESET) && !answer.equals(
                QUIT)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_ANSWER.valueOf());
        }
    }
}
