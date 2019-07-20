import java.util.Scanner;


public class GameDriver {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        House house;
        Person player1;
        String player1Name;
        String input;
        boolean done = false;
        System.out.println("What is your name?");
        player1Name = stdin.nextLine();
        System.out.println("You start with $100. The buyin is $20. Do you wish to play? [Y/N]");
        input = stdin.nextLine();
        if (!input.equals("Y")) {
            System.out.println("OK, next time");
        } else
        {
            player1 = new Person(player1Name,100);
            player1.buyIn(20);
            house = new House(20);
            do {
                house.playHand(player1);
                if (!player1.getActivePlayer())
                    done = true;
                else if (house.getPot() == 0)
                    done = true;
                else {
                    System.out.println("The pot is now at " + house.getPot());
                    System.out.println("Press return to continue or any key to quit");
                    input = stdin.nextLine();
                    if (input.length() > 0)
                        done = true;
                }
            } while (!done);

            if (player1.getBankroll() <= 0)
                System.out.println("Loser");

            else if (house.getPot() <= 0)
                System.out.println("Winner");
        }
    }

}
