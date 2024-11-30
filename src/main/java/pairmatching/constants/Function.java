package pairmatching.constants;

import org.junit.jupiter.api.Test;

public enum Function {
    PAIR_MATCHING("1","페어 매칭"),
    PAIR_PRINT("2","페어 조회"),
    PAIR_RESET("3","페어 초기화"),
    QUIT("Q","종료");

    private final String value;
    private final String description;

    Function(String value, String description) {
        this.value = value;
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    public static Function find(String value) {
        for (Function f : values()) {
            if (f.value.equals(value)) {
                return f;
            }
        }
        throw new IllegalArgumentException("존재하지 않는 기능입니다.");
    }

    @Override
    public String toString() {
        return String.format("%s. %s", value, description);
    }

}
