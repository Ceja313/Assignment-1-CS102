
import java.util.Scanner;


public class Assignment1 {

    private static final Assignment1 assignment = new Assignment1();

    private static final TennisDatabase DATABASE = new TennisDatabase();

    private static final TennisMatchesContainer TMC = new TennisMatchesContainer();

    private static final TennisPlayersContainer TPC = new TennisPlayersContainer();

    public static void main(String[] args) {
        assignment.displayUserOptions();
        DATABASE.loadFromFile(args);

    }

    private void displayUserOptions() {
        System.out.println("Welcome to the CS-102 Tennis Manager");
        int selection;
        do {
            System.out.println("Available Commands:");
            System.out.println("1 -- Print all tennis players");
            System.out.println("2 -- Print all tennis matches of a player");
            System.out.println("8 -- Exit");
            System.out.print("Enter your selection : ");
            Scanner userInput = new Scanner(System.in);
            selection = userInput.nextInt();

            switch (selection) {
                case 1:
                    printAllTennisPlayers();
                    break;
                case 2:
                    printAllTennisMatchesOfAPlayer(userInput);
                    break;
                case 8:
                    System.out.println("I hope you had fun!");
                default:
                    System.out.println("Input is not a valid option.");
            }

        } while (selection != 8);
    }

    private void printAllTennisPlayers() {

    }

    private void printAllTennisMatchesOfAPlayer(Scanner userInput) {
        System.out.print("Enter Tennis Players Id : ");
        int selection = userInput.nextInt();
        System.out.println(selection);

    }
}
