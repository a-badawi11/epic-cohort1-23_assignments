public class UserNotFoundException extends Exception {

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }

}
