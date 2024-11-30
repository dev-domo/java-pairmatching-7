package pairmatching.domain.reader;

public enum ResourcePath {
    BACKEND_CREW("src/main/resources/backend-crew.md"),
    FRONTEND_CREW("src/main/resources/frontend-crew.md");

    private final String path;

    ResourcePath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

}
