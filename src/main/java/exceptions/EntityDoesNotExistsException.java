package exceptions;

public class EntityDoesNotExistsException extends Exception {
    public EntityDoesNotExistsException(String message) {
        super(message);
    }
}
