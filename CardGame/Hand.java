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

    // CONSTRUCTORS
    public Hand() {
        this.handSize = STANDARD_HAND_SIZE;
        this.cardsInHand = new Card[handSize];
    }

    public Hand( int handSize ) {
        this.handSize = handSize;
        this.cardsInHand = new Card[handSize];
    }

    // METHODS
    public void drawNewHandFrom( Deck deck ) {
        Card[] newHand = new Card[handSize];
        for(int i = 0; i < handSize; i++) {
            newHand[i] = deck.drawCardFromTop();
        }
        cardsInHand = newHand;
    }

    public int getHandSize() {
        return this.handSize;
    }

    public Card getCardAt( int index ) {
        if(index <= handSize) {
            return cardsInHand[index];
        } else { throw new ArrayIndexOutOfBoundsException(); }
    }

    @Override
    public String toString() {
        String toString = "Cards in Hand: ";
        for(int i = 0; i < handSize; i++) {
            toString += '\n' + cardsInHand[i].toString();
        }
        return toString;
    }

    public boolean contains( Card card ) {
        for(int i = 0; i < handSize; i++) {
            if(card.equals(cardsInHand[i])) {
                return true;
            } else { continue; }
        }
        return false;
    }

    public int countInHand( int rank ) {
        int count = 0;
        for(int i = 0; i < handSize; i++) {
            if(cardsInHand[i].getRank() == rank) {
                count++;
            } else { continue; }
        }
        return count;
    }

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
