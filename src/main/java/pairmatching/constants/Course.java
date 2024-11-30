package pairmatching.constants;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트");

    private final String name;

    Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Course find(String name) {
        for (Course c : values()) {
            if (c.getName().equals(name)) {
                return c;
            }
        }
        throw new IllegalArgumentException("존재하지 않는 코스입니다.");
    }

}
