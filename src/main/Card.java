import enums.CardType;
import enums.CardValue;
import exception.CardCreateException;

public class Card {
    private final CardValue cardValue;
    private final CardType cardType;

    public Card(String str) {
        if (str.length() > 2) {
            throw new CardCreateException();
        }
        this.cardValue = CardValue.of(str.charAt(0));
        this.cardType = CardType.of(str.charAt(1));
    }

    public CardValue getCardValue() {
        return cardValue;
    }

    public CardType getCardType() {
        return cardType;
    }


}
