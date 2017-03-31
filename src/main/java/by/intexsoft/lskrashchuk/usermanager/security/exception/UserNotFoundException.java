package by.intexsoft.lskrashchuk.usermanager.security.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String message) {
        super(message);
    }
}
