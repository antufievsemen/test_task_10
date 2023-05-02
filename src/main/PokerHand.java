import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PokerHand implements Comparable<PokerHand> {
    private final List<Card> cards;
    private final Rating rating;

    public PokerHand(String str) {
        final String[] rawCards = str.split(" ");
        this.cards = Arrays.stream(rawCards)
                .map(Card::new)
                .collect(Collectors.toList());
        this.rating = RatingSystem.getRating(cards);
    }

    public List<Card> getCards() {
        return cards;
    }

    public Rating getRating() {
        return rating;
    }

    @Override
    public int compareTo(PokerHand o) {
        return o.getRating().getValue() - this.rating.getValue();
    }
}
