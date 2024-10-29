package exceptions;

public class InvalidPaymentModeException extends Exception {
    public InvalidPaymentModeException(String message) {
        super(message);
    }
}
