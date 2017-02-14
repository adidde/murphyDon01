/**
 * Hand represents a hand of playing cards using French suits containing a set
 * number of cards.
 */
public class Hand {
    // VARIBALES
    private Card[] cardsInHand;
    private int handSize;

    // COSNTANTS
    public static final int STANDARD_HAND_SIZE = 5; //TODO: Initialize this variable properly!

    /**
     * Constructs an empty hand of the standard hand size.
     */
    public Hand() {
        this.handSize = STANDARD_HAND_SIZE;
        this.cardsInHand = new Card[handSize];
    }

    /**
     * Constructs an empty hand of the provided size.
     * @param handSize     the number of cards the hand can hold
     * @throws IllegalArgumentException    if an non-positive hand size is provided
     */
    public Hand( int handSize ) {
        this.handSize = handSize;
        this.cardsInHand = new Card[handSize];
    }

    /**
     * Draws a new hand from the provided deck, replacing the cards in the hand
     * with the top cards from the deck. The new top card of the deck is the
     * card after the last drawn card.
     *
     * @param deck     the number of cards the hand can hold
     */
    public void drawNewHandFrom( Deck deck ) {
        Card[] newHand = new Card[handSize];
        for(int i = 0; i < handSize; i++) {
            newHand[i] = deck.drawCardFromTop();
        }
        cardsInHand = newHand;
    }

    /**
     * Returns the maximum hand size of this hand.
     *
     * @return          the number of card this hand can hold
     */
    public int getHandSize() {
        return this.handSize;
    }

    /**
     * Returns the card at the given index in this hand.
     *
     * @param index     the index of the card in the hand
     * @return          the card at the provided index in the hand
     */
    public Card getCardAt( int index ) {
        if(index <= handSize) {
            return cardsInHand[index];
        } else { throw new ArrayIndexOutOfBoundsException(); }
    }

    /**
     * Returns a string representation of this hand, including all cards in the
     * hand.
     *
     * @return         a string representation of the hand
     */
    @Override
    public String toString() {
        String toString = "Cards in Hand: ";
        for(int i = 0; i < handSize; i++) {
            toString += '\n' + cardsInHand[i].toString();
        }
        return toString;
    }

    /**
     * Returns whether this hand contains a card of the same rank suit as the
     * provided card.
     *
     * @param card     the card being searched for
     * @return         <code>true</code> if this hand contains an equivalent
     *                 card; <code>false</code> otherwise.
     */
    public boolean contains( Card card ) {
        for(int i = 0; i < handSize; i++) {
            if(card.equals(cardsInHand[i])) {
                return true;
            } else { continue; }
        }
        return false;
    }

    /**
     * Returns the number of cards in this hand with the provided rank.
     *
     * @param rank     the rank being searched for
     * @return         the number of cards in the hand with the provided rank
     * @throws IllegalArgumentException    if an invalid rank is provided
     */
    public int countInHand( int rank ) {
        int count = 0;
        for(int i = 0; i < handSize; i++) {
            if(cardsInHand[i].getRank() == rank) {
                count++;
            } else { continue; }
        }
        return count;
    }

    /**
     * Returns the number of cards in this hand with the provided suit.
     *
     * @param suit     the suit being searched for
     * @return         the number of cards in the hand with the provided suit
     */
    public int countInHand( Card.Suit suit ) {
        int count = 0;
        for(int i = 0; i < handSize; i++) {
            if(cardsInHand[i].getSuit() == suit) {
                count++;
            } else { continue; }
        }
        return count;
    }

    /**
     * Returns the number of cards in this hand with the "face" ranks of King,
     * Queen, and Jack.
     *
     * @return         the number of cards in the hand with face ranks
     */
    public int countOfFaceCards() {
        throw new UnsupportedOperationException();
        //TODO: Complete this method!
    }
}
