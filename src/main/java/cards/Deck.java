package cards;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Deck {
    private LinkedList<Card> cards;

    public Deck() {
        cards = newDeck();
        // START_HIGHLIGHT
        Collections.shuffle(cards);
        // END_HIGHLIGHT
    }

    static LinkedList<Card> newDeck() {
        var cards = new LinkedList<Card>();
        for (var i = 1; i <= 13; i++) {
            cards.add(new Card(i, "C"));
            cards.add(new Card(i, "D"));
            cards.add(new Card(i, "H"));
            cards.add(new Card(i, "S"));
        }
        return cards;
    }

    public Card deal() {
        return cards.removeFirst();
    }

    List<Card> remaining() {
        return cards;
    }
}
