import java.util.ArrayList;
import java.util.Collections;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TestPokerHand {

    @Test
    void sortPokerHandFlush() {
        final ArrayList<PokerHand> pokerHands = new ArrayList<>();
        pokerHands.add(new PokerHand("KS 2H 5C JD TD"));
        final PokerHand e = new PokerHand("2C 3C AC 4C 5C");
        pokerHands.add(e);
        Collections.sort(pokerHands);
        Assertions.assertSame(e, pokerHands.get(0));
    }

    @Test
    void sortPokerHandHighCard() {
        final ArrayList<PokerHand> pokerHands = new ArrayList<>();
        pokerHands.add(new PokerHand("KS 2H 5C JD TD"));
        final PokerHand e = new PokerHand("2C 3H AC 4H 5C");
        pokerHands.add(e);
        Collections.sort(pokerHands);
        Assertions.assertSame(e, pokerHands.get(0));
    }

    @Test
    void sortPokerHandStraight() {
        final ArrayList<PokerHand> pokerHands = new ArrayList<>();
        pokerHands.add(new PokerHand("2C 3H 4C 5H 6C"));
        final PokerHand e = new PokerHand("KS 2H 5C JD TD");
        pokerHands.add(e);
        Collections.sort(pokerHands);
        Assertions.assertSame(e, pokerHands.get(0));
    }

    @Test
    void sortPokerHandDraw() {
        final ArrayList<PokerHand> pokerHands = new ArrayList<>();
        pokerHands.add(new PokerHand("2C 3H 4C 5H TC"));
        final PokerHand e = new PokerHand("2S 3C 5C 6D TD");
        pokerHands.add(e);
        Collections.sort(pokerHands);
        Assertions.assertNotSame(e, pokerHands.get(0));
    }

    @Test
    void sortPokerHandFourCard() {
        final ArrayList<PokerHand> pokerHands = new ArrayList<>();
        pokerHands.add(new PokerHand("3C 3H 4C 5H TC"));
        final PokerHand e = new PokerHand("2S 2H 2C 2D TD");
        pokerHands.add(e);
        Collections.sort(pokerHands);
        Assertions.assertSame(e, pokerHands.get(0));
    }

    @Test
    void sortPokerHandFullHouse() {
        final ArrayList<PokerHand> pokerHands = new ArrayList<>();
        pokerHands.add(new PokerHand("3C 3H 3D 5H TC"));
        final PokerHand e = new PokerHand("2S 2H 2C 4D 4H");
        pokerHands.add(e);
        Collections.sort(pokerHands);
        Assertions.assertSame(e, pokerHands.get(0));
    }

    @Test
    void sortPokerHandTwoPair() {
        final ArrayList<PokerHand> pokerHands = new ArrayList<>();
        pokerHands.add(new PokerHand("3S 3H 4C 5H TC"));
        final PokerHand e = new PokerHand("2S 2H 3C 3D TD");
        pokerHands.add(e);
        Collections.sort(pokerHands);
        Assertions.assertSame(e, pokerHands.get(0));
    }

    @Test
    void sortPokerHandThreeCard() {
        final ArrayList<PokerHand> pokerHands = new ArrayList<>();
        pokerHands.add(new PokerHand("3C 3H 4C 5H TC"));
        final PokerHand e = new PokerHand("2S 2H 9C 2D TD");
        pokerHands.add(e);
        Collections.sort(pokerHands);
        Assertions.assertSame(e, pokerHands.get(0));
    }

    @Test
    void sortPokerHandPair() {
        final ArrayList<PokerHand> pokerHands = new ArrayList<>();
        pokerHands.add(new PokerHand("3C KH 4C 5H TC"));
        final PokerHand e = new PokerHand("2S 2H 9C 4D TD");
        pokerHands.add(e);
        Collections.sort(pokerHands);
        Assertions.assertSame(e, pokerHands.get(0));
    }
}
