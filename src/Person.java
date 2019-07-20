/**
 * Person class
 * This class will model a single person(Player in the game).
 * It will keep track of players status in each fields.
 * @author Zahra Falah
 * Final project CSC205
 */
public class Person {

    //Instance variables
    private final String name;    // The name of the person playing. Probably just a first name, but no restrictions.
    private double bankroll;  //The amount the person has to play
    private double bet;   //Amount that a player bets on a hand. Can't exceed bankroll
    private boolean activePlayer; //Boolean that tells if the player is still in the game


    //Methods
    //constructor
    /**
     * Constructor
     * Build the game and a new player by setting a name and a new bankroll.
     * setting bet and activePlayer to default amounts
     */
    public Person(String name, double bankroll){

        this.name = name;
        this.bankroll = bankroll;
        bet = 0.0;
        activePlayer = true;

    }



    //Getters

    /**
     * In Order to access the players name
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * InOrder to access the player's bankroll
     * @return bankroll
     */
    public double getBankroll() {
        return bankroll;
    }

    /**
     * Accessing the player's bet
     * @return bet
     */
    public double getBet() {
        return bet;
    }

    /**
     * Accessing the Player
     * @return Boolean activePlayer
     */
    public boolean getActivePlayer() { return activePlayer; }


    //Setters

    /**
     * sstter for BuyIn to
     * Reduced bankroll by buyingAmount and sets activeplayer to true. and reduce the amount of bankroll
     * @param buyingAmount
     */
    public void buyIn(double buyingAmount) {
        if (bankroll > buyingAmount) {
            bankroll -= buyingAmount;
            activePlayer = true;
        }
    }

    /**
     * Setter for activePlayer.
     * It is used to remove player from the game by setting it to false.
     */
    public void setActivePlayer()
    {
        activePlayer = !activePlayer;
    }

    /**
     * Set Bet
     * Used to save the bet placed by the player.
     * Used to clear the bet when hand is complete.
     * Throws an IllegalBetException if the amount of the bet is more than the bankroll.
     * @param money
     */
      public void setBet(double money) throws IllegalBetException
    {
        if (bankroll >= money){
            bet = money;
        }else{
            throw new IllegalBetException("OoPSss!! There is not enough money to bet!");
        }
    }

    /**
     * Setter for bankroll.
     * Used to add winning hands and deduct losing hands.
     * If bankroll is less than or equal to zero, activePlayer is set to false.
     * @param money
     */
    public void setBankroll(double money) {
        bankroll += money;
        if (bankroll <= 0){
            activePlayer = false;
        }
    }



    //equals method(Optional)
    /**
     * equal method check if the to players are the same by their name
     * @param otherPerson Person Object
     * @return boolean
     */
    public boolean equals(Person otherPerson) {
        return this.name.equals(otherPerson.name);
    }


    //compareTo method(Optional)
    /**
     *Compare method
     * check to see which player have more money in their bank
     * @param otherPerson
     * @return
     */
    public int compareTo(Person otherPerson) {
        if (this.bankroll == otherPerson.getBankroll()) {
            //if they have same amount
            return 0;
        } else if (this.bankroll < otherPerson.getBankroll()) {
            //if other person has more money
            return 1;
        } else {
            //if other person has less money
            return -1;
        }
    }

}
