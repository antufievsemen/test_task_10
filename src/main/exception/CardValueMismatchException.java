package exception;

public class CardValueMismatchException extends RuntimeException {
    public CardValueMismatchException() {
        super("Wrong card value");
    }
}
