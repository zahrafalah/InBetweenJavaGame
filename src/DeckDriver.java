
/**
 * Title: DeckDriver
 * Description: This is a main method that is only used to test out the deck class.
 * the method essentially plays a game of in between and then records and prints
 * out the data collected from the game.
 * @author
 */
public class DeckDriver {


    public static void main(String[] args) {
        int testCases = 0;
        int inBetween = 0;
        int notInBetween = 0;
        int matchesCard = 0;
        int firstCardsMatch = 0;
        Deck myDeck = new Deck();

        for (int i = 0; i < 100; i++) {
            myDeck.shuffle();
            Card card1 = myDeck.nextCard();
            Card card2 = myDeck.nextCard();

            if (card1.compareTo(card2) != 0) {
                Card card3 = myDeck.nextCard();

                if (card2.compareTo(card1) == 1) {
                    if(card3.compareTo(card1) == 1 && card3.compareTo(card2) == -1)
                        inBetween++;
                    else if (card3.compareTo(card1) == 0 || card3.compareTo(card2) == 0)
                        matchesCard++;
                    else
                        notInBetween++;
                } else {
                    if(card3.compareTo(card2) == 1 && card3.compareTo(card1) == -1)
                        inBetween++;
                    else if (card3.compareTo(card1) == 0 || card3.compareTo(card2) == 0)
                        matchesCard++;
                    else
                        notInBetween++;
                }
            } else
                firstCardsMatch++;

            testCases++;
        }
        int instancesRecorded = inBetween + notInBetween + matchesCard + firstCardsMatch;
        System.out.println("Statistics");
        System.out.println("Number of comparisons: " + testCases);
        System.out.println("Number in between: " + inBetween);
        System.out.println("Number not in between: " + notInBetween);
        System.out.println("Number of times when cards matched: " + matchesCard);
        System.out.println("Number of times when the first cards matched: " + firstCardsMatch);
        System.out.println("Number of instances recorded: " + instancesRecorded);



    }

}

