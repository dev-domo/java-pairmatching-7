package pairmatching.constants;

public enum Answer {
    YES("네",true),
    NO("아니오",false);

    private final String answer;
    private final boolean isYes;

    Answer(String answer, boolean isYes) {
        this.answer = answer;
        this.isYes = isYes;
    }

    public boolean isYes(){
        return isYes;
    }


    public static Answer find(String answer) {
        for (Answer a : Answer.values()) {
            if (a.answer.equals(answer)) {
                return a;
            }
        }
        throw new IllegalArgumentException("네, 아니오로 입력해주세요.");
    }
}
