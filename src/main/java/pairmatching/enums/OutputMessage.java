package pairmatching.enums;

public enum OutputMessage {
    CHOICE_FEATURE("기능을 선택하세요.\n"),
    SEPARATOR("#############################################"),
    INTRODUCE_COURSE("과정: 백엔드 | 프론트엔드\n"),
    INTRODUCE_MISSION("미션:\n"),
    INTRODUCE_LEVELS("  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n" +
            "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n" +
            "  - 레벨3: \n" +
            "  - 레벨4: 성능개선 | 배포\n" +
            "  - 레벨5: \n"),
    CHOICE_COURSE("과정, 레벨, 미션을 선택하세요.\n\"ex) 백엔드, 레벨1, 자동차경주\n"),
    REMATCH("매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n네 | 아니오\n"),
    COMPLETE_REMATCH("초기화되었습니다.\n");

    private final String message;

    OutputMessage(final String message) {
        this.message = message;
    }

    public String valueOf() {
        return message;
    }
}
