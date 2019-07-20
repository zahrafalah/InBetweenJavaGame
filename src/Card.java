
/**
 * Title: Card
 * Description: This class represents a physical playing card
 * @author
 */

public class Card {

    private static String[] Suit = {"Spades", "Clubs", "Hearts", "Diamonds"};
    private static int[] Name = {1,2,3,4,5,6,7,8,9,10,11,12,13};

    private String suit;
    private int name;

    /**
     * Title: Constructor
     * Description: Accepts a suit and name index parameter to reference
     * the static arrays holding the card and suite variables
     * @param suit
     * @param name
     */
    public Card(int suit, int name) {
        this.suit = Suit[suit];
        this.name = Name[name];
    }

    /**
     * Title: getName
     * Description: returns the name value
     * @return
     */
    public int getName() {
        return name;
    }

    /**
     * Title: getSuit
     * Description: returns the suit value;
     * @return
     */
    public String getSuit() {
        return suit;
    }

    /**
     * Title: setSuit
     * Description: accepts an int value and takes the Suit array and plugs in that
     * value for the index. That array value is then plugged into the suit variable.
     * @param suit
     */
    private void setSuit(int suit) {
        this.suit = Suit[suit];
    }

    /**
     * Title: setName
     * Description: accepts an int value and takes the Name array and plugs in that
     * value for the index. That array value is then plugged into the name variable.
     * @param name
     */
    private void setName(int name) {
        this.name = Name[name];
    }

    /**
     * Title: equals
     * Description: Returns true if the name and suit of both cards are exactly the same.
     * @param otherCard
     * @return
     */
    public boolean equals(Card otherCard) {
        if (otherCard.name == name && otherCard.suit.equals(suit)) {
            return true;
        }
        return false;
    }

    /**
     * Title: compareTo
     * Description: Returns true if only the name values of both cards are exactly the same.
     * @param otherCard
     * @return
     */
    public int compareTo(Card otherCard) {
        if (otherCard.name == this.name) {
            return 0;
        } else if (otherCard.name > this.name) {
            return 1;
        } else {
            return -1;
        }

    }

    /**
     * Title: toString
     * Description: Returns a String representation of the Card object;
     * @return
     */
    @Override
    public String toString() {
        return name + " of " + suit;
    }




}


