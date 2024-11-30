package pairmatching.domain;

public enum Mission {
    CAR_RACING("자동차경주"),
    LOTTO("로또"),
    NUMBER_BASEBALL("숫자야구게임"),
    CART("장바구니"),
    PAYMENT("결제"),
    SUBWAY_LINES("지하철노선도"),
    IMPROVE_FEATURE("성능개선"),
    DISTRIBUTION("배포");

    private final String name;

    Mission(final String name) {
        this.name = name;
    }
}
