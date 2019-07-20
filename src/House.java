import java.util.Scanner;


/**
 * Description: The house object handles the playing of one single hand.
 * It will keep track of all cards deck and bet in the game.
 * @author Zahra Falah
 * Class CSC 205
 */
public class House {

    //Constant variable
    private static final double MIN_BET = 2.0;
    //Instance variables
    private double pot; //Amount of the pot in the play
    private Deck deck;   // the card deck to be used
    private Card card1;  // first card to be dealt
    private Card card2;  // second card to be dealt
    private Card card3;  // third card to be dealt
    private double currBet; // Player's current bet




    //Constructor
    /**
     * Constructor
     * that receives the amount of the buyIn and
     * sets the Pot (Number of players times buyIn)
     */
    public House(double buyIn){
        deck = new Deck();         // instantiate a deck to start a play
        pot = buyIn;               // Sets the pot equal to the buy in


    }

    //Methods
    //Getters

    /**
     * This Method will return the current value of the pot
     * @return
     */
    public double getPot() {
        return pot;
    }

    /**
     * This method will return the current Deck
     * @return
     */
    public Deck getDeck() {
        return deck;
    }

    /**
     * This Method will return the first card
     * @return
     */
    public Card getCard1() {
        return card1;
    }

    /**
     * This Method will return the second card
     * @return
     */
    public Card getCard2() {
        return card2;
    }

    /**
     * This will return the third current card
     * @return
     */
    public Card getCard3() {
        return card3;
    }

    //Setters

    /**
     * This method will set the pot to a new value
     * @param pot is a anew amount for pot
     */
    public void setPot(double pot) {
        this.pot = pot;
    }

    /**
     * This method will set the deck to a new deck obj
     * @param deck
     */
    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    /**
     * This Method will set a new value to Card obj for card1
     * @param card1
     */
    public void setCard1(Card card1) {
        this.card1 = card1;
    }

    /**
     * This method will set a new value to Card obj for card2
     * @param card2
     */
    public void setCard2(Card card2) {
        this.card2 = card2;
    }

    /**
     * This method will set a new value to Card obj for card3
     * @param card3
     */
    public void setCard3(Card card3) {
        this.card3 = card3;
    }

    /**
     * This method will return the next card in the deck. If the end of the deck is reached,
     * it shuffles the deck and returns the first card off the deck.
     * @return
     */
    private Card dealCard() {
        //Check to see if the stack has remaining, if not shuffle
        if (!deck.hasNext()) {
            deck.shuffle();
        }
        // Return the top card of the deck
        return deck.nextCard();
    }
    /**
     * PlayHand
     * receives the current player. It only receive a player that is active.
     * It will use the following algorithm:
     */
    public void playHand(Person currPlayer){



        if (!currPlayer.getActivePlayer()) {
            return;     // If the current player isn't active, skip them
        }

        do {                                //keep doing:
            card1 = dealCard();             // get and display card1
            card2 = dealCard();             // get and display card2
        } while (card1.compareTo(card2) == 0);  //until the we make sure cards are different


        System.out.println("CardOne: " + card1);
        System.out.println("CardTwo: " + card2);

        //Getting the amount of bet from player
        try {
            currBet = getBet(currPlayer);        //calling another method to get bet
            card3 = dealCard();                 //get and display card3
            System.out.println("CardThree: " + card3);
        }catch(Exception e){                    //handling any error
            System.out.println(e);
        }

        //Adjusting the pot and players bankroll depending on results of Card1, card2 and card3

        //checking if card3 matches any other card
        if (card3.compareTo(card1) == 0 || card3.compareTo(card2) == 0) {
            //check if the bankroll have enough money
            if ((2.0 * currBet) > currPlayer.getBankroll()) {
                //bankroll added to the pot
                pot += currPlayer.getBankroll();
                currPlayer.setBankroll(-currPlayer.getBankroll());
            } else {
                //player losses twice his bet
                currPlayer.setBankroll(2.0 * -currBet);
                pot += (currBet * 2.0);
            }
            System.out.println("You lose double.");

            //check if card3 is between the other two cards
        } else if (((card3.compareTo(card1) == -1) && (card3.compareTo(card2) == 1)) ||
                ((card3.compareTo(card1) == 1) && (card3.compareTo(card2) == -1))) {

            //player win the bet
            currPlayer.setBankroll(currBet);
            pot -= currBet;
            System.out.println("You win the hand.");

            //last case if the card3 is not in between or matches any other card
        } else {
            currPlayer.setBankroll(-currBet);
            pot += currBet;
            System.out.println("You lose the hand.");
        }
    }

    /**
     * Asks player for a bet. It will keep asking until a valid bet is placed.
     * Must be able to handle an IllegalBetException (wee need a loop and
     * a try/catch for this method). Returns the valid double bet.
     * @param player
     */
    private double getBet(Person player) throws IllegalBetException {

        Scanner stdin = new Scanner(System.in);
        //keeping the player's bet
        double bet = 0.0;
        //checker (flag)to see if the value is valid amount
        boolean isValid = false;

        //creating a problem to be thrown
        IllegalBetException problem =
                new IllegalBetException ("Input value is out of range.");


        do {
            try {
                System.out.print("How much do you want to bet: ");
                bet = stdin.nextDouble();   // Get bet from player
                // check if the bet is negative
                if (bet < 0) {
                    throw problem;
                }
                // check if player's bet is lower than minimum value
                if (bet > 0 && bet < MIN_BET) {
                    throw new IllegalBetException("Your bet must be more than minimum " + "$" + MIN_BET +"!");
                }
                // check if player's bet is greater than pot value
                if (bet > pot) {
                    throw new IllegalBetException("Bet cannot be more than the pot!");
                }
                //Setting the input amount to the player's current bet
                player.setBet(bet);
                //flagging to exit here
                isValid = true;
            }
            catch (IllegalBetException e) {
                System.out.println(e); //handling any err
            }

            //catching any non numeric numbers
            catch (Exception e) {
                System.out.println("Enter a valid number!");
                stdin.nextLine();   //this will clear the buffer
            }
        } while (!isValid);

        return bet;
    }


}
