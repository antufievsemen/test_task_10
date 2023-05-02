import enums.CardValue;

public class Rating {
    private final int value;
    private final CardValue higherValue;

    public Rating(CardValue higherValue, int value) {
        this.higherValue = higherValue;
        this.value = value;

    }

    public int getValue() {
        return value;
    }

    public CardValue getHigherValue() {
        return higherValue;
    }
}
