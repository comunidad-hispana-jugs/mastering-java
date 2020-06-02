package org.medellinjug.mastering_java.avoid_checked_exceptions.checked;

public class InvalidArgumentsException extends Throwable {
    public InvalidArgumentsException(String message) {
        super(message);
    }
}
