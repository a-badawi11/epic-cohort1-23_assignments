public class UserNotFoundExceptionRuntime extends RuntimeException {

    public UserNotFoundExceptionRuntime(String message) {
        super(message);
    }

    public UserNotFoundExceptionRuntime(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }

}
