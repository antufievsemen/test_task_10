import enums.CardValue;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RatingSystem {

    public static Rating getRating(List<Card> cards) {
        final boolean isFlush = isFlush(cards);
        final boolean isStraight = isStraight(cards);
        final Map<Character, Integer> pairs = getPairs(cards);
        final CardValue higherValue = getHigherValue(cards);
        return calculateRating(isFlush, isStraight, pairs, higherValue);
    }

    private static boolean isFlush(List<Card> cards) {
        int counter = 0;
        for (int i = 1; i < cards.size(); i++) {
            if (cards.get(0).getCardType() == cards.get(i).getCardType()) counter++;
        }
        return counter == 4;
    }

    private static boolean isStraight(List<Card> cards) {
        for (int i = 1; i < cards.size(); i++) {
            if (cards.get(0).getCardValue().getValue() != cards.get(i).getCardValue().getValue() + i) {
                return false;
            }
        }
        return true;
    }

    private static Map<Character, Integer> getPairs(List<Card> cards) {
        final Map<Character, Integer> result = new HashMap<>();
        for (Card card : cards) {
            final Character displayValue = card.getCardValue().getDisplayValue();
            if (!result.containsKey(displayValue)) {
                result.put(displayValue, 1);
            } else {
                result.put(displayValue, result.get(displayValue) + 1);
            }
        }
        return result;
    }

    private static CardValue getHigherValue(List<Card> cards) {
        return cards.stream()
                .reduce((card, card2) -> {
                    if (card.getCardValue().getValue() - card2.getCardValue().getValue() >= 0) {
                        return card;
                    }
                    return card2;
                }).get().getCardValue();
    }

    private static Rating calculateRating(boolean isFlush, boolean isStraight, Map<Character, Integer> pairs, CardValue higherValue) {
        if (isFlush && isStraight) {
            return new Rating(higherValue, 200);
        }
        if (pairs.containsValue(4)) {
            return new Rating(higherValue, 190);
        }
        if (pairs.containsValue(2) && pairs.containsValue(3)) {
            return new Rating(higherValue, 180);
        }
        if (isFlush) {
            return new Rating(higherValue, 170);
        }
        if (isStraight) {
            return new Rating(higherValue, 160);
        }
        if (pairs.containsValue(3)) {
            return new Rating(higherValue, 150);
        }
        if (pairs.values().stream().filter(integer -> integer == 2).count() == 2) {
            return new Rating(higherValue, 140);
        }
        if (pairs.containsValue(2)) {
            return new Rating(higherValue, 130);
        }
        return new Rating(higherValue, higherValue.getValue());
    }
}
