package enums;

import exception.CardTypeMismatchException;
import java.util.Arrays;

public enum CardType {
    DIAMONDS('D'),
    SPADES('S'),
    HEARTS('H'),
    CLUBS('C');

    private final Character type;

    CardType(Character type) {
        this.type = type;
    }

    public Character getType() {
        return type;
    }

    public static CardType of(Character elem) {
        return Arrays.stream(CardType.values())
                .filter(cardType -> cardType.getType().equals(elem))
                .findFirst().orElseThrow(CardTypeMismatchException::new);
    }
}
