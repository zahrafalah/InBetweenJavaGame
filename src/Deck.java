
import java.util.Random;

/**
 * Title: Deck
 * Description: This class represents a physical deck of playing cards
 * @author
 */

public class Deck /*implements Iterator*/ {
    private Card[] cardDeck = new Card[52];
    private int remainingCards = 0;

    /**
     * Title: Constructor
     * Description: Creates a full deck of 52 cards;
     */
    public Deck() {
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
                cardDeck[remainingCards++] = new Card(j,i);
            }
        }

    }

    /**
     * Title: shuffle
     * Description: Takes the cards and places them at random places within the deck.
     * It also resets the remaining cards to 52 cards.
     */
    public void shuffle() {
        Card temp;
        Random rand = new Random();
        remainingCards = 52;
        for (int i = 0; i < 501; i++) {
            int card1Index = rand.nextInt(remainingCards);
            int card2Index = rand.nextInt(remainingCards);

            temp = cardDeck[card1Index];
            cardDeck[card1Index] = cardDeck[card2Index];
            cardDeck[card2Index] = temp;

        }
    }

    /**
     * Title: toString
     * Description: Returns a String representation of the Deck object.
     * @return
     */
    public String toString() {
        String deckList = "";
        for (int i = remainingCards - 1; i > -1 ; i--) {
            deckList += cardDeck[i].getSuit() + " of " + cardDeck[i].getName() + "\n";
        }

        return deckList;
    }

    /**
     * Title: getRemainingCards
     * Description: Returns an int value that represents how many cards can be drawn
     * form the deck.
     * @return
     */
    public int getRemainingCards() {
        int remainder = remainingCards;
        return remainder;
    }

    /**
     * Title: hasNext
     * Description: Checks to see if a card is available to be drawn and returns
     * true if a card can be drawn and false if a card cannot be drawn
     * @return
     */
    public boolean hasNext() {
        if (getRemainingCards() <= 0)
            return false;
        return true;
    }

    /**
     * Title: nextCard
     * Description: Takes the next available card from the deck and returns it
     * to the method caller. It also decrements the remaining cards variable.
     * @return
     */
    public Card nextCard() {
        if (hasNext() == true) {
            Card returnCard = cardDeck[remainingCards-1];
            remainingCards--;
            return returnCard;
        }
        return null;
    }

    /**
     * Title: hasCard
     * Description: Checks the deck of cards for a card that matches the name
     * and suit value of the parameters. Returns true if the card is found and
     * false if it is not found.
     * @param suit
     * @param name
     * @return
     */
    public boolean hasCard(String suit, int name) {
        for (int i = remainingCards - 1; i > -1 ; i--) {
            if (cardDeck[i].getSuit().equals(suit) && cardDeck[i].getName() == name)
                return true;
        }
        return false;
    }




}


