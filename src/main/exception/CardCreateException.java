package exception;

public class CardCreateException extends RuntimeException {
    public CardCreateException() {
        super("Card not created");
    }
}
