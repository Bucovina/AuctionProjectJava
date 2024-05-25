package Exceptions;

public class InvalidPrice extends Exception {
    public InvalidPrice() {
        super();
    }

    public InvalidPrice(String message) {
        super(message);
    }

    public InvalidPrice(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidPrice(Throwable cause) {
        super(cause);
    }
}
