package Exceptions;

public class InvalidPrice extends Exception {
    public static void validateIntPrice(String price) throws InvalidPrice {
        try {
            int parsedPrice = Integer.parseInt(price);
            throw new InvalidPrice("The price should not be an integer: " + price);
        } catch (NumberFormatException e) {
            System.out.println("The price is valid: " + price);
        }
    }

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
