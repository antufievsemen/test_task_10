package exception;

public class CardTypeMismatchException extends RuntimeException {
    public CardTypeMismatchException() {
        super("Wrong card type");
    }
}
