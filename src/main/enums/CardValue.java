package enums;

import exception.CardTypeMismatchException;
import exception.CardValueMismatchException;
import java.util.Arrays;

public enum CardValue {
    ONE('1', 1),
    TWO('2', 2),
    THREE('3', 3),
    FOUR('4', 4),
    FIVE('5', 5),
    SIX('6', 6),
    SEVEN('7', 7),
    EIGHT('8', 8),
    NINE('9', 9),
    TEN('T', 10),
    JACK('J', 11),
    QUEEN('Q', 12),
    KING('K', 13),
    ACE('A', 14);

    CardValue(Character displayValue, int value) {
        this.displayValue = displayValue;
        this.value = value;
    }

    private final Character displayValue;
    private final int value;

    public Character getDisplayValue() {
        return displayValue;
    }

    public int getValue() {
        return value;
    }

    public static CardValue of(Character elem) {
        return Arrays.stream(CardValue.values())
                .filter(cardType -> cardType.getDisplayValue().equals(elem))
                .findFirst().orElseThrow(CardValueMismatchException::new);
    }


}
