package pairmatching.exception;

public class CustomException extends RuntimeException {

    private static final String ERROR_PREFIX = "[ERROR] ";

    public CustomException(ErrorMessage message) {
        super(ERROR_PREFIX + message.toString());
    }
}

