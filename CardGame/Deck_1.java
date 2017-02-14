import java.util.HashMap;
import java.util.Map;
/**
 * Deck represents a deck of playing cards using French suits that can be drawn
 * from and shuffled.
 */

public class Deck {
    
    // VARIABLES 
    private Card[] cards;

    private int topCardIndex;

    private int cardsDrawn;

    private int deck;

    // CONSTANTS
    public static final int STANDARD_DECK_SIZE = 52; //TODO: Initialize this variable properly!

    // CONSTRUCTORS
    public Deck() {
        this.cards = new Card[STANDARD_DECK_SIZE];
        this.deck = STANDARD_DECK_SIZE;
        this.topCardIndex = 0;
        int cardIndex = 0;
        this.cardsDrawn = 0; 
        for(Card.Suit s : Card.Suit.values()) {
            for(int i = Card.ACE; i <= Card.KING; i++) {
                this.cards[cardIndex] = new Card(i, s);
                cardIndex++;
            }
        }
    }

    public Deck( int copiesPerCard ) {
        if(copiesPerCard > 0) {
            this.cards = new Card[STANDARD_DECK_SIZE * copiesPerCard];
            this.deck = STANDARD_DECK_SIZE * copiesPerCard;
            this.topCardIndex = 0;
            this.cardsDrawn = 0;
            int cardIndex = 0;
            for(Card.Suit s : Card.Suit.values()) {
                for(int i = Card.ACE; i <= Card.KING; i++) {
                    for(int j = 0; j < copiesPerCard; j++) {
                        this.cards[cardIndex] = new Card(i, s);
                        cardIndex++;
                    }
                }
            }
        } else { throw new IllegalArgumentException(); }
    }


    // METHODS
    public int remainingCards() {
        return this.deck - this.cardsDrawn;
    }


    public Card drawCardFromTop() {
        if(remainingCards() > 0) {
            Card topCard = cards[topCardIndex].copyCard();
            cardsDrawn++;
            topCardIndex++;
            return topCard;
        } else { throw new ArrayIndexOutOfBoundsException(); }
    }

    public boolean orderedEquals( Deck otherDeck ) {
        if(otherDeck.equals(this)) {
            for(int i = 0; i < cards.length; i++) {
                if(cards[i].equals(otherDeck.cards[i])) { continue; } 
                else { return false; }
            }
            return true;
        } else { return false; }
    }

    public Card getCardAt( int index ) {
        return cards[index];
    }

    public void setCardAt( int index, Card card ) {
        cards[index] = card;
    }

    public void shuffle() {
        for(int i = 0; i < cards.length; i++) {
            double index = Math.random()*deck;
            Card swap = cards[(int)index];
            cards[(int)index] = cards[i];
            cards[i] = swap;
        }
    }

    public boolean isStandardDeck() {
        Deck standard = new Deck();
        if(standard.equals(this)) {
            return true;
        } else { return false; }
    }

    @Override
    public String toString() {
        String toString = "CURRENT DECK: ";
        for(int i = topCardIndex; i < cards.length; i++) {
            toString += '\n' + cards[i].toString();
        }
        return toString;
    }

    // Advanced Java---Proceed at own risk!
    /**
     * Indicates whether some other object is "equal to" this one,
     * of the same class and containing the same cards in the same amounts,
     * regardless of order.
     *
     * @param obj      the reference object with which to compare.
     * @return         <code>true</code> if this object is equal to the obj
     *                 argument; <code>false</code> otherwise.
     */
    @Override
    public boolean equals( Object obj ) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        Deck other = (Deck)obj;
        // Due to the possibility of duplicates, deck comparison is a notch trickier.
        // Our approach is to count the cards in each deck then ensure that the cards
        // and counts are the same.
        return tally().equals(other.tally());
    }

    /**
     * Returns a Map tallying the number of times each card appears in the Deck.
     *
     * @return         A Map tallying the amounts of each possible
     */
    private Map<Card, Integer> tally() {
        Map<Card, Integer> result = new HashMap<Card, Integer>();
        for (Card card: this.cards) {
            Integer value = result.get(card);
            if (value == null) {
                result.put(card, 1);
            } else {
                result.put(card, value + 1);
            }
        }
        return result;
    }
}
